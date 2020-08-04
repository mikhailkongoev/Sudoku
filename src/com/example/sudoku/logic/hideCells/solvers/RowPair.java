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
            return CellHider.checkIfSudokyIsSolved(boardString);
        }

        /**
         * find the same pair in the rows and select the numbers from them
         * @param boardString
         */
        private void findPairs(String[][] boardString) {
            String box = "";
            String digit1 = "";
            String digit2 = "";
            for (int i = 0; i < boardString.length; i++) {
                for (int j = 0; j < boardString[i].length; j++) {
                    if (boardString[i][j].length() == 2 && boardString[i][j].equals(box)) {
                        digit1 = boardString[i][j].substring(0, 1);
                        digit2 = boardString[i][j].substring(1);
                    }
                    box = boardString[i][j];
                }
            }
            removeDigits(boardString, digit1, digit2);
        }

        /**
         * remove selected numbers from unresolved cells in row
         * @param boardString
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
