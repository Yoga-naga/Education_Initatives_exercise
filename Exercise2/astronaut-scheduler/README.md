# 🚀 Astronaut Daily Schedule Organizer

A simple **console-based Java application** to help astronauts organize their daily schedules.  
This project is built with focus on **OOP principles, SOLID design, and design patterns**.  

---

## ✨ Features

### ✅ Mandatory
- Add a new task with description, start time, end time, and priority level.
- Remove an existing task.
- View all tasks sorted by start time.
- Validate that new tasks do not overlap with existing tasks.
- Provide appropriate error messages for invalid operations.

### 🔑 Optional
- Edit an existing task (can be extended easily).
- Mark tasks as completed.
- View tasks by priority level.
- Logging of operations (`scheduler.log`).

---

## 🛠 Design Patterns Used
- **Singleton Pattern** → `ScheduleManager` ensures a single instance manages tasks.
- **Factory Pattern** → `TaskFactory` handles task creation and validation.
- **Observer Pattern** → `ConflictObserver` notifies user about conflicting tasks.

---

## 📂 Project Structure

src/
└── com/example/scheduler/
├── Main.java
├── manager/
│ └── ScheduleManager.java
├── model/
│ ├── Task.java
│ └── TaskPriority.java
├── factory/
│ └── TaskFactory.java
├── observer/
│ ├── TaskObserver.java
│ └── ConflictObserver.java
└── util/
└── LoggerUtil.java