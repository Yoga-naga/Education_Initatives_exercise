package com.example.scheduler.observer;

import com.example.scheduler.model.Task;

public interface TaskObserver {
    void onTaskConflict(Task newTask, Task existingTask);
}
