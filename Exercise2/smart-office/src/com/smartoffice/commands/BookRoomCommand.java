package com.smartoffice.commands;

import com.smartoffice.*;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class BookRoomCommand implements Command {
    private final int roomId;
    private final LocalTime start;
    private final int minutes;

    public BookRoomCommand(int roomId, LocalTime start, int minutes) {
        this.roomId = roomId;
        this.start = start;
        this.minutes = minutes;
    }

    @Override
    public void execute() {
        OfficeConfig cfg = OfficeConfig.getInstance();
        Room r = cfg.getRoom(roomId);
        if (r == null) {
            System.out.println("Room not found.");
            return;
        }
        Booking newBooking = new Booking(roomId, start, minutes);
        Booking existing = r.getBooking();
        if (existing != null && existing.conflictsWith(newBooking)) {
            System.out.printf("Room %d is already booked during this time. Cannot book.%n", roomId);
            return;
        }
        r.setBooking(newBooking);
        System.out.printf("Room %d booked from %s for %d minutes.%n", roomId, start, minutes);

        // schedule auto release if room remains unoccupied for 5 minutes from now
        Runnable releaseTask = () -> {
            synchronized (r) {
                if (!r.isOccupied() && r.getBooking() == newBooking) {
                    r.clearBooking();
                    System.out.printf("Booking for Room %d released automatically (not occupied within 5 minutes).%n", roomId);
                    // notify observers so lights/AC remain off
                    r.setOccupants(0);
                }
            }
        };
        // schedule after 5 minutes
        var future = cfg.getScheduler().schedule(releaseTask, 5, TimeUnit.MINUTES);
        r.setPendingReleaseTask(future);
    }
}
