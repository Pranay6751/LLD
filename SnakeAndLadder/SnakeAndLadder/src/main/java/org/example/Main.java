package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("===========Snake and Ladder Game===========");
        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter Board Size( eg: 3 for 3x3)");
        int size=sc.nextInt();

        System.out.println("Please Enter Dice min and max value");
        int minValue=sc.nextInt();
        int maxValue=sc.nextInt();
        Dice dice=new Dice(minValue, maxValue);

        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame(size,dice);

        System.out.println("Please Enter number of player ");
        int numberOfPlayers=sc.nextInt();
        for(int i=1;i<=numberOfPlayers;i++){
            System.out.println("Please Enter the Name of the player");
            String name=sc.next();
            snakeAndLadderGame.addPlayer(new Player(i,name));
        }

        System.out.println("Please Enter number of snakes ");
        int numberOfSnakes=sc.nextInt();
        for(int i=1;i<=numberOfSnakes;){
            System.out.println("Please Enter head and tail position of snake: "+i);
            int head=sc.nextInt();
            int tail=sc.nextInt();
            if(snakeAndLadderGame.addSnake(head, tail)) {
                i++;
            } else {
                System.out.println("Snake with this head already exists, Pls try again!");
            }
        }

        System.out.println("Please Enter number of ladders ");
        int numberOfLadders=sc.nextInt();
        for(int i=1;i<=numberOfLadders;){
            System.out.println("Please Enter start and end position of ladder: "+i);
            int start=sc.nextInt();
            int end=sc.nextInt();
            if(snakeAndLadderGame.addLadder(start,end)){
                i++;
            } else {
                System.out.println("Ladder with this start position already exists, Pls try again!");
            }
        }

        IObserver observer = new IConsoleNotifier();
        snakeAndLadderGame.addObservers(observer);

        snakeAndLadderGame.startGame();


    }
}
