package com.smartoffice.commands;

import com.smartoffice.*;

public class CancelBookingCommand implements Command {
    private final int roomId;
    public CancelBookingCommand(int roomId) { this.roomId = roomId; }

    @Override
    public void execute() {
        OfficeConfig cfg = OfficeConfig.getInstance();
        Room r = cfg.getRoom(roomId);
        if (r == null) {
            System.out.println("Room not found.");
            return;
        }
        if (r.getBooking() == null) {
            System.out.printf("Room %d is not booked. Cannot cancel booking.%n", roomId);
            return;
        }
        r.clearBooking();
        r.cancelPendingReleaseTask();
        System.out.printf("Booking for Room %d cancelled successfully.%n", roomId);
    }
}
