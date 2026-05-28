package org.example;

public class Board {
    Symbol[][] grid;
    int size;
    Symbol emptyCell;

    Board(int size){
        this.size=size;
        emptyCell = new Symbol('_');
        grid = new Symbol[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                grid[i][j]=new Symbol('_');
            }
        }
    }
}
