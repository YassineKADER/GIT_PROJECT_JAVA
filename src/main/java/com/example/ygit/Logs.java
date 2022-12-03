package com.example.ygit;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Logs implements Initializable {
    @FXML
    private TableColumn<?, ?> author;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private TableColumn<?, ?> description;
    @FXML
    private TableView<?> loglist;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i=0; i<10; i++){
            author.setCellValueFactory(new PropertyValueFactory<>(new String(String.valueOf(i))));
            date.setCellValueFactory(new PropertyValueFactory<>(new String(String.valueOf(i))));
            description.setCellValueFactory(new PropertyValueFactory<>(new String(String.valueOf(i))));


        }
    }
}
