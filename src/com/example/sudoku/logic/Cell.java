package com.example.sudoku.logic;

public class Cell {
    final int CORRECT_VALUE;
    final boolean HIDING;
    int valueFromPlayer;

    public void setValueFromPlayer(int valueFromPlayer) {
        this.valueFromPlayer = valueFromPlayer;
    }

    public Cell(int correct_value, boolean hiding) {
        CORRECT_VALUE = correct_value;
        HIDING = hiding;
    }
}
