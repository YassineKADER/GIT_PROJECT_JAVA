package com.example.ygit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    private StackPane contentArea;

    @FXML
    public Button branches;

    @FXML
     private Button logs;

    @FXML
     private Button status;

    //this controler is used to transport between section
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("Home.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Home(ActionEvent event){
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("Home.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Logs(ActionEvent event){
        try{
            if(Ygit.Directory == null){
                throw new IOException();
            }
            Parent fxml = FXMLLoader.load(getClass().getResource("Logs.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please select a directory first (git project)");
            alert.setTitle("Load Problem");
            alert.showAndWait();
        }
    }

    public void Status(ActionEvent event){
        try{
            if(Ygit.Directory == null){
                throw new IOException();
            }
            Parent fxml = FXMLLoader.load(getClass().getResource("Status.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please select a directory first (git project)");
            alert.setTitle("Load Problem");
            alert.showAndWait();

        }
    }

    public void Branches(ActionEvent event){
        try{
            if(Ygit.Directory == null){
                throw new IOException();
            }
            else{
                Parent fxml = FXMLLoader.load(getClass().getResource("Clone.fxml"));
                contentArea.getChildren().removeAll();
                contentArea.getChildren().setAll(fxml);
            }

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please select a directory first (git project)");
            alert.setTitle("Load Problem");
            alert.showAndWait();
        }
    }

   /* @FXML
    private void addelement(ActionEvent event){
        TreeItem<String> folder = new TreeItem<String>("something");
        TreeItem<String> Folder3 = new TreeItem<String>("test5");

        folder.getChildren().add(Folder3);

        explorer.setRoot(folder);
    }*/
}