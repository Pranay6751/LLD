package org.example;

import java.util.*;

public class Task {
    String id;
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

    public String generateId()
    {
        return UUID.randomUUID().toString();
    }

    public String getId() {
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

    public void setAssignee(User newassignee){
        if(this.assignee!=null){
            this.assignee.removeFromTaskHistory(this);
        }
        this.assignee = newassignee;
        assignee.addToTaskHistory(this);
    }

    public void setCreatedBy(User createdBy){
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;

        if(obj == null || obj.getClass()!=getClass()) {
            return false;
        }

        Task other = (Task) obj;
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
