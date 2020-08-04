package com.example.sudoku.logic.generate.transformations;

import java.util.Random;

public abstract class SwapRegions implements BoardTransformer {
    private Random random;

   public SwapRegions(Random random) {
        this.random = random;
    }

    protected int[] pickRegions(int length) {
        int regionSize = (int) Math.sqrt(length);
        int firstRegionIndex = random.nextInt(regionSize);
        int secondRegionIndex = random.nextInt(regionSize);
        while (firstRegionIndex == secondRegionIndex) {
            secondRegionIndex = random.nextInt(regionSize);
        }
        int[] lineIndices = {firstRegionIndex, secondRegionIndex};
        return lineIndices;
    }
}
