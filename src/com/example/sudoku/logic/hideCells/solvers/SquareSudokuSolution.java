package com.example.sudoku.logic.hideCells.solvers;

import com.example.sudoku.logic.hideCells.CellHider;

public class SquareSudokuSolution implements SolveSudoku {

    /**
     * Solution by excluding already existing digits in square
     *
     * @param boardString board to solve
     * @return true is successfully solved, false otherwise
     */
    public boolean tryToSolve(String[][] boardString) {
        for (int i = 0; i < boardString.length; i++) {
            for (int j = 0; j < boardString[i].length; j++) {
                if (boardString[i][j].length() > 1) {
                    removeCandidateCells(boardString, i, j);
                }
            }
        }
        return CellHider.checkIfSudokuIsSolved(boardString);
    }

    /**
     * remove digits that are in the solved cell of the square
     *
     * @param boardString to remove digits
     * @param i           cell row coordinate
     * @param j           cell column coordinate
     */
    private void removeCandidateCells(String[][] boardString, int i, int j) {
        int squareLength = (int) Math.sqrt(boardString.length);
        int rowRegion = i / squareLength;
        int columnRegion = j / squareLength;
        for (int x = rowRegion * squareLength; x < rowRegion * squareLength + squareLength; x++) {
            for (int y = columnRegion * squareLength; y < columnRegion * squareLength + squareLength; y++)
                if (boardString[x][y].length() == 1 && boardString[i][j].length() != 1)
                    boardString[i][j] = boardString[i][j].replace(boardString[x][y], "");
        }
    }
}

