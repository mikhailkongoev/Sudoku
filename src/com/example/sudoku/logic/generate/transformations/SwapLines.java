package com.example.sudoku.logic.generate.transformations;

import java.util.Random;

public abstract class SwapLines implements BoardTransformer {
    final Random RANDOM;

    public SwapLines(Random random) {
        RANDOM = random;
    }

    protected int[] pickLines(int length) {
        int regionSize = (int) Math.sqrt(length);
        int firstLineIndex = RANDOM.nextInt(length);
        int regionIndexIncludedFirstLine = firstLineIndex / regionSize;
        int min = regionIndexIncludedFirstLine * regionSize;
        int secondLineIndex = min + RANDOM.nextInt(regionSize);
        while (secondLineIndex == firstLineIndex) secondLineIndex = min + RANDOM.nextInt(regionSize);
        return new int[]{firstLineIndex, secondLineIndex};
    }
}
