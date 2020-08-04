package com.example.sudoku.logic.hideCells.solvers;

import com.example.sudoku.logic.hideCells.CellHider;

public class SquarePair implements SolveSudoku {

    public boolean tryToSolve(String[][] boardString) {
        findFirstPair(boardString);
        return CellHider.checkIfSudokyIsSolved(boardString);
    }

    private void findFirstPair(String[][] boardString) {
        for (int i = 0; i < boardString.length; i++) {
            for (int j = 0; j < boardString[i].length; j++) {
                if (boardString[i][j].length() == 2) findSecondPair(boardString, i, j);
            }
        }
    }

    private void findSecondPair(String[][] boardString, int i, int j) {
        String digit1;
        String digit2;
        int squareLength = (int) Math.sqrt(boardString.length);
        int rowRegion = i / squareLength;
        int columnRegion = j / squareLength;
        for (int x = rowRegion * squareLength; x < rowRegion * squareLength + squareLength; x++) {
            for (int y = columnRegion * squareLength; y < columnRegion * squareLength + squareLength; y++) {
                if (boardString[x][y].equals(boardString[i][j]) && (x != i && y != j)) {
                    digit1 = boardString[i][j].substring(0, 1);
                    digit2 = boardString[i][j].substring(1);
                    removeDigits(boardString, digit1, digit2, i, j);
                }
            }
        }
    }

    /**
     * remove selected numbers from unresolved cells in rows
     *
     * @param boardString
     * @param digit1      first digit from pair
     * @param digit2      second digit from pair
     */
    private void removeDigits(String[][] boardString, String digit1, String digit2, int i, int j) {
        int squareLength = (int) Math.sqrt(boardString.length);
        int rowRegion = i / squareLength;
        int columnRegion = j / squareLength;
        for (int x = rowRegion * squareLength; x < rowRegion * squareLength + squareLength; x++) {
            for (int y = columnRegion * squareLength; y < columnRegion * squareLength + squareLength; y++) {
                if (boardString[x][y].length() > 1 && !boardString[x][y].equals(digit1 + "" + digit2)) {
                    boardString[x][y] = boardString[x][y].replace(digit1, "");
                    boardString[x][y] = boardString[x][y].replace(digit2, "");
                }
            }
        }
    }

}

