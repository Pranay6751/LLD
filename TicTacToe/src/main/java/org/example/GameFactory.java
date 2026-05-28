package org.example;

public class GameFactory {
    public static TicTacToeGame createGame(GameType gt, int boardSize){
        if(GameType.STANDARD == gt){
            //we can specify initialization of rules here if there are multiple rule types of games are there
            return new TicTacToeGame(boardSize);
        }
        return null;
    }
}
