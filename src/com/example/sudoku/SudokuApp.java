package com.example.sudoku;

import com.example.sudoku.logic.Sudoku;
import com.example.sudoku.logic.SudokuStorage;
import com.example.sudoku.logic.hideCells.solvers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        // Application.launch();
        // Sudoku sudoku = new Sudoku(9);
        //  sudoku.printTheSudoku(sudoku.generateSudoku(), true);
        //  System.out.print(sudoku.getLevel());
        SudokuStorage o = new SudokuStorage();
        o.generateManySudoku(9);
        int one = 0;
        int two = 0;
        int three = 0;
        for (int i = 0; i < 100; i++) {
            Sudoku sudoku = new Sudoku(9);
            sudoku.generateSudoku();
            if (sudoku.getLevel() == 1) one++;
            if (sudoku.getLevel() == 2) two++;
            if (sudoku.getLevel() == 3) three++;
        }
        System.out.println(one + "," + two + "," + three);
    }
}