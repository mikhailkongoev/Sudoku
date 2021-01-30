package com.example.sudoku.controller;

import com.example.sudoku.guidata.CellTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.sudoku.logic.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


import static com.example.sudoku.logic.Level.EASY;

public class GameController implements Initializable {

    @FXML
    private AnchorPane anchorPaneBaseGame;
    @FXML
    private Button buttonBack;

    private GridPane gridPaneGameField;
    private Sudoku sudoku;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SudokuStorage sudokuStorage;
        if (Initializer.getInstance() != null) sudokuStorage = Initializer.getInstance().getSudokuStorage();
    }

    public void createField(FieldSize fieldSize) {
        gettingSudoku(EASY);
        gridPaneGameField = new GridPane();

        gridPaneGameField.setGridLinesVisible(false);
        anchorPaneBaseGame.getChildren().add(gridPaneGameField);

        AnchorPane.setTopAnchor(gridPaneGameField, 5.0);
        AnchorPane.setLeftAnchor(gridPaneGameField, 5.0);
        AnchorPane.setRightAnchor(gridPaneGameField, 5.0);
        AnchorPane.setBottomAnchor(gridPaneGameField, 40.0);

        ObservableList<ColumnConstraints> columnConstraints = gridPaneGameField.getColumnConstraints();
        columnConstraints.clear();
        ObservableList<RowConstraints> rowConstraints = gridPaneGameField.getRowConstraints();
        rowConstraints.clear();
        int column = fieldSize.getSize();
        int row = fieldSize.getSize();

        for (int i = 0; i < column; i++) {
            columnConstraints.add(new ColumnConstraints(10, 100, Double.MAX_VALUE));
        }

        for (int i = 0; i < row; i++) {
            rowConstraints.add(new RowConstraints(10, 100, Double.MAX_VALUE));
        }

        initCell(fieldSize);
    }

    private void initCell(FieldSize fieldSize) {
        int column = fieldSize.getSize();
        int row = fieldSize.getSize();
        int countNextRow = 0;
        int count = 0;
        int countRow = (int) Math.sqrt(row);
        int countColumn = (int) Math.sqrt(column);

        String cssClass = "cellFirst";

        for (int i = 0; i < column; i++) {

            if (countNextRow == countRow) {
                countNextRow = 0;
                cssClass = cssClass.equals("cellFirst") ? "cellSecond" : "cellFirst";
            }
            countNextRow++;

           sudoku = gettingSudoku(EASY);
            for (int j = 0; j < row; j++) {
                CellTextField cell = new CellTextField(j, i, sudoku.getCells()[i][j].getCORRECT_VALUE());
                cell.setAlignment(Pos.CENTER);

                if (count >= countColumn) {
                    cssClass = cssClass.equals("cellFirst") ? "cellSecond" : "cellFirst";
                    count = 0;
                }

                cell.getStyleClass().add(cssClass);
                count++;

                cell.setOnMouseClicked((MouseEvent event) -> System.out.println("Cell: " + cell.getValue() + " (" + cell.getX() + "," + cell.getY() + ")"));

                cell.setOnKeyTyped((KeyEvent event) -> {
                    if (!Character.isDigit(event.getCharacter().charAt(0))) {
                        event.consume();
                    }
                });

                cell.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

                GridPane.setHgrow(cell, Priority.ALWAYS);
                GridPane.setVgrow(cell, Priority.ALWAYS);
                GridPane.setMargin(cell, new Insets(2));
                gridPaneGameField.add(cell, j, i);

            }
            if (countColumn % 2 != 0) {
                cssClass = cssClass.equals("cellFirst") ? "cellSecond" : "cellFirst";
            }
        }
    }


    private Sudoku gettingSudoku(Level level) {
        return Initializer.getInstance().getSudokuStorage().giveRequesterSudoku(level);
    }

    @FXML
    private void buttonBackOnAction() throws IOException {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/sudoku/fxml/start.fxml"));
            AnchorPane page = loader.load();

            page.setPrefSize(400, 400);

            Stage stage = (Stage) anchorPaneBaseGame.getScene().getWindow();
            Scene scene = new Scene(page);
            stage.setScene(scene);
    }

}
