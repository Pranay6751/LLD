package org.example;

public class TaskSearchCriteria {

    private User assignee;
    private TaskPriority priority;
    private TaskStatus status;

    public void setAssignee(User user) {
        this.assignee = user;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public User getAssignee() {
        return assignee;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public TaskStatus getStatus() {
        return status;
    }
}
