package com.example.sudoku.test;

import com.example.sudoku.logic.Level;
import com.example.sudoku.logic.Sudoku;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public interface ISudokuStorage {


    public void add(int sudoku, int key);


    public int giveRequesterSudoku(int level);
}
