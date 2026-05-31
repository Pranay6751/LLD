package org.example;

import java.net.Inet4Address;
import java.util.HashMap;

public class TaskManager {
    HashMap<Integer, Task> tasks;
    HashMap<Integer, User> users;

    private static volatile TaskManager taskManagerInstance;
    private TaskManager(){
        tasks = new HashMap<>();
        users = new HashMap<>();
    }

    public static TaskManager getTaskInstance(){
        if(taskManagerInstance == null){
            synchronized (TaskManager.class) {
                if(taskManagerInstance == null) {
                    taskManagerInstance = new TaskManager();
                }
            }
        }
        return taskManagerInstance;
    }

    public Task createTask(String name, String description, TaskStatus status, TaskPriority priority, User createdBy){
        Task task = new Task(name, description, status, priority, createdBy);
        tasks.put(task.getId(), task);
        return task;
    }

    public void updateTaskStatus(int taskId, TaskStatus status){
        Task task = tasks.get(taskId);
        if(task!=null) {
            synchronized (task){
                task.setStatus(status);
            }
        }
    }

    public User createUser(String name){
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }

    public void assignTask(int taskId, User user){
        Task task = tasks.get(taskId);
        if(task!=null) {
            synchronized (task){
                task.setAssignee(user);
            }
        }
    }

    public void addComment(int taskId, String msg, User user){
        Task task = tasks.get(taskId);
        if(task!=null){
            task.addComment(new Comment(user, msg));
        }
    }


}
