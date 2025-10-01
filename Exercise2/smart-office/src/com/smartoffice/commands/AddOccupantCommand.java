package com.smartoffice.commands;

import com.smartoffice.*;

public class AddOccupantCommand implements Command {
    private final int roomId;
    private final int occupants;

    public AddOccupantCommand(int roomId, int occupants) {
        this.roomId = roomId;
        this.occupants = occupants;
    }

    @Override
    public void execute() {
        OfficeConfig cfg = OfficeConfig.getInstance();
        Room r = cfg.getRoom(roomId);
        if (r == null) {
            System.out.println("Room not found.");
            return;
        }
        if (occupants < 2) {
            r.setOccupants(occupants);
            System.out.printf("Room %d occupancy insufficient to mark as occupied.%n", roomId);
            return;
        }
        r.setOccupants(occupants);
        // if room had pending release and is now occupied, cancel release task
        r.cancelPendingReleaseTask();
        System.out.printf("Room %d is now occupied by %d persons. AC and lights turned on.%n", roomId, occupants);
    }
}
