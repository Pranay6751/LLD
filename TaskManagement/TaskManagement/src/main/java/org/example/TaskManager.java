package org.example;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskManager {
    HashMap<String, Task> tasks;
    HashMap<String, User> users;

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

    public void deleteTask(int taskId){
        if(tasks.containsKey(taskId)){
            Task task = tasks.get(taskId);
            if(task!=null) {
                User assignee = task.getAssignee();
                assignee.removeFromTaskHistory(task);
                tasks.remove(task.getId());
            }
        }
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

    public void assignTask(String taskId, User user){
        Task task = tasks.get(taskId);
        if(task!=null) {
            synchronized (task){
                task.setAssignee(user);
            }
        }
    }

    public void addComment(String taskId, String msg, User user){
        Task task = tasks.get(taskId);
        if(task!=null){
            task.addComment(new Comment(user, msg));
        }
    }

    public List<Task> searchTasks(TaskSearchCriteria searchCriteria){
        List<Task> res = new ArrayList<>();
        for(Task task: tasks.values()){
            if(searchCriteria.getStatus()!=null && searchCriteria.getStatus()!=task.getStatus()) {
                continue;
            }
            if(searchCriteria.getPriority()!=null && searchCriteria.getPriority()!=task.getPriority()){
                continue;
            }
            if(searchCriteria.getAssignee()!=null && searchCriteria.getAssignee()!=task.getAssignee()){
                continue;
            }
            res.add(task);
        }
        return res;
    }


}
