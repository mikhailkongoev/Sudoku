package com.example.sudoku.logic;

public class Cell {
    private final int correctValue;
    private final boolean hidden;
    private int valueFromPlayer;

    public int getCorrectValue() {
        return correctValue;
    }

    public boolean isHidden() {
        return hidden;
    }

    public int getValueFromPlayer() {
        return valueFromPlayer;
    }

    public void setValueFromPlayer(int valueFromPlayer) {
        if (hidden) this.valueFromPlayer = valueFromPlayer;
    }

    public Cell(int correctValue, boolean hiding) {
        this.correctValue = correctValue;
        this.hidden = hiding;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object.getClass() == this.getClass()) {
            Cell cell = (Cell) object;
            return cell.correctValue == this.correctValue;
        }
        return false;
    }

    public int hashCode() {
        return correctValue * 31;
    }

}
