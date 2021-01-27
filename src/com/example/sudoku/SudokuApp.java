package com.example.sudoku;

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
         Application.launch();
        //    Initializer.getInstance().init(SMALL);

    }
}
