package org.example;

import java.util.*;
public class Board {
    Map<Integer, Snake> snakes;
    Map<Integer, Ladder> ladders;
    private int size;

    public Board(int size){
        this.size=size;
        snakes=new HashMap<>();
        ladders=new HashMap<>();
    }

    public boolean addSnakes(int head, int tail){
        if(snakes.containsKey(head)) return false;
        snakes.put(head, new Snake(head, tail));
        return true;
    }

    public boolean addLadders(int start, int end){
        if(ladders.containsKey(start)) return false;
        ladders.put(start, new Ladder(start, end));
        return true;
    }

    public int getFinalPosition(int currentPosition){
        if(snakes.containsKey(currentPosition)){
            return snakes.get(currentPosition).getTail();
        }
        if(ladders.containsKey(currentPosition)){
            return ladders.get(currentPosition).getEnd();
        }
        return currentPosition;
    }

    public int getSize(){
        return size;
    }
}
