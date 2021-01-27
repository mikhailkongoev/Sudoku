package com.example.sudoku.logic;

public class Loading implements SudokuGenerator.TableGeneratedCallback {

    @Override
    public void onTableReady() {
        System.out.println("Судоку прогрузились");
    }
}
