package com.example.hostel.behavioral.Observer;

import java.util.*;

public class RoomManager {
    private final List<Student> observers = new ArrayList<>();
    private final Set<String> availableRooms = new HashSet<>();

    public void registerObserver(Student s) {
        if (s == null)
            throw new IllegalArgumentException("Observer cannot be null");
        observers.add(s);
        System.out.println("Student registered successfully.");
    }

    public void removeObserver(Student s) {
        observers.remove(s);
        System.out.println("Removed observer: " + s.getName());
    }

    public void addAvailableRoom(String roomId) {
        if (roomId == null || roomId.isBlank())
            throw new IllegalArgumentException("roomId invalid");
        availableRooms.add(roomId);
        System.out.println("Room " + roomId + " added to available list.");
        notifyAllObservers(roomId);
    }

    private void notifyAllObservers(String roomId) {
        for (Student s : observers) {
            s.update(roomId);
        }
    }
}
