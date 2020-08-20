package com.example.sudoku.logic.generate.transformations;

import java.util.Random;

public abstract class SwapRegions implements BoardTransformer {
    final Random RANDOM;

   public SwapRegions(Random random) {
        RANDOM = random;
    }

    protected int[] pickRegions(int length) {
        int regionSize = (int) Math.sqrt(length);
        int firstRegionIndex = RANDOM.nextInt(regionSize);
        int secondRegionIndex = RANDOM.nextInt(regionSize);
        while (firstRegionIndex == secondRegionIndex) {
            secondRegionIndex = RANDOM.nextInt(regionSize);
        }
        return new int[]{firstRegionIndex, secondRegionIndex};
    }
}
