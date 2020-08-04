package com.example.sudoku.logic.generate.transformations;

import java.util.Random;

public class SwapRows extends SwapLines {
   public SwapRows(Random random) {
        super(random);
    }

    @Override
    public void transform(int[][] board) {
        int length = board.length;
        int[] lineIndices = pickLines(length);
        int firstRowIndex = lineIndices[0];
        int secondRowIndex = lineIndices[1];
        int[] array = board[firstRowIndex];
        board[firstRowIndex] = board[secondRowIndex];
        board[secondRowIndex] = array;
    }
}
