package com.example.sudoku.logic.hidecells.solvers;

import com.example.sudoku.logic.hidecells.CellHider;


public class ColumnPair implements SolveSudoku {
    /**
     * Tries to solve by finding the same pair of digits in the column and excluding these digits from other cells in the column
     *
     * @param boardString board to solve
     * @return true is successfully solved, false otherwise
     */
    public boolean tryToSolve(String[][] boardString) {
        findPairs(boardString);
        return CellHider.checkIfSudokuIsSolved(boardString);
    }

    /**
     * find the same pair in the column and select the numbers from them
     *
     * @param boardString to find a pair and column index including this
     */
    private void findPairs(String[][] boardString) {

        String box = "";
        int columnIndex = 0;
        for (int i = 0; i < boardString.length; i++) {
            for (int j = 0; j < boardString[i].length; j++) {
                if (i == columnIndex && boardString[j][i].equals(box)) {
                    removeDigits(boardString, columnIndex, box);
                }
                if (boardString[j][i].length() == 2) {
                    box = boardString[j][i];
                    columnIndex = i;
                }
            }
        }
    }

    /**
     * remove selected elements from unresolved cells in column
     * @param boardString to remove elements
     * @param columnIndex to indicate the index of the column in which the deletion of elements will be performed
     * @param box         includes items to be removed
     */
    private void removeDigits(String[][] boardString, int columnIndex, String box) {
        for (int i = 0; i < boardString.length; i++) {
            if (boardString[i][columnIndex].length() > 1 && !boardString[i][columnIndex].equals(box)) {
                boardString[i][columnIndex] = boardString[i][columnIndex].replace(box.substring(0, 1), "");
                boardString[i][columnIndex] = boardString[i][columnIndex].replace(box.substring(1), "");
            }
        }
    }
}

