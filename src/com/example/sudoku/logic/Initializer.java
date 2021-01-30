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
        }
        return instance;
    }

    public void init(FieldSize fieldSize) {
        BoardFactory boardFactory = new BoardFactory(fieldSize);
        Random random = new Random();
        CellHider cellHider = new CellHider(random);
        SudokuStorage sudokuStorage = new SudokuStorage();
        SudokuGenerator sudokuGenerator = new SudokuGenerator(boardFactory, cellHider, sudokuStorage);
        sudokuGenerator.fillStorage();
    }
}
