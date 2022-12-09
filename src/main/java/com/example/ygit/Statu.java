package com.example.ygit;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Statu implements Initializable {
    public ListView branch;
    @FXML
    TextArea statu;
    @FXML
    TextArea message;
    @FXML
    Button commit;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        statu.setEditable(false);
        Ygit test = new Ygit(Ygit.Directory.toString());
        try {
            statu.setText(test.getstatus());
            test.getallbranches(test.getgit()).forEach(element -> {
                branch.getItems().add(element);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (GitAPIException e) {
            throw new RuntimeException(e);
        }

    }

    public void commit(ActionEvent event) throws GitAPIException {
        Ygit test = new Ygit(Ygit.Directory.toString());
        test.getgit().add().addFilepattern(".").call();
        if(message.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Enter a message");
            alert.setTitle("ERROR");
            alert.showAndWait();
        }
        else {
            test.getgit().commit().setMessage(message.getText()).call();
        }
    }
}
