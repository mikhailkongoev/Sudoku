package com.example.sudoku.controller;

import com.example.sudoku.guidata.BoardSize;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.sudoku.logic.FieldSize;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartController implements Initializable {

    @FXML
    private AnchorPane anchorPaneBaseStart;
    @FXML
    private Button buttonStart;
    @FXML
    private ChoiceBox<BoardSize> choiceBoxFieldSize;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initChoiceBoxFieldSize();
    }

    private void initChoiceBoxFieldSize() {
        ObservableList<BoardSize> listFieldSize = FXCollections.observableArrayList(
                new BoardSize(FieldSize.SMALL),
                new BoardSize(FieldSize.MEDIUM),
                new BoardSize(FieldSize.LARGE));
        choiceBoxFieldSize.setItems(listFieldSize);
        choiceBoxFieldSize.getSelectionModel().select(0);
    }


    @FXML
    private void buttonStartOnAction() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/sudoku/fxml/game.fxml"));
        AnchorPane page = loader.load();
        BoardSize fs = choiceBoxFieldSize.getSelectionModel().getSelectedItem();
        page.setPrefSize(30 * fs.getColumn() + 250, 30 * fs.getRow() + 250 + 40);

        Stage stage = (Stage) anchorPaneBaseStart.getScene().getWindow();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        GameController controller = loader.getController();
        controller.createField(FieldSize.SMALL);

    }

}
