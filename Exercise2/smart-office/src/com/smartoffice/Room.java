package com.smartoffice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

public class Room {
    private final int id;
    private int capacity = 10;
    private int occupants = 0;
    private final List<Observer> observers = new ArrayList<>();
    private Booking currentBooking = null;
    // scheduled release task reference
    private ScheduledFuture<?> pendingReleaseTask = null;

    public Room(int id) { this.id = id; }

    public int getId() { return id; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public synchronized void addObserver(Observer o) {
        observers.add(o);
    }
    public synchronized void removeObserver(Observer o) {
        observers.remove(o);
    }
    private synchronized void notifyObservers() {
        for (Observer o : observers) o.update(this);
    }

    public synchronized void setOccupants(int n) {
        this.occupants = n;
        notifyObservers();
    }
    public synchronized int getOccupants() { return occupants; }
    public synchronized boolean isOccupied() { return occupants >= 2; } // per requirement

    public synchronized void setBooking(Booking b) { this.currentBooking = b; }
    public synchronized Booking getBooking() { return currentBooking; }
    public synchronized void clearBooking() { this.currentBooking = null; }

    public synchronized void setPendingReleaseTask(ScheduledFuture<?> task) {
        if (this.pendingReleaseTask != null && !this.pendingReleaseTask.isDone()) {
            this.pendingReleaseTask.cancel(true);
        }
        this.pendingReleaseTask = task;
    }

    public synchronized void cancelPendingReleaseTask() {
        if (this.pendingReleaseTask != null && !this.pendingReleaseTask.isDone()) {
            this.pendingReleaseTask.cancel(true);
        }
        this.pendingReleaseTask = null;
    }
}
