package com.example.sudoku.logic;

import java.util.ArrayList;
import java.util.HashMap;


public class SudokuStorage {
    private HashMap<Level, ArrayList<Sudoku>> storage;

    public HashMap<Level, ArrayList<Sudoku>> getStorage() {
        return storage;
    }

    public void setStorage() {
        this.storage = storage;
    }

    public SudokuStorage() {
        storage = new HashMap<>();
    }

    /**
     * adds sudoku to the list of suitable levels. If there is no list, creates one and adds sudoku to it.
     *
     * @param sudoku to add to the list
     */
    public void add(Sudoku sudoku) {
        if (storage.containsKey(sudoku.getLevel())) {
            storage.get(sudoku.getLevel()).add(sudoku);
        } else {
            ArrayList<Sudoku> list = new ArrayList<>();
            list.add(sudoku);
            storage.put(sudoku.getLevel(), list);
        }

    }


    /**
     * choose the desired level from the sudoku storage
     *
     * @param level to select the sudoku of the desired level
     * @return sudoku of the requested level
     */
    public Sudoku giveRequesterSudoku(Level level) {
        Sudoku sudoku = null;
        if (storage.get(level).isEmpty()) {
            System.out.println("Судоку запрашиваемого уровня закончились");
        } else {
            sudoku = storage.get(level).get(0);
            storage.get(level).remove(0);
        }
        return sudoku;
    }
}




