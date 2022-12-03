package com.example.ygit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController{


    @FXML
    private TreeView explorer;

    @FXML
    private StackPane contentArea;


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
            Parent fxml = FXMLLoader.load(getClass().getResource("Logs.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Status(ActionEvent event){
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("Status.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Branches(ActionEvent event){
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("Branches.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
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