package org.example;

import java.util.*;

public class TicTacToeGame {
    private Board board;
    private Deque<Player> players;
    private TicTacToeRules rules;
    private List<IObserver> observerList;
    private boolean gameOver;

    public TicTacToeGame(int size) {
        this.rules = new StandardTicTacToeRules();
        this.board = new Board(size);
        this.players = new ArrayDeque<>();
        this.observerList = new ArrayList<>();
        this.gameOver = false;
    }

    public void addPlayer(Player player) {
        players.addLast(player);
    }

    public void addObserver(IObserver observer) {
        observerList.add(observer);
    }

    public void notify(String msg){
        for(IObserver observer: observerList){
            observer.update(msg);
        }
    }


    public void play() {
        if(players.size() < 2) {
            System.out.println("Need at least 2 players!");
            return;
        }

        notify("Tic Tac Toe Game Started!");

        Scanner scanner = new Scanner(System.in);

        while(!gameOver) {
            board.display();

            // Take out the current player from dequeue
            Player currentPlayer = players.peekFirst();
            System.out.print(currentPlayer.getName() + " (" + currentPlayer.getSymbol().getMark() + ") - Enter row and column: ");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // check if move is valid
            if(rules.isValidMove(board, row, col)) {
                board.placeMark(row, col, currentPlayer.getSymbol());
                notify(currentPlayer.getName() + " played (" + row + "," + col + ")");

                if(rules.checkWin(board, currentPlayer.getSymbol())) {
                    board.display();
                    System.out.println(currentPlayer.getName() + " wins!");
                    currentPlayer.incrementScore();

                    notify(currentPlayer.getName() + " wins!");

                    gameOver = true;
                }
                else if(rules.checkDraw(board)) {
                    board.display();

                    System.out.println("It's a draw!");
                    notify("Game is Draw!");

                    gameOver = true;
                }
                else {
                    // Move player to back of queue
                    players.removeFirst();
                    players.addLast(currentPlayer);
                }
            }
            else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

}
