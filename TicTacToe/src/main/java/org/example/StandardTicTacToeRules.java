package org.example;

public class StandardTicTacToeRules implements TicTacToeRules{

    @Override
    public boolean checkWin(Board board, Symbol symbol) {
        int size = board.getSize();

        // Check rows
        for(int i = 0; i < size; i++) {
            boolean win = true;
            for(int j = 0; j < size; j++) {
                if(board.getCell(i, j) != symbol) {
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }

        // Check columns
        for(int j = 0; j < size; j++) {
            boolean win = true;
            for(int i = 0; i < size; i++) {
                if(board.getCell(i, j) != symbol) {
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }

        // Check main diagonal
        boolean win = true;
        for(int i = 0; i < size; i++) {
            if(board.getCell(i, i) != symbol) {
                win = false;
                break;
            }
        }
        if(win) return true;

        // Check anti-diagonal
        win = true;
        for(int i = 0; i < size; i++) {
            if(board.getCell(i, size-1-i) != symbol) {
                win = false;
                break;
            }
        }
        return win;
    }

    @Override
    public boolean checkDraw(Board board) {
        for(int i=0;i<board.getSize();i++){
            for(int j=0;j<board.getSize();j++){
                if(board.getCell(i,j)==board.getEmptyCell()){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isValidMove(Board board, int r, int c) {
        return board.isCellEmpty(r,c);
    }

}
