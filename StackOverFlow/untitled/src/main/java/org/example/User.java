package org.example;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private int reputation;

    public User(String name){
        this.id = UUID.randomUUID().toString();
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void increaseReputation(int reputation){
        this.reputation+=reputation;
    }

    public void decreaseReputation(int reputation){
        this.reputation-=reputation;
    }

    public int getReputation() {
        return reputation;
    }
}
