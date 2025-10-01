package com.smartoffice;

public class ControllerAC implements Observer {
    @Override
    public void update(Room room) {
        if (room.isOccupied()) {
            System.out.printf("Room %d AC turned ON.%n", room.getId());
        } else {
            System.out.printf("Room %d AC turned OFF.%n", room.getId());
        }
    }
}
