package com.example.sudoku.logic.hideCells.solvers;

import com.example.sudoku.logic.hideCells.CellHider;

public class RowPair implements SolveSudoku {

        /**
         * Tries to solve by finding the same pair of digits in the row and excluding these digits from other cells in the row
         * @param boardString board to solve
         * @return true is successfully solved, false otherwise
         */
        public boolean tryToSolve(String[][] boardString) {
            findPairs(boardString);
            return CellHider.checkIfSudokuIsSolved(boardString);
        }

        /**
         * find the same pair in the rows and select the numbers from them
         * @param boardString to find a pair
         */
        private void findPairs(String[][] boardString) {
            String box = "";
            String digit1 = "";
            String digit2 = "";
            for (String[] strings : boardString) {
                for (String string : strings) {
                    if (string.length() == 2 && string.equals(box)) {
                        digit1 = string.substring(0, 1);
                        digit2 = string.substring(1);
                    }
                    box = string;
                }
            }
            removeDigits(boardString, digit1, digit2);
        }

        /**
         * remove selected numbers from unresolved cells in row
         * @param boardString to remove digits
         * @param digit1 first digit from pair
         * @param digit2 second digit from pair
         */
        private void removeDigits(String[][] boardString, String digit1, String digit2) {
            for (int i = 0; i < boardString.length; i++) {
                for (int j = 0; j < boardString[i].length; j++) {
                    if (boardString[i][j].length() > 1 && !boardString[i][j].equals(digit1 + "" + digit2)) {
                        boardString[i][j] = boardString[i][j].replace(digit1, "");
                        boardString[i][j] = boardString[i][j].replace(digit2, "");
                    }
                }
            }
        }

    }
