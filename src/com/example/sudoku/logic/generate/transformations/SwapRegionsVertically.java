package com.example.sudoku.logic.generate.transformations;

import java.util.Random;

public class SwapRegionsVertically extends SwapRegions {

    public SwapRegionsVertically(Random random) {
        super(random);
    }

    @Override
    public void transform(int[][] board) {
        int length = board.length;
        int regionSize = (int) Math.sqrt(length);
        int[] lineConveyor = pickRegions(length);
        int firstRegionIndex = lineConveyor[0];
        int secondRegionIndex = lineConveyor[1];
        int lineFirstRegion = firstRegionIndex * regionSize;
        int lineSecondRegion = secondRegionIndex * regionSize;
        for (int i = 0; i < regionSize; i++) {
            for (int j = 0; j < length; j++) {
                int box = board[j][lineFirstRegion + i];
                board[j][lineFirstRegion + i] = board[j][lineSecondRegion + i];
                board[j][lineSecondRegion + i] = box;
            }
        }
    }
}
