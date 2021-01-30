package com.example.sudoku.logic;

import java.security.SecureRandom;

public enum Level {

    EASY("легкий"),
    MIDDLE("средний"),
    HARD("сложный");

    private String title;
    private static final SecureRandom random = new SecureRandom();

    public String getTitle() {
        return title;
    }

    public static Level getRandomLevel(){
        return Level.values()[random.nextInt(Level.values().length)];
    }

    Level(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
