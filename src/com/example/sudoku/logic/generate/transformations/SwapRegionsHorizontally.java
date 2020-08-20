package com.example.sudoku.logic.generate.transformations;

import java.util.Random;

public class SwapRegionsHorizontally extends SwapRegions {

    public SwapRegionsHorizontally(Random random) {
        super(random);
    }

    @Override
    public void transform(int[][] board) {
        int regionSize = (int) Math.sqrt(board.length);
        int[] lineIndices = pickRegions(board.length);
        int firstRegionIndex = lineIndices[0];
        int secondRegionIndex = lineIndices[1];
        int[][] boardCopy = new int[board.length][board.length];
        int lineRegion = firstRegionIndex * regionSize;
        int lineSecondRegion = secondRegionIndex * regionSize;
        for (int i = 0; i < regionSize; i++) {
            boardCopy[0] = board[lineRegion + i];
            board[lineRegion + i] = board[lineSecondRegion + i];
            board[lineSecondRegion + i] = boardCopy[0];
        }
    }
}
