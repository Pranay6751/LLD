package org.example;

import java.util.Random;

public class Dice {
    private int minValue;
    private int maxValue;
    private Random random;

    public Dice(int minValue, int maxValue){
        this.minValue=minValue;
        this.maxValue=maxValue;
        random = new Random();
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int rollDice(){
        return random.nextInt(maxValue-minValue+1)+minValue;
    }
}
