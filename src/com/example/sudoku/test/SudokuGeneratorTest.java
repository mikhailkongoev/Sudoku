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
    private static SudokuStorage sudokuStorage;

    @BeforeClass
    public static void beforeClass() {
        boardFactory = Mockito.mock(BoardFactory.class);
        cellHider = Mockito.mock(CellHider.class);
        sudokuStorage = new SudokuStorage();
    }

    @Test
    public void testThatStorageIsFilledSudoku() {
        int[][] array = {{1, 1, 1}, {1, 1, 1}};
        Cell[][] hidingArray = {{new Cell(1, true),
                                    new Cell(1, true)},
                                {new Cell(1, true),
                                    new Cell(1, true)}};

        Mockito.when(boardFactory.generateBoard()).thenReturn(array);
        Mockito.when(boardFactory.getFieldSize()).thenReturn(FieldSize.SMALL);
        Mockito.when(cellHider.makeBoardWithHiddenCells(array)).thenReturn(hidingArray);

        SudokuGenerator generator = new SudokuGenerator(boardFactory, cellHider, sudokuStorage);
        generator.fillStorage();

        Sudoku su = sudokuStorage.giveRequesterSudoku(FieldSize.SMALL, Level.EASY);
        Assert.assertNotNull(su);
    }
}
