package com.example.sudoku.logic.generate.transformations;


public class SwapRowsAndColumns implements BoardTransformer {

    public SwapRowsAndColumns() {
    }

    @Override
    public void transform(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = i; j < board[i].length; j++) {
                int box = board[i][j];
                board[i][j] = board[j][i];
                board[j][i] = box;
            }
        }
    }
}
