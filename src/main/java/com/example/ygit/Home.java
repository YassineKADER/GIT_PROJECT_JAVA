package com.example.ygit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Home {
    @FXML
    private ListView explorer;

    @FXML
    private void addelement(ActionEvent event){
        TreeItem<String> folder = new TreeItem<String>("something");
        TreeItem<String> Folder3 = new TreeItem<String>("test5");

        folder.getChildren().add(Folder3);

        //explorer.setRoot(folder);
    }

    public void choseFolder(ActionEvent envent){
        DirectoryChooser dct = new DirectoryChooser();
        dct.setInitialDirectory(Paths.get(System.getProperty("user.dir")).toFile());
        File file = dct.showDialog(null);
        if(file != null){
            Path directory = file.toPath();
            try{

                TreeItem tr = new TreeItem<String>("test");
                Files.walk(directory).filter(path -> Files.isDirectory(path)).forEach(dir -> explorer.getItems().add(dir.toString()));
                //explorer.setRoot(tr);
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
