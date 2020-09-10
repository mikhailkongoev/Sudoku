package com.example.sudoku.logic;

import java.util.ArrayList;
import java.util.HashSet;

public class SudokuStorage {
    private HashSet level1;
    private HashSet level2;
    private HashSet level3;


    public void generateManySudoku(int size) {

        for (int i = 0; i < 100; i++) {
            new Sudoku(9).generateSudoku();
        }
    }
}
