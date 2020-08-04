package com.example.sudoku.logic.hideCells;

import com.example.sudoku.logic.generate.BoardFactory;
import com.example.sudoku.logic.hideCells.solvers.*;

import java.util.Random;

public class CellHider {
    private Random random;

    public CellHider(Random random) {
        this.random = random;
    }

    /**
     * The method randomly selects cells and hides their value as long as the Sudoku remains solvable
     *
     * @param board for hiding cells
     * @return board altered
     */
    public int[][] selectCell(int[][] board) {
        int row;
        int column;
        boolean decisionResult = true;
        while (decisionResult) {
            row = random.nextInt(board.length);
            column = random.nextInt(board.length);
            if (board[row][column] != 0) {
                int box = board[row][column];
                board[row][column] = 0;
                decisionResult = checkSudoku(board);
                if (!decisionResult) board[row][column] = box;
            }
        }

        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        return board;
    }

    private String[][] turnBoardToString(int[][] board) {
        String[][] boardString = new String[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0)
                    boardString[i][j] = "123456789";
                else
                    boardString[i][j] = Integer.toString(board[i][j]);
            }
        }
        return boardString;
    }

    private boolean checkSudoku(int[][] board) {
        String[][] boardString = turnBoardToString(board);

        SolveSudoku[] solveSudokus = new SolveSudoku[6];
        solveSudokus[0] = new RowSudokuSolution();
        solveSudokus[1] = new ColumnSudokuSolution();
        solveSudokus[2] = new SquareSudokuSolution();
        solveSudokus[3] = new RowPair();
        solveSudokus[4] = new ColumnPair();
        solveSudokus[5] = new SquarePair();

        boolean decisionResult = false;
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < solveSudokus.length; i++) {
                decisionResult = solveSudokus[i].tryToSolve(boardString);
                if (decisionResult == true) return decisionResult;
            }
        }
        return decisionResult;
    }

    public static boolean checkIfSudokyIsSolved(String[][] boardString) {
        boolean result = true;
        for (String[] strings : boardString) {
            for (String string : strings) {
                if (string.length() > 1) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}

