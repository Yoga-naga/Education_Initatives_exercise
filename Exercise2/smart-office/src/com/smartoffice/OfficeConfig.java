package com.smartoffice;

import java.util.*;
import java.util.concurrent.*;

public class OfficeConfig {
    private static OfficeConfig instance;
    private final Map<Integer, Room> rooms = new LinkedHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);

    private OfficeConfig() {}

    public static synchronized OfficeConfig getInstance() {
        if (instance == null) instance = new OfficeConfig();
        return instance;
    }

    public synchronized void configureRooms(int count) {
        rooms.clear();
        for (int i = 1; i <= count; i++) {
            Room r = new Room(i);
            // attach default observers
            r.addObserver(new ControllerLight());
            r.addObserver(new ControllerAC());
            rooms.put(i, r);
        }
    }

    public Collection<Room> getRooms() { return rooms.values(); }

    public Room getRoom(int id) { return rooms.get(id); }

    public ScheduledExecutorService getScheduler() { return scheduler; }

    public synchronized void shutdown() {
        scheduler.shutdownNow();
    }
}
