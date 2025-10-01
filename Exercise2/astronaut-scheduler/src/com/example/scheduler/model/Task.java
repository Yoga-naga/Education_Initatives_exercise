package com.example.scheduler.model;

import java.time.LocalTime;

public class Task {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private TaskPriority priority;
    private boolean completed;

    public Task(String description, LocalTime startTime, LocalTime endTime, TaskPriority priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.completed = false;
    }

    public String getDescription() { return description; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public TaskPriority getPriority() { return priority; }
    public boolean isCompleted() { return completed; }

    public void markCompleted() { this.completed = true; }

    @Override
    public String toString() {
        return String.format("%s - %s: %s [%s]%s",
                startTime, endTime, description, priority,
                completed ? " [Completed]" : "");
    }
}
