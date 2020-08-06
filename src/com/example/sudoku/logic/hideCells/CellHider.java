package com.example.sudoku.logic.hideCells;

import com.example.sudoku.logic.generate.BoardFactory;
import com.example.sudoku.logic.hideCells.solvers.*;

import java.util.Random;

public class CellHider {
    private Random random;

    public CellHider(Random random) {
        this.random = random;
    }

    public int[][] choiceLevel(int size, int level) {

        int[][] board1 = new int[size][size];
        int[][] board2 = new int[size][size];
        int[][] board3 = new int[size][size];

        BoardFactory boardFactory = new BoardFactory();
        int[][] board = boardFactory.generateBoard(size);

        boolean a = false;
        while (!a) {
            int[][] unsorted = selectCell(board);
            int count = countAmountOfHiddenCells(unsorted);
            if (count >= 28 && count < 35) board1 = unsorted;
            else if (count >= 35 && count < 42) board2 = unsorted;
            else if (count >= 42) board3 = unsorted;
            board = boardFactory.generateBoard(size);
            if (cheсkTheBoardIsFull(board1) && cheсkTheBoardIsFull(board2) && cheсkTheBoardIsFull(board3)) a = true;
        }

        int[][] finalBoard = new int[size][size];
        switch (level) {
            case (1):
                finalBoard = board1;
                break;
            case (2):
                finalBoard = board2;
                break;
            case (3):
                finalBoard = board3;
                break;
        }
        printTheBoard(finalBoard);
        return finalBoard;
    }

    private boolean cheсkTheBoardIsFull(int[][] board) {
        boolean a = false;
        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    a = true;
                    break;
                }
            }
        }
        return a;
    }

    private int countAmountOfHiddenCells(int[][] preBoard) {
        int count = 0;
        for (int[] ints : preBoard) {
            for (int j = 0; j < preBoard.length; j++) {
                if (ints[j] == 0) count++;
            }
        }
        return count;
    }

    /**
     * The method randomly selects cells and hides their value as long as the Sudoku remains solvable
     *
     * @param board for hiding cells
     * @return board altered
     */
    private int[][] selectCell(int[][] board) {
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
        return board;
    }

    private void printTheBoard(int[][] board) {
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
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

