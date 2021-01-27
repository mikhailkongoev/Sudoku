package com.example.sudoku.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class SudokuStorageTest {
    private SudokuStorageStub iSudokuStorage = new SudokuStorageStub();


    @Test
    public void testThatSudokuIsAddedToTheList() {
        int sudoku = 1;
        int key = 2;
        iSudokuStorage.add(sudoku, key);

        Assert.assertTrue(iSudokuStorage.getStorage().get(key).equals(sudoku));
    }


    @Test
    public void testThatSudokuOfTheRequiredLevel() {
        int sudoku = 1;
        int key = 2;
        iSudokuStorage.add(sudoku, key);
        int requestedLevel = 2;
        int requesterSudoku = iSudokuStorage.giveRequesterSudoku(requestedLevel);
        Assert.assertEquals(sudoku, requesterSudoku);
    }
}
