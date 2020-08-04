package com.example.sudoku.logic.generate.transformations;

import java.util.Random;

public abstract class SwapLines implements BoardTransformer {
    private Random random;

    public SwapLines(Random random) {
        this.random = random;
    }

    protected int[] pickLines(int length) {
        int regionSize = (int) Math.sqrt(length);
        int firstLineIndex = random.nextInt(length);
        int regionIndexIncludedFirstLine = firstLineIndex / regionSize;
        int min = regionIndexIncludedFirstLine * regionSize;
        int secondLineIndex = min + random.nextInt(regionSize);
        while (secondLineIndex == firstLineIndex) secondLineIndex = min + random.nextInt(regionSize);
        int[] lineIndices = {firstLineIndex, secondLineIndex};
        return lineIndices;
    }
}
