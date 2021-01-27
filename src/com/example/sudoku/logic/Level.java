package com.example.sudoku.logic;

public enum Level {

    EASY("легкий"),
    MIDDLE("средний"),
    HARD("сложный");

    private String tittle;

    public String getTittle() {
        return tittle;
    }

    Level(String tittle) {
        this.tittle = tittle;
    }

    @Override
    public String toString() {
        return tittle;
    }
}
