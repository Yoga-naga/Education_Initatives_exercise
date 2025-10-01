package com.smartoffice.commands;

import com.smartoffice.Command;
import com.smartoffice.OfficeConfig;
import com.smartoffice.Room;

public class ConfigureCommand implements Command {
    private final int count;
    public ConfigureCommand(int count) { this.count = count; }
    @Override
    public void execute() {
        OfficeConfig cfg = OfficeConfig.getInstance();
        cfg.configureRooms(count);
        System.out.printf("Office configured with %d meeting rooms:%n", count);
        for (Room r : cfg.getRooms()) System.out.printf("Room %d%s", r.getId(), System.lineSeparator());
    }
}
