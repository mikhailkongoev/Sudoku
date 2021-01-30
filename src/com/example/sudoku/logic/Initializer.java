package com.example.sudoku.logic;

import com.example.sudoku.logic.generate.BoardFactory;
import com.example.sudoku.logic.hidecells.CellHider;

import java.util.Random;

public class Initializer {
    private static Initializer instance;
    private BoardFactory boardFactory;
    private CellHider cellHider;
    private Random random;
    private SudokuGenerator sudokuGenerator;
    private SudokuStorage sudokuStorage;

    public SudokuStorage getSudokuStorage() {
        return sudokuStorage;
    }

    private Initializer() {
    }

    public static Initializer getInstance() {
        if (instance == null) {
            instance = new Initializer();
            instance.init();
        }
        return instance;
    }

    public void init() {
        random = new Random();
        boardFactory = new BoardFactory(random);
        cellHider = new CellHider(random);
        sudokuStorage = new SudokuStorage();
        sudokuGenerator = new SudokuGenerator(boardFactory, cellHider, sudokuStorage);
        sudokuGenerator.fillStorage();
    }
}
