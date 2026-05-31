package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        TaskManager taskManager = TaskManager.getTaskInstance();

        User user1 = taskManager.createUser("Pavan");
        User user2= taskManager.createUser("Pranay");

        Task task1 = taskManager.createTask("Task1", "Desc1", TaskStatus.TODO, TaskPriority.LOW, user1);

        taskManager.assignTask(task1.getId(), user2);
        taskManager.updateTaskStatus(task1.getId(), TaskStatus.IN_PROGRESS);

        System.out.println(task1.getStatus());
        System.out.println(user2.getTaskHistory());
    }
}
