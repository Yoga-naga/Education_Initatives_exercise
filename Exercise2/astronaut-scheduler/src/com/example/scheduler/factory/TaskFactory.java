package com.example.scheduler.factory;

import com.example.scheduler.model.Task;
import com.example.scheduler.model.TaskPriority;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TaskFactory {

    public static Task createTask(String description, String start, String end, String priority) throws IllegalArgumentException {
        try {
            LocalTime startTime = LocalTime.parse(start);
            LocalTime endTime = LocalTime.parse(end);
            if (endTime.isBefore(startTime)) {
                throw new IllegalArgumentException("End time cannot be before start time.");
            }
            TaskPriority taskPriority = TaskPriority.valueOf(priority.toUpperCase());
            return new Task(description, startTime, endTime, taskPriority);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Error: Invalid time format. Use HH:mm.");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error: Invalid priority (use HIGH, MEDIUM, LOW).");
        }
    }
}
