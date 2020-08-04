package com.example.sudoku.logic.generate.transformations;

import java.util.Random;

public class SwapRowsAndColumns implements BoardTransformer {
    private Random random;

    public SwapRowsAndColumns(Random random) {
        this.random = random;
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
