package com.example.sudoku.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;


public class SudokuStorage {
    private final Map<Level, Map<FieldSize, List<Sudoku>>> storage;

    public SudokuStorage() {
        storage = new EnumMap<>(Level.class);
        Arrays.stream(Level.values()).forEach(level -> {
            Map<FieldSize, List<Sudoku>> map = new EnumMap<>(FieldSize.class);
            storage.put(level, map);

            Arrays.stream(FieldSize.values()).forEach(fieldSize -> map.put(fieldSize, new ArrayList<>()));
        });
    }

    /**
     * adds sudoku to the list of suitable levels and fiel size.
     *
     * @param sudoku to add to the list
     */
    public void add(Sudoku sudoku) {
        storage.get(sudoku.getLevel()).get(sudoku.getFieldSize()).add(sudoku);
    }


    /**
     * choose the desired level from the sudoku storage
     *
     * @param level to select the sudoku of the desired level
     * @return sudoku of the requested level
     */
    public Sudoku giveRequesterSudoku(FieldSize fieldSize, Level level) {
        Sudoku sudoku = null;

        if (storage.get(level).get(fieldSize).isEmpty()) {
            System.out.println("Судоку запрашиваемого уровня закончились");
        } else {
            sudoku = storage.get(level).get(fieldSize).get(0);
            storage.get(level).get(fieldSize).remove(0);
        }

        return sudoku;
    }
}




