package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        System.out.println("TIC TAC TOE GAME");
        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter Board Size( eg: 3 for 3x3)");
        int size=sc.nextInt();

        TicTacToeGame game = GameFactory.createGame(GameType.STANDARD, size);

        //only 1 observer as we 're sending in app notifs
        IObserver observer=new ConsoleNotifier();
        game.addObserver(observer);

        Player player1 = new Player(1, "Aditya", new Symbol('X'));
        Player player2 = new Player(2, "Harshita", new Symbol('O'));

        game.addPlayer(player1);
        game.addPlayer(player2);

        // Play the game
        game.play();

        sc.close();
    }
}
