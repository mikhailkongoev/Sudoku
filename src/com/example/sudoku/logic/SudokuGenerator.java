package com.example.sudoku.logic;

import com.example.sudoku.logic.generate.BoardFactory;
import com.example.sudoku.logic.hidecells.CellHider;
import java.util.Arrays;

public class SudokuGenerator {
    interface TableGeneratedCallback {
        void onTableReady();
    }

    TableGeneratedCallback tableGeneratedCallback;
    private BoardFactory boardFactory;
    private CellHider cellHider;
    private SudokuStorage sudokuStorage;

    public BoardFactory getBoardFactory() {
        return boardFactory;
    }

    public CellHider getCellHider() {
        return cellHider;
    }

    public SudokuStorage getSudokuStorage() {
        return sudokuStorage;
    }

    public void setSudokuStorage(SudokuStorage sudokuStorage) {
        this.sudokuStorage = sudokuStorage;
    }

    public void setTableGeneratedCallBack(TableGeneratedCallback tableGeneratedCallback) {
        this.tableGeneratedCallback = tableGeneratedCallback;
    }

    public SudokuGenerator(BoardFactory boardFactory, CellHider cellHider, SudokuStorage sudokuStorage) {
        this.boardFactory = boardFactory;
        this.cellHider = cellHider;
        this.sudokuStorage = sudokuStorage;
    }


    /**
     * fills the storage sudoku
     */
    public void fillStorage() {
        Arrays.stream(FieldSize.values()).forEach(fieldSize -> {
            boardFactory.setFieldSize(fieldSize);

            for (int i = 0; i < 100; i++) {
                Sudoku sudoku = new Sudoku(cellHider.makeBoardWithHiddenCells(boardFactory.generateBoard()));
                sudokuStorage.add(sudoku);
            }
        });

        if (tableGeneratedCallback != null) tableGeneratedCallback.onTableReady();
    }
}

