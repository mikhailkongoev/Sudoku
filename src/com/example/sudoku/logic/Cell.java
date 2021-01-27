package com.example.sudoku.logic;

public class Cell {
    private final int CORRECT_VALUE;
    private final boolean HIDING;
    private int valueFromPlayer;

    public int getCORRECT_VALUE() {
        return CORRECT_VALUE;
    }

    public boolean isHIDING() {
        return HIDING;
    }

    public int getValueFromPlayer() {
        return valueFromPlayer;
    }

    public void setValueFromPlayer(int valueFromPlayer) {
        if (HIDING) this.valueFromPlayer = valueFromPlayer;
    }

    public Cell(int correct_value, boolean hiding) {
        this.CORRECT_VALUE = correct_value;
        this.HIDING = hiding;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object.getClass() == this.getClass()) {
            Cell cell = (Cell) object;
            return cell.CORRECT_VALUE == this.CORRECT_VALUE;
        }
        return false;
    }

    public int hashCode() {
        return CORRECT_VALUE * 31;
    }

}
