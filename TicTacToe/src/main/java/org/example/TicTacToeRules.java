package org.example;

public interface TicTacToeRules {
    boolean checkWin(Board board, Symbol symbol);
    boolean checkDraw(Board board);
    boolean isValidMove(Board board, int r, int c);
}
