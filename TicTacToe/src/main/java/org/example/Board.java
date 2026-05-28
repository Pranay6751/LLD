package org.example;

public class Board {
    Symbol[][] grid;
    int size;
    Symbol emptyCell;

    Board(int size){
        this.size=size;
        emptyCell = new Symbol('_');
        grid = new Symbol[size][size];
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = emptyCell;
            }
        }
    }

    public boolean isCellEmpty(int r, int c){
        if(r<0 || r>=size || c<0 || c>size) return false;
        return grid[r][c] == emptyCell;
    }

    public boolean placeMark(int r, int c, Symbol mark){
        if(r<0 || r>=size || c<0 || c>size) return false;
        if(!isCellEmpty(r,c)) return false;
        grid[r][c]=mark;
        return true;
    }

    public Symbol getCell(int r, int c){
        if(r<0 || r>=size || c<0 || c>size) return emptyCell;
        return grid[r][c];
    }

    public int getSize(){
        return size;
    }

    public Symbol getEmptyCell(){
        return emptyCell;
    }

    public void display(){
        System.out.print("\n  ");
        for(int i = 0; i < size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for(int j = 0; j < size; j++) {
                System.out.print(grid[i][j].getMark() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
