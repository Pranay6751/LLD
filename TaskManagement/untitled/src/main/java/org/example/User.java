package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String name;
    List<Task> taskHistory;
    public User(String name){
        this.id=generateId();
        this.name=name;
        taskHistory = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addToTaskHistory(Task task){
        taskHistory.add(task);
    }

    public void removeFromTaskHistory(Task task){
        for (Task curTask : taskHistory){
            if(curTask.equals(task)){
                taskHistory.remove(task);
                break;
            }
        }
    }

    public List<Task> getTaskHistory(){
        return taskHistory;
    }

    public int generateId()
    {
        return (int) (System.currentTimeMillis()%Integer.MAX_VALUE);
    }
}
