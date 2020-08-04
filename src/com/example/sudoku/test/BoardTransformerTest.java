package com.example.sudoku.test;

import com.example.sudoku.logic.generate.transformations.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

public class BoardTransformerTest {

    private static Random random;

    @BeforeClass
    public static void beforeClass() {
        random = Mockito.mock(Random.class);
    }

    @Before
    public void before() {
     //   Mockito.clearInvoсations(random);
    }

    @Test
    public void testThatRowsSwaped() {
        int[][] line = new int[9][9];
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line[i].length; j++) line[i][j] = i;
        }
        Mockito.when(random.nextInt(line.length)).thenReturn(0);
        Mockito.when(random.nextInt((int) Math.sqrt(line.length))).thenReturn(1);
        BoardTransformer tableTransformer = new SwapRows(random);
        tableTransformer.transform(line);
        Assert.assertArrayEquals(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {2, 2, 2, 2, 2, 2, 2, 2, 2}, {3, 3, 3, 3, 3, 3, 3, 3, 3}, {4, 4, 4, 4, 4, 4, 4, 4, 4}, {5, 5, 5, 5, 5, 5, 5, 5, 5}, {6, 6, 6, 6, 6, 6, 6, 6, 6}, {7, 7, 7, 7, 7, 7, 7, 7, 7}, {8, 8, 8, 8, 8, 8, 8, 8, 8}}, line);
    }

    @Test
    public void testThatColumnsSwaped() {
        int[][] line = new int[9][9];
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line[i].length; j++) line[i][j] = j;
        }
        Mockito.when(random.nextInt(line.length)).thenReturn(0);
        Mockito.when(random.nextInt((int) Math.sqrt(line.length))).thenReturn(1);
        BoardTransformer tableTransformer = new SwapColumns(random);
        tableTransformer.transform(line);
        Assert.assertArrayEquals(new int[][]{{1, 0, 2, 3, 4, 5, 6, 7, 8},
                {1, 0, 2, 3, 4, 5, 6, 7, 8},
                {1, 0, 2, 3, 4, 5, 6, 7, 8},
                {1, 0, 2, 3, 4, 5, 6, 7, 8},
                {1, 0, 2, 3, 4, 5, 6, 7, 8},
                {1, 0, 2, 3, 4, 5, 6, 7, 8},
                {1, 0, 2, 3, 4, 5, 6, 7, 8},
                {1, 0, 2, 3, 4, 5, 6, 7, 8},
                {1, 0, 2, 3, 4, 5, 6, 7, 8}}, line);
    }

    @Test
    public void testThatRegionsSwapedHorizontally() {
        int[][] line = new int[9][9];
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line.length; j++) {
                if (i < (int) Math.sqrt(line.length)) line[i][j] = 0;
                else if (i >= (int) Math.sqrt(line.length) && i < (int) Math.sqrt(line.length) * 2) line[i][j] = 1;
                else line[i][j] = 2;
            }
        }
        Mockito.when(random.nextInt((int) Math.sqrt(line.length))).thenReturn(0).thenReturn(1);
        BoardTransformer tableTransformer = new SwapRegionsHorizontally(random);
        tableTransformer.transform(line);
        Assert.assertArrayEquals(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2}}, line);
    }

    @Test
    public void testThatRegionsSwapedVertikally() {
        int line[][] = new int[9][9];
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line.length; j++) {
                if (j < (int) Math.sqrt(line.length)) line[i][j] = 0;
                else if (j >= (int) Math.sqrt(line.length) && j < (int) Math.sqrt(line.length) * 2) line[i][j] = 1;
                else line[i][j] = 2;
            }
        }
        Mockito.when(random.nextInt((int) Math.sqrt(line.length))).thenReturn(0).thenReturn(1);
        BoardTransformer tableTransformer = new SwapRegionsVertically(random);
        tableTransformer.transform(line);
        Assert.assertArrayEquals(new int[][]{{1, 1, 1, 0, 0, 0, 2, 2, 2},
                                             {1, 1, 1, 0, 0, 0, 2, 2, 2},
                                             {1, 1, 1, 0, 0, 0, 2, 2, 2},
                                             {1, 1, 1, 0, 0, 0, 2, 2, 2},
                                             {1, 1, 1, 0, 0, 0, 2, 2, 2},
                                             {1, 1, 1, 0, 0, 0, 2, 2, 2},
                                             {1, 1, 1, 0, 0, 0, 2, 2, 2},
                                             {1, 1, 1, 0, 0, 0, 2, 2, 2},
                                             {1, 1, 1, 0, 0, 0, 2, 2, 2}}, line);
    }

    @Test
    public void testThatRowsAndColumnsSwaped() {
        int[][] line = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        BoardTransformer tableTransformer = new SwapRowsAndColumns(random);
        tableTransformer.transform(line);
        Assert.assertArrayEquals(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}, line);
    }
}

