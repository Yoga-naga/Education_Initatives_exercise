package com.example.scheduler.manager;

import com.example.scheduler.model.Task;
import com.example.scheduler.observer.TaskObserver;

import java.util.*;
import java.util.stream.Collectors;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks;
    private final List<TaskObserver> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public boolean addTask(Task task) {
        for (Task t : tasks) {
            if (!(task.getEndTime().isBefore(t.getStartTime()) || task.getStartTime().isAfter(t.getEndTime()))) {
                notifyConflict(task, t);
                return false;
            }
        }
        tasks.add(task);
        System.out.println("Task added successfully. No conflicts.");
        return true;
    }

    public void removeTask(String description) {
        Optional<Task> task = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst();
        if (task.isPresent()) {
            tasks.remove(task.get());
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        List<Task> sorted = tasks.stream()
                .sorted(Comparator.comparing(Task::getStartTime))
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }

    public void markTaskCompleted(String description) {
        Optional<Task> task = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst();
        if (task.isPresent()) {
            task.get().markCompleted();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void viewTasksByPriority(String priority) {
        List<Task> filtered = tasks.stream()
                .filter(t -> t.getPriority().name().equalsIgnoreCase(priority))
                .collect(Collectors.toList());
        if (filtered.isEmpty()) {
            System.out.println("No tasks with priority: " + priority);
        } else {
            filtered.forEach(System.out::println);
        }
    }

    private void notifyConflict(Task newTask, Task existingTask) {
        for (TaskObserver observer : observers) {
            observer.onTaskConflict(newTask, existingTask);
        }
    }
}
