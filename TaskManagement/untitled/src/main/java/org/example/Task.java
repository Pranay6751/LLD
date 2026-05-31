package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {
    int id;
    String name;
    String description;
    TaskStatus status;
    TaskPriority priority;
    User assignee;
    User createdBy;
    Date createdOn;
    List<Comment> comments;

    public Task(String name, String description, TaskStatus status, TaskPriority priority, User createdBy) {
        this.id = generateId();
        this.name = name;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.createdBy = createdBy;
        createdOn = new Date();
        comments = new ArrayList<>();
    }

    public int generateId()
    {
        return (int) (System.currentTimeMillis()%Integer.MAX_VALUE);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public User getAssignee() {
        return assignee;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void setStatus(TaskStatus status){
        this.status = status;
    }

    public void setAssignee(User assignee){
        this.assignee = assignee;
        assignee.setTaskHistory(this);
    }

    public void setCreatedBy(User createdBy){
        this.createdBy = createdBy;
    }
}
