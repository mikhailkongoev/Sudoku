package com.example.sudoku.logic;

public class Sudoku {
    private Cell[][] cells;
    private Level level;
    private FieldSize fieldSize;

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Level getLevel() {
        return determinateLevel();
    }


    public Sudoku(Cell[][] cellsArray, FieldSize fieldSize) {
        this.cells = cellsArray;
        this.fieldSize = fieldSize;
    }


    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean comparison = true;
        if (object.getClass() == this.getClass()) {
            Sudoku sudoku = (Sudoku) object;
            for (int i = 0; i < this.cells.length; i++) {
                for (int j = 0; j < this.cells.length; j++) {
                    comparison = (this.cells[i][j].equals(sudoku.cells[i][j]));
                    if (!comparison) return false;
                }
            }
            return comparison;
        } else return false;
    }

    /**
     * @param clearingHidden to print the correct sudoku pass false, to print the sudoku with hidden cells pass true
     */
    public void printSudoku(boolean clearingHidden) {
        for (Cell[] row : cells) {
            for (Cell value : row) {
                if (clearingHidden && value.isHidden()) System.out.print("0" + " ");
                else System.out.print(value.getCorrectValue() + " ");
            }
            System.out.println();
        }
    }

    /**
     * Depending on how many hidden cells the difficulty level is assigned
     *
     * @return sudoku level
     */
    private Level determinateLevel() {
        int numberOfHiddenCells = countNumberOfHiddenCells();
        if (numberOfHiddenCells < 40) level = Level.EASY;
        else if (numberOfHiddenCells < 47) level = Level.MIDDLE;
        else level = Level.HARD;
        return level;
    }

    /**
     * Count the number of cells that were hidden from user
     *
     * @return number of hiding cells
     */
    private int countNumberOfHiddenCells() {
        int count = 0;
        for (Cell[] row : cells) {
            for (Cell value : row) {
                if (value.isHidden()) count++;
            }
        }
        return count;
    }

    public FieldSize getFieldSize() {
        return fieldSize;
    }
}