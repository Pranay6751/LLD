package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        TaskManager taskManager = TaskManager.getTaskInstance();

        // Create Users
        User user1 = taskManager.createUser("Pavan");
        User user2 = taskManager.createUser("Pranay");

        // Create Tasks
        Task task1 = taskManager.createTask(
                "Backend API",
                "Create Login API",
                TaskStatus.TODO,
                TaskPriority.HIGH,
                user1
        );

        Task task2 = taskManager.createTask(
                "Frontend",
                "Create Login Page",
                TaskStatus.IN_PROGRESS,
                TaskPriority.MEDIUM,
                user1
        );

        Task task3 = taskManager.createTask(
                "Testing",
                "Write Test Cases",
                TaskStatus.TODO,
                TaskPriority.HIGH,
                user1
        );

        Task task4 = taskManager.createTask(
                "Deployment",
                "Deploy to Production",
                TaskStatus.FINISHED,
                TaskPriority.LOW,
                user1
        );

        // Assign Tasks
        taskManager.assignTask(task1.getId(), user2);
        taskManager.assignTask(task2.getId(), user2);
        taskManager.assignTask(task3.getId(), user2);
        taskManager.assignTask(task4.getId(), user1);

        // Add Comments
        taskManager.addComment(
                task1.getId(),
                "Started working on API",
                user2
        );

        taskManager.addComment(
                task2.getId(),
                "UI implementation in progress",
                user2
        );

        System.out.println(taskManager.tasks.size());

        // --------------------------------------------------
        // Search 1 : All TODO Tasks
        // --------------------------------------------------

        TaskSearchCriteria criteria1 = new TaskSearchCriteria();
        criteria1.setStatus(TaskStatus.TODO);

        List<Task> todoTasks =
                taskManager.searchTasks(criteria1);

        System.out.println("===== TODO TASKS =====");

        for (Task task : todoTasks) {
            System.out.println(task.getName());
        }

        // --------------------------------------------------
        // Search 2 : All HIGH Priority Tasks
        // --------------------------------------------------

        TaskSearchCriteria criteria2 = new TaskSearchCriteria();
        criteria2.setPriority(TaskPriority.HIGH);

        List<Task> highPriorityTasks =
                taskManager.searchTasks(criteria2);

        System.out.println("\n===== HIGH PRIORITY TASKS =====");

        for (Task task : highPriorityTasks) {
            System.out.println(task.getName());
        }

        // --------------------------------------------------
        // Search 3 : Tasks Assigned To Pranay
        // --------------------------------------------------

        TaskSearchCriteria criteria3 = new TaskSearchCriteria();
        criteria3.setAssignee(user2);

        List<Task> pranayTasks =
                taskManager.searchTasks(criteria3);

        System.out.println("\n===== TASKS ASSIGNED TO PRANAY =====");

        for (Task task : pranayTasks) {
            System.out.println(task.getName());
        }

        // --------------------------------------------------
        // Search 4 : HIGH Priority + TODO + Assigned To Pranay
        // --------------------------------------------------

        TaskSearchCriteria criteria4 = new TaskSearchCriteria();
        criteria4.setAssignee(user2);
        criteria4.setPriority(TaskPriority.HIGH);
        criteria4.setStatus(TaskStatus.TODO);

        List<Task> filteredTasks =
                taskManager.searchTasks(criteria4);

        System.out.println(
                "\n===== HIGH PRIORITY TODO TASKS ASSIGNED TO PRANAY =====");

        for (Task task : filteredTasks) {
            System.out.println(task.getName());
        }
    }
}