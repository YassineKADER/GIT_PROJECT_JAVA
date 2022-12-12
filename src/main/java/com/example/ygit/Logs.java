package com.example.ygit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Logs implements Initializable {
    @FXML
    private TableColumn<Commit, String> author;

    @FXML
    private TableColumn<Commit, String> date;

    @FXML
    private TableColumn<Commit, String> description;
    @FXML
    private TableView<Commit> loglist;
    @FXML
    private TextArea infos;
    ArrayList<HashMap<String, String>> log = null;

    //controler for the logs section
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            infos.setEditable(false);
            author.setCellValueFactory(new PropertyValueFactory<Commit, String>("author"));
            date.setCellValueFactory(new PropertyValueFactory<Commit, String>("date"));
            description.setCellValueFactory(new PropertyValueFactory<Commit, String>("description"));
            ArrayList<Commit> items = new ArrayList<Commit>();
            Ygit logs = new Ygit(Ygit.Directory.toString());

        try {
                log= logs.getLogs();
                log.forEach(obj -> {
                items.add(new Commit(obj.get("Date"),obj.get("Author"),obj.get("Message")));
            });
        } catch (GitAPIException e) {

        }

        ObservableList<Commit> list = FXCollections.observableArrayList(items);

            loglist.setItems(list);}
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please select a directory first (git project)");
            alert.setTitle("Load Problem");
            alert.showAndWait();

        }

    }



    public void getItem(MouseEvent event){
        int index = loglist.getSelectionModel().getSelectedIndex();
        String text = "Author: "+log.get(index).get("Author")+"\nEmail: "+log.get(index).get("Email")+
                "\nDate: "+log.get(index).get("Date")+"\nCommit id: "+log.get(index).get("Commit_id")+
                "\nMessage: "+log.get(index).get("Message");
        infos.setText(text);
    }
}
