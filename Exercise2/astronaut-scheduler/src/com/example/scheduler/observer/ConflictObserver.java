package com.example.scheduler.observer;

import com.example.scheduler.model.Task;

public class ConflictObserver implements TaskObserver {

    @Override
    public void onTaskConflict(Task newTask, Task existingTask) {
        System.out.println("Error: Task conflicts with existing task \"" + existingTask.getDescription() + "\".");
    }
}
