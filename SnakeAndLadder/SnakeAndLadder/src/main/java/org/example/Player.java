package org.example;

public class Player {
    private int id;
    private String name;
    private int position;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.position=0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int position){
        this.position=position;
    }

    public int getPosition() {
        return position;
    }
}
