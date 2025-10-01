package com.example.scheduler;

import com.example.scheduler.factory.TaskFactory;
import com.example.scheduler.manager.ScheduleManager;
import com.example.scheduler.model.Task;
import com.example.scheduler.observer.ConflictObserver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        manager.addObserver(new ConflictObserver());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Astronaut Daily Schedule Organizer ---");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Mark Task Completed");
            System.out.println("5. View Tasks by Priority");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> {
                    try {
                        System.out.print("Enter description: ");
                        String desc = scanner.nextLine();
                        System.out.print("Enter start time (HH:mm): ");
                        String start = scanner.nextLine();
                        System.out.print("Enter end time (HH:mm): ");
                        String end = scanner.nextLine();
                        System.out.print("Enter priority (HIGH/MEDIUM/LOW): ");
                        String priority = scanner.nextLine();

                        Task task = TaskFactory.createTask(desc, start, end, priority);
                        manager.addTask(task);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Enter task description to remove: ");
                    manager.removeTask(scanner.nextLine());
                }
                case 3 -> manager.viewTasks();
                case 4 -> {
                    System.out.print("Enter task description to mark completed: ");
                    manager.markTaskCompleted(scanner.nextLine());
                }
                case 5 -> {
                    System.out.print("Enter priority (HIGH/MEDIUM/LOW): ");
                    manager.viewTasksByPriority(scanner.nextLine());
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
