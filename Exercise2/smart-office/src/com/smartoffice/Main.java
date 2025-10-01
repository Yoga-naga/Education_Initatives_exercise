package com.smartoffice;


import com.smartoffice.commands.*;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OfficeConfig cfg = OfficeConfig.getInstance();
        CommandInvoker invoker = new CommandInvoker();
        Scanner sc = new Scanner(System.in);

        System.out.println("Smart Office Facility Console. Type 'help' for commands.");
        while (true) {
            System.out.print("> ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            if (line.equalsIgnoreCase("exit") || line.equalsIgnoreCase("quit")) {
                cfg.shutdown();
                System.out.println("Exiting.");
                break;
            }
            if (line.equalsIgnoreCase("help")) {
                printHelp();
                continue;
            }
            try {
                String[] parts = line.split("\\s+");
                String cmd = parts[0].toLowerCase();

                switch (cmd) {
                    case "config":
                        if (parts.length >= 3 && parts[1].equalsIgnoreCase("room") && parts[2].equalsIgnoreCase("count") && parts.length==4) {
                            int count = Integer.parseInt(parts[3]);
                            invoker.execute(new ConfigureCommand(count));
                        } else if (parts.length==4 && parts[1].equalsIgnoreCase("room") && parts[2].equalsIgnoreCase("max") && parts[3].startsWith("capacity")) {
                            System.out.println("Use: config room maxcapacity <roomId> <capacity>");
                        } else {
                            // allow: config room maxcapacity <roomId> <capacity>
                            if (parts.length==5 && parts[1].equalsIgnoreCase("room") && parts[2].equalsIgnoreCase("maxcapacity")) {
                                int roomId = Integer.parseInt(parts[3]);
                                int cap = Integer.parseInt(parts[4]);
                                invoker.execute(new SetCapacityCommand(roomId, cap));
                            } else {
                                System.out.println("Invalid config command.");
                            }
                        }
                        break;
                    case "block": // alternative to "book"
                    case "book":
                        // book roomId HH:MM minutes   OR: block room 1 09:00 60
                        if (parts.length >= 4) {
                            int roomId = Integer.parseInt(parts[1]);
                            LocalTime start = LocalTime.parse(parts[2]);
                            int min = Integer.parseInt(parts[3]);
                            invoker.execute(new BookRoomCommand(roomId, start, min));
                        } else {
                            System.out.println("Usage: book <roomId> <HH:MM> <minutes>");
                        }
                        break;
                    case "cancel":
                    case "cancelroom":
                    case "cancelbooking":
                        if (parts.length >= 2) {
                            int roomId = Integer.parseInt(parts[1]);
                            invoker.execute(new CancelBookingCommand(roomId));
                        } else {
                            System.out.println("Usage: cancel <roomId>");
                        }
                        break;
                    case "add":
                        // add occupant <roomId> <count>
                        if (parts.length >= 3 && parts[1].equalsIgnoreCase("occupant")) {
                            int roomId = Integer.parseInt(parts[2]);
                            int count = 0;
                            if (parts.length >= 4) count = Integer.parseInt(parts[3]);
                            invoker.execute(new AddOccupantCommand(roomId, count));
                        } else {
                            System.out.println("Usage: add occupant <roomId> <count>");
                        }
                        break;
                    case "status":
                        for (Room r : cfg.getRooms()) {
                            System.out.printf("Room %d | occupants=%d | booking=%s%n",
                                    r.getId(), r.getOccupants(), (r.getBooking() == null ? "none" : r.getBooking()));
                        }
                        break;
                    default:
                        System.out.println("Unknown command. Type 'help'.");
                }
            } catch (NumberFormatException | DateTimeParseException ex) {
                System.out.println("Invalid number or time format: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                ex.printStackTrace(System.out);
            }
        }
        sc.close();
    }

    private static void printHelp() {
        System.out.println("Commands (examples):");
        System.out.println("  config room count <n>");
        System.out.println("  config room maxcapacity <roomId> <capacity>");
        System.out.println("  book <roomId> <HH:MM> <minutes>");
        System.out.println("  cancel <roomId>");
        System.out.println("  add occupant <roomId> <count>");
        System.out.println("  status");
        System.out.println("  help");
        System.out.println("  exit");
    }
}
