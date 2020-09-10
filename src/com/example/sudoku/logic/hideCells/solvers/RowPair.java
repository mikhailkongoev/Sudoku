package com.example.sudoku.logic.hideCells.solvers;

import com.example.sudoku.SudokuApp;
import com.example.sudoku.logic.hideCells.CellHider;

public class RowPair implements SolveSudoku {

    /**
     * Tries to solve by finding the same pair of digits in the row and excluding these digits from other cells in the row
     *
     * @param boardString board to solve
     * @return true is successfully solved, false otherwise
     */
    public boolean tryToSolve(String[][] boardString) {
        findPairs(boardString);
        return CellHider.checkIfSudokuIsSolved(boardString);
    }

    /**
     * find the same pair and row index
     *
     * @param boardString to find a pair and row index including this
     */
    private void findPairs(String[][] boardString) {
        String box = "";
        int rowIndex = 0;
        for (int i = 0; i < boardString.length; i++)
            for (int j = 0; j < boardString[i].length; j++) {
                if (rowIndex == i && boardString[i][j].equals(box)) {
                    removeDigits(boardString, rowIndex, box);
                }
                if (boardString[i][j].length() == 2) {
                    box = boardString[i][j];
                    rowIndex = i;
                }
            }
    }

    /**
     * remove selected numbers from unresolved cells in row
     *
     * @param boardString to remove elements
     * @param rowIndex    to indicate the index of the row in which the deletion of elements will be performed
     * @param box         includes items to be removed
     */
    private void removeDigits(String[][] boardString, int rowIndex, String box) {
        for (int j = 0; j < boardString.length; j++) {
            if (boardString[rowIndex][j].length() > 1 && !boardString[rowIndex][j].equals(box)) {
                boardString[rowIndex][j] = boardString[rowIndex][j].replace(box.substring(0, 1), "");
                boardString[rowIndex][j] = boardString[rowIndex][j].replace(box.substring(1), "");
            }
        }
    }
}

