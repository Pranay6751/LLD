package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    String id;
    String name;
    List<Task> taskHistory;
    public User(String name){
        this.id=generateId();
        this.name=name;
        taskHistory = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addToTaskHistory(Task task){
        taskHistory.add(task);
    }

    public void removeFromTaskHistory(Task task){
//        for (Task curTask : taskHistory){
//            if(curTask.equals(task)){
//                taskHistory.remove(task);
//                break;
//            }
//        }
        //as we override equals directly remove taskHistory
        taskHistory.remove(task);
    }

    public List<Task> getTaskHistory(){
        return taskHistory;
    }

    public String generateId()
    {
        return UUID.randomUUID().toString();
    }
}
