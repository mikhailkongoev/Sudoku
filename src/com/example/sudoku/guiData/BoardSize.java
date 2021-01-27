package com.example.sudoku.guiData;

import com.example.sudoku.logic.FieldSize;

public class BoardSize {
    private FieldSize fieldsize;
    private int row;
    private int column;

    public FieldSize getFieldsize() {
        return fieldsize;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }



    public BoardSize(FieldSize fieldSize, int row, int column) {
        this.fieldsize = fieldSize;
        this.row = row;
        this.column = column;
    }



    @Override
    public String toString() {
        return row + " x " + column;
    }

}
