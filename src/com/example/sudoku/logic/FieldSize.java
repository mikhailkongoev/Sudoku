package com.example.sudoku.logic;

public enum FieldSize {
    SMALL(9),
    MEDIUM(16),
    LARGE(25);

    private int size;

    FieldSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
