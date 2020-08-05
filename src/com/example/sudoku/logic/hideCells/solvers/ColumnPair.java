package com.example.sudoku.logic.hideCells.solvers;

import com.example.sudoku.logic.hideCells.CellHider;


public class ColumnPair implements SolveSudoku {
    /**
     * Tries to solve by finding the same pair of digits in the column and excluding these digits from other cells in the column
     * @param boardString board to solve
     * @return true is successfully solved, false otherwise
     */
    public boolean tryToSolve(String[][] boardString) {
        findPairs(boardString);
        return CellHider.checkIfSudokuIsSolved(boardString);
    }

    /**
     * find the same pair in the column and select the numbers from them
     * @param boardString to find a pair
     */
    private void findPairs(String[][] boardString) {
        String box = "";
        String digit1 = "";
        String digit2 = "";
        for (int i = 0; i < boardString.length; i++) {
            for (int j = 0; j < boardString[i].length; j++) {
                if (boardString[j][i].length() == 2 && boardString[j][i].equals(box)) {
                    digit1 = boardString[j][i].substring(0, 1);
                    digit2 = boardString[j][i].substring(1);
                }
                box = boardString[j][i];
            }
        }
        removeDigits(boardString, digit1, digit2);
    }

    /**
     * remove selected numbers from unresolved cells
     * @param boardString to remove cells
     * @param digit1 first digit from pair
     * @param digit2 second digit from pair
     */
    private void removeDigits(String[][] boardString, String digit1, String digit2) {
        for (int i = 0; i < boardString.length; i++) {
            for (int j = 0; j < boardString[i].length; j++) {
                if (boardString[j][i].length() > 1 && !boardString[j][i].equals(digit1 + "" + digit2)) {
                    boardString[j][i] = boardString[j][i].replace(digit1, "");
                    boardString[j][i] = boardString[j][i].replace(digit2, "");
                }
            }
        }
    }
}
