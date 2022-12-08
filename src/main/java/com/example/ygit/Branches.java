package com.example.ygit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.File;

public class Branches {
    @FXML
    TextField repourl;
    @FXML
    Button clone;
    @FXML
    CheckBox allBracnhes;
    @FXML
    Text status;
    public void clone(ActionEvent event){
        Ygit git = new Ygit(Ygit.Directory.toString());
        try {


            if (repourl.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Enter a valid git link");
                alert.setTitle("No link ditected");
                alert.showAndWait();
            } else if (allBracnhes.isSelected()) {
                //System.out.println(repourl.getText() + Ygit.Directory.toString()+"1");
                git.cloneRepoAllBranche(repourl.getText(), new File(Ygit.Directory.toString()+"/cloned-repo/"));
                Ygit.Directory = new File(Ygit.Directory.toString()+"/cloned-repo/").toPath();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("The repo is cloned: "+Ygit.Directory.toString());
                alert.setTitle("Seccesful");
                alert.showAndWait();
            } else {
                //System.out.println(repourl.getText() + Ygit.Directory.toString());
                git.clonerepository(repourl.getText(), new File(Ygit.Directory.toString()+"/cloned-repo/"));
                Ygit.Directory = new File(Ygit.Directory.toString()+"/cloned-repo/").toPath();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("The repo is cloned: "+Ygit.Directory.toString());
                alert.setTitle("Seccesful");
                alert.showAndWait();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getClass());
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Enter a valid git link or chose another folder");
            alert.setTitle("ERROR");
            alert.showAndWait();
        }

    }
}
