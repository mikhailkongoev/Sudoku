package com.example.sudoku.test;

import com.example.sudoku.logic.hidecells.solvers.*;
import org.junit.Assert;
import org.junit.Test;


public class SolveSudokuTest {

    @Test
    public void testThatSolutionPassesInRow() {
        String[][] array = new String[][]{{"123", "2", "3"}, {"2", "3", "1"}, {"3", "1", "2"}};
        SolveSudoku solveSudoku = new RowSudokuSolution();
        solveSudoku.tryToSolve(array);
        Assert.assertArrayEquals(new String[][]{{"1", "2", "3"}, {"2", "3", "1"}, {"3", "1", "2"}}, array);
    }

    @Test
    public void testThatSolutionPassesInColumn() {
        String[][] array = new String[][]{{"123", "2", "3"}, {"2", "3", "1"}, {"3", "1", "2"}};
        SolveSudoku solveSudoku = new ColumnSudokuSolution();
        solveSudoku.tryToSolve(array);
        Assert.assertArrayEquals(new String[][]{{"1", "2", "3"}, {"2", "3", "1"}, {"3", "1", "2"}}, array);
    }

    @Test
    public void testThatSolutionPassesInSquare() {
        String[][] array = new String[][]{{"123", "2", "3", "1", "2", "3", "1", "2", "3"},
                {"2", "3", "1", "2", "3", "1", "2", "3", "1"},
                {"3", "1", "2", "3", "1", "2", "3", "1", "2"},
                {"1", "2", "3", "1", "2", "3", "1", "2", "3"},
                {"2", "3", "1", "2", "3", "1", "2", "3", "1"},
                {"3", "1", "2", "3", "1", "2", "3", "1", "2"},
                {"1", "2", "3", "1", "2", "3", "1", "2", "3"},
                {"2", "3", "1", "2", "3", "1", "2", "3", "1"},
                {"3", "1", "2", "3", "1", "2", "3", "1", "2"}};

        SolveSudoku solveSudoku = new SquareSudokuSolution();
        solveSudoku.tryToSolve(array);
        Assert.assertArrayEquals(new String[][]{{"1", "2", "3", "1", "2", "3", "1", "2", "3"},
                {"2", "3", "1", "2", "3", "1", "2", "3", "1"},
                {"3", "1", "2", "3", "1", "2", "3", "1", "2"},
                {"1", "2", "3", "1", "2", "3", "1", "2", "3"},
                {"2", "3", "1", "2", "3", "1", "2", "3", "1"},
                {"3", "1", "2", "3", "1", "2", "3", "1", "2"},
                {"1", "2", "3", "1", "2", "3", "1", "2", "3"},
                {"2", "3", "1", "2", "3", "1", "2", "3", "1"},
                {"3", "1", "2", "3", "1", "2", "3", "1", "2"}}, array);
    }

    @Test
    public void testThatSolutionPassesInRowPair() {
        String[][] array = new String[][]{{"12", "12", "123"}, {"2", "3", "1"}, {"3", "1", "2"}};
        SolveSudoku solveSudoku = new RowPair();
        solveSudoku.tryToSolve(array);
        Assert.assertArrayEquals(new String[][]{{"12", "12", "3"}, {"2", "3", "1"}, {"3", "1", "2"}}, array);

    }

    @Test
    public void testThatSolutionPassesInColumnPair() {
        String[][] array = new String[][]{{"12", "2", "3"}, {"12", "3", "1"}, {"123", "1", "2"}};
        SolveSudoku solveSudoku = new ColumnPair();
        solveSudoku.tryToSolve(array);
        Assert.assertArrayEquals(new String[][]{{"12", "2", "3"}, {"12", "3", "1"}, {"3", "1", "2"}}, array);
    }

    @Test
    public void testThatSolutionPassesInSquarePair() {
        String[][] array = new String[][]{{"123", "2", "3", "1", "2", "3", "1", "2", "3"},
                {"2", "23", "1", "2", "3", "1", "2", "3", "1"},
                {"3", "1", "23", "3", "1", "2", "3", "1", "2"},
                {"1", "2", "3", "1", "2", "3", "1", "2", "3"},
                {"2", "3", "1", "2", "3", "1", "2", "3", "1"},
                {"3", "1", "2", "3", "1", "2", "3", "1", "2"},
                {"1", "2", "3", "1", "2", "3", "1", "2", "3"},
                {"2", "3", "1", "2", "3", "1", "2", "3", "1"},
                {"3", "1", "2", "3", "1", "2", "3", "1", "2"}};

        SolveSudoku solveSudoku = new SquarePair();
        solveSudoku.tryToSolve(array);
        Assert.assertArrayEquals(new String[][]{{"1", "2", "3", "1", "2", "3", "1", "2", "3"},
                {"2", "23", "1", "2", "3", "1", "2", "3", "1"},
                {"3", "1", "23", "3", "1", "2", "3", "1", "2"},
                {"1", "2", "3", "1", "2", "3", "1", "2", "3"},
                {"2", "3", "1", "2", "3", "1", "2", "3", "1"},
                {"3", "1", "2", "3", "1", "2", "3", "1", "2"},
                {"1", "2", "3", "1", "2", "3", "1", "2", "3"},
                {"2", "3", "1", "2", "3", "1", "2", "3", "1"},
                {"3", "1", "2", "3", "1", "2", "3", "1", "2"}}, array);
    }
}



