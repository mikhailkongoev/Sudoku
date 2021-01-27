package com.example.sudoku.test;

import com.example.sudoku.logic.Level;
import com.example.sudoku.logic.Sudoku;

import java.util.ArrayList;
import java.util.HashMap;

public class SudokuStorageStub implements ISudokuStorage {
    private HashMap<Integer, ArrayList> storage;

    public HashMap<Integer, ArrayList> getStorage() {
        return storage;
    }

    public void setStorage() {
        this.storage = storage;
    }

    public SudokuStorageStub() {  storage = new HashMap<>();

    }

    @Override
    public void add(int sudoku, int key) {
        if (storage.containsKey(key)) {
            storage.get(key).add(sudoku);
        } else {
            ArrayList list = new ArrayList<>();
            list.add(sudoku);
            storage.put(key, list);
        }

    }


    @Override
    public int giveRequesterSudoku(int level) {
       int sudoku = 0;
        if (storage.get(level).isEmpty()) {
            System.out.println("Судоку запрашиваемого уровня закончились");
        } else {
            sudoku = (int) storage.get(level).get(0);
            storage.get(level).remove(0);
        }
        return sudoku;
    }
}
