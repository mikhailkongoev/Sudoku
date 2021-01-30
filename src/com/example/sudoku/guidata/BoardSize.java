package com.example.sudoku.guidata;

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



    public BoardSize(FieldSize fieldSize) {
        this.fieldsize = fieldSize;
        this.row = fieldSize.getSize();
        this.column = fieldSize.getSize();
    }



    @Override
    public String toString() {
        return row + " x " + column;
    }

}
