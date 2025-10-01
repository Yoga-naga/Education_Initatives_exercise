package com.smartoffice;

import java.time.LocalTime;

public class Booking {
    private final int roomId;
    private final LocalTime start;
    private final int minutes;

    public Booking(int roomId, LocalTime start, int minutes) {
        this.roomId = roomId;
        this.start = start;
        this.minutes = minutes;
    }

    public int getRoomId() { return roomId; }
    public LocalTime getStart() { return start; }
    public int getMinutes() { return minutes; }

    public LocalTime getEnd() {
        return start.plusMinutes(minutes);
    }

    public boolean conflictsWith(Booking other) {
        if (other == null) return false;
        if (this.roomId != other.roomId) return false;
        LocalTime a1 = this.start;
        LocalTime a2 = this.getEnd();
        LocalTime b1 = other.start;
        LocalTime b2 = other.getEnd();
        return !(a2.compareTo(b1) <= 0 || b2.compareTo(a1) <= 0);
    }

    @Override
    public String toString() {
        return String.format("Room %d booked %s for %d min (ends %s)", roomId, start, minutes, getEnd());
    }
}
