package com.example.sudoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.sudoku.logic.generate.BoardFactory;
import com.example.sudoku.logic.hideCells.CellHider;

import java.util.Random;

public class SudokuApp extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/sudoku/fxml/start.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("СУДОКУ");
        stage.setResizable(true);
        stage.show();
    }


    public static void main(String[] args) {
        Application.launch();

        BoardFactory boardFactory = new BoardFactory();
        int[][] board = boardFactory.generateBoard(9);
        Random random = new Random();
        CellHider cellHider = new CellHider(random);
        cellHider.selectCell(board);
    }

}