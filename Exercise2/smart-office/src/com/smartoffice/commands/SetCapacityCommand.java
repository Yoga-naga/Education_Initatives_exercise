package com.smartoffice.commands;

import com.smartoffice.*;

public class SetCapacityCommand implements Command {
    private final int roomId;
    private final int capacity;

    public SetCapacityCommand(int roomId, int capacity) {
        this.roomId = roomId;
        this.capacity = capacity;
    }

    @Override
    public void execute() {
        OfficeConfig cfg = OfficeConfig.getInstance();
        Room r = cfg.getRoom(roomId);
        if (r == null) {
            System.out.println("Room not found.");
            return;
        }
        r.setCapacity(capacity);
        System.out.printf("Room %d maximum capacity set to %d.%n", roomId, capacity);
    }
}
