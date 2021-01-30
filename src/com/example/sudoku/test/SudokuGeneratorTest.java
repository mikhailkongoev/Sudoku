package com.example.sudoku.test;

import com.example.sudoku.logic.*;
import com.example.sudoku.logic.generate.BoardFactory;
import com.example.sudoku.logic.hidecells.CellHider;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class SudokuGeneratorTest {

    private static BoardFactory boardFactory;
    private static CellHider cellHider;

    @BeforeClass
    public static void beforeClass() {
        boardFactory = Mockito.mock(BoardFactory.class);
        cellHider = Mockito.mock(CellHider.class);
    }

    @Test
    public void testThatStorageIsFilledSudoku() {
        int[][] array = {{1, 1, 1}, {1, 1, 1}};
        Cell[][] hidingArray = {{new Cell(1, true), new Cell(1, true)}, {new Cell(1, true), new Cell(1, true)}};
        Mockito.when(boardFactory.generateBoard()).thenReturn(array);
        Mockito.when(cellHider.makeBoardWithHiddenCells(array)).thenReturn(hidingArray);
        Sudoku sudoku = new Sudoku(hidingArray);
        SudokuStorage sudokuStorage = new SudokuStorage();
        sudokuStorage.add(sudoku);
        Sudoku su = sudokuStorage.giveRequesterSudoku(sudoku.getLevel());
        Assert.assertTrue(sudoku.equals(su));
    }
}
