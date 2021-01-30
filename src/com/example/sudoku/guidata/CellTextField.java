package com.example.sudoku.guidata;

import javafx.scene.control.TextField;

public class CellTextField extends TextField{
    
    private int x;
    private int y;
    private int value;

    public CellTextField(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CellTextField(int x, int y, int value) {
        this.x = x;
        this.y = y;
        setValue(value);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        setText("" + value);
    }

}
