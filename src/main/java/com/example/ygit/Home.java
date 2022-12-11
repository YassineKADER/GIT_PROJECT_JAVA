package com.example.ygit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    private ListView explorer;

    public void choseFolder(ActionEvent envent){
        DirectoryChooser dct = new DirectoryChooser();
        dct.setInitialDirectory(Paths.get(System.getProperty("user.dir")).toFile());
        File file = dct.showDialog(null);
        if(file != null){
            Path directory = file.toPath();
            Ygit.Directory = directory;

            try{
                explorer.getItems().clear();
                TreeItem tr = new TreeItem<String>("test");
                Files.walk(directory).forEach(dir -> explorer.getItems().add(dir.toString()));
                //explorer.setRoot(tr);
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(Ygit.Directory != null){
            try{

                TreeItem tr = new TreeItem<String>("test");
                Files.walk(Ygit.Directory).forEach(dir -> explorer.getItems().add(dir.toString()));
                //explorer.setRoot(tr);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
