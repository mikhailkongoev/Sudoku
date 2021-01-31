package com.example.sudoku.test;

import com.example.sudoku.logic.FieldSize;
import com.example.sudoku.logic.Level;
import com.example.sudoku.logic.Sudoku;
import com.example.sudoku.logic.SudokuStorage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class SudokuStorageTest {
    private SudokuStorage iSudokuStorage = new SudokuStorage();


    @Test
    public void testThatSudokuIsAddedToTheList() {
        FieldSize fieldSize = FieldSize.SMALL;
        Level level = Level.EASY;

        Sudoku sudoku = Mockito.mock(Sudoku.class);
        Mockito.when(sudoku.getFieldSize()).thenReturn(fieldSize);
        Mockito.when(sudoku.getLevel()).thenReturn(level);

        Assertions.assertNull(iSudokuStorage.giveRequesterSudoku(fieldSize, level));

        iSudokuStorage.add(sudoku);

        Assert.assertEquals(iSudokuStorage.giveRequesterSudoku(fieldSize, level), sudoku);
    }
}
