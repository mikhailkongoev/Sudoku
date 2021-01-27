package com.example.sudoku.logic.hideCells;

import com.example.sudoku.logic.Cell;
import com.example.sudoku.logic.hideCells.solvers.*;


import java.util.Random;

public class CellHider {
    final Random RANDOM;

    public CellHider(Random random) {
        RANDOM = random;
    }

    /**
     * board is generated ready to game
     *
     * @param correctBoard for hide cells in it
     * @return board ready to game as an array of cells
     */
    public Cell[][] makeBoardWithHiddenCells(int[][] correctBoard) {
        int[][] intermediateBoard = fillIntermediateBoard(correctBoard);
        int[][] boardWithHiddenCells = selectCell(intermediateBoard);
        Cell[][] gameReadyBoard = new Cell[boardWithHiddenCells.length][boardWithHiddenCells.length];
        for (int i = 0; i < gameReadyBoard.length; i++) {
            for (int j = 0; j < gameReadyBoard.length; j++) {
                if (boardWithHiddenCells[i][j] == 0)
                    gameReadyBoard[i][j] = new Cell(correctBoard[i][j], true);
                else gameReadyBoard[i][j] = new Cell(correctBoard[i][j], false);
            }
        }
        return gameReadyBoard;
    }

    private int[][] fillIntermediateBoard(int[][] correctBoard) {
        int[][] intermediateBoard = new int[correctBoard.length][correctBoard.length];
        for (int i = 0; i < intermediateBoard.length; i++) {
            System.arraycopy(correctBoard[i], 0, intermediateBoard[i], 0, intermediateBoard[i].length);
        }
        return intermediateBoard;
    }

    /**
     * The method randomly selects cells and hides their value as long as the Sudoku remains solvable
     *
     * @param board for hiding cells
     * @return board altered
     */
    private int[][] selectCell(int[][] board) {
        int count = 0;
        int row;
        int column;
        boolean decisionResult = true;
        while (decisionResult) {
            row = RANDOM.nextInt(board.length);
            column = RANDOM.nextInt(board.length);
            if (board[row][column] != 0) {
                int box = board[row][column];
                board[row][column] = 0;
                count++;
                decisionResult = checkSudoku(board);
                if (count < 30) decisionResult = true;
                if (count > 58) decisionResult = false;
                if (!decisionResult) board[row][column] = box;
            }
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

        boolean decisionResult;
        for (int j = 0; j < 5; j++) {
            for (SolveSudoku sudokus : solveSudokus) {
                decisionResult = sudokus.tryToSolve(boardString);
                if (decisionResult) return true;
            }
        }

        int way = RANDOM.nextInt(2);
        if (way == 1) return findPair(boardString);
        return false;
    }

    private boolean findPair(String[][] boardString) {
        String box = "";
        for (String[] strings : boardString) {
            for (String string : strings) {
                if (string.equals(box) && !box.equals("")) return true;
                if (string.length() == 2) box = string;
            }
        }
        return false;
    }

    public static boolean checkIfSudokuIsSolved(String[][] boardString) {
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


