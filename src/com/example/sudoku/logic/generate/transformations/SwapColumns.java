package com.example.sudoku.logic.generate.transformations;

import java.util.Random;

public class SwapColumns extends SwapLines {

   public SwapColumns(Random random) {
        super(random);
    }

    @Override
    public void transform(int[][] board) {
        int length = board.length;
        int[] lineIndices = pickLines(length);
        int firstColumnIndex = lineIndices[0];
        int secondColumnIndex = lineIndices[1];
        for (int i = 0; i < board.length; i++) {
            int box = board[i][firstColumnIndex];
            board[i][firstColumnIndex] = board[i][secondColumnIndex];
            board[i][secondColumnIndex] = box;
        }
    }
}
