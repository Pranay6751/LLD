package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SnakeAndLadderGame {
    Board board;
    Deque<Player> players;
    GameStatus gameStatus;
    Dice dice;
    List<IObserver> observerList;

    public SnakeAndLadderGame(int size, Dice dice) {
        this.board = new Board(size);
        this.players = new ArrayDeque<>();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.dice = dice;
        this.observerList=new ArrayList<>();
    }

    public boolean addSnake(int head, int tail){
        return this.board.addSnakes(head, tail);
    }

    public boolean addLadder(int start, int end){
        return this.board.addLadders(start,end);
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void addObservers(IObserver observer){
        observerList.add(observer);
    }

    public void startGame(){
        notify("[Notification] Game Started");
        while(gameStatus==GameStatus.IN_PROGRESS){
            Player player = players.removeFirst();

            notify("Current Player: "+player.getName());
            int diceValue = dice.rollDice();
            notify("Dice value: "+diceValue);
            int updatedPosition = player.getPosition()+diceValue;
            if(updatedPosition<=board.getSize()){
                int newPosition = board.getFinalPosition(updatedPosition);
                if(newPosition<updatedPosition){
                    notify("Bitten By snake");
                } else if(newPosition>updatedPosition){
                    notify("Climbed Ladder");
                }
                notify("Current Player moved from Position:"+ player.getPosition()+" to Position: "+newPosition);
                player.setPosition(newPosition);
                if(player.getPosition()== board.getSize()){
                    notify("Player: "+player.getName()+" wins");
                    gameStatus=GameStatus.FINISHED;
                    break;
                }
            } else {
                notify("Your Current Dice move exceeds Board Size, Pls try again in next Turn");
            }
            players.addLast(player);
        }
    }

    public void notify(String msg){
        for(IObserver observer: observerList){
            observer.update(msg);
        }
    }


}
