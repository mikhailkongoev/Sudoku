package com.example.sudoku.logic.hidecells.solvers;

import com.example.sudoku.logic.hidecells.CellHider;

public class RowSudokuSolution implements SolveSudoku {

    /**
     * Solution by excluding already existing digits in row
     *
     * @param boardString board to solve
     * @return true is successfully solved, false otherwise
     */
    public boolean tryToSolve(String[][] boardString) {
        for (int i = 0; i < boardString.length; i++) {
            for (int j = 0; j < boardString.length; j++) {
                if (boardString[i][j].length() > 1) {
                    removeCandidateCells(boardString, i, j);
                }
            }
        }
        return CellHider.checkIfSudokuIsSolved(boardString);
    }

    /**
     * remove digits that are in the solved cell of the row
     *
     * @param boardString to remove candidates
     * @param i           cell row coordinate
     * @param j           cell column coordinate
     */
    private void removeCandidateCells(String[][] boardString, int i, int j) {
        for (int x = 0; x < boardString.length; x++) {
            if (boardString[i][x].length() == 1 && boardString[i][j].length() != 1)
                boardString[i][j] = boardString[i][j].replace(boardString[i][x], "");
        }
    }

}