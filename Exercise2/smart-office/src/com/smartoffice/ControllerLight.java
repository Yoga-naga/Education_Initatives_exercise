package com.smartoffice;

public class ControllerLight implements Observer {
    @Override
    public void update(Room room) {
        if (room.isOccupied()) {
            System.out.printf("Room %d lights turned ON.%n", room.getId());
        } else {
            System.out.printf("Room %d lights turned OFF.%n", room.getId());
        }
    }
}
