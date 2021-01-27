package com.example.sudoku.logic.generate.transformations;

import java.util.Random;

public class SwapColumns extends SwapLines {

    public SwapColumns(Random random) {
        super(random);
    }

    /**
     * Swap board columns
     * @param board
     */
    @Override
    public void transform(int[][] board) {
        int[] lineIndices = pickLines(board.length);
        int firstColumnIndex = lineIndices[0];
        int secondColumnIndex = lineIndices[1];
        for (int i = 0; i < board.length; i++) {
            int box = board[i][firstColumnIndex];
            board[i][firstColumnIndex] = board[i][secondColumnIndex];
            board[i][secondColumnIndex] = box;
        }
    }
}
