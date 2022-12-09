package com.example.ygit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("YGIT");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws GitAPIException, IOException {
        launch();
        Ygit test = new Ygit("/home/mpower/Documents/test-ygit/cloned-repo");
        //test.cloneRepoAllBranche("https://github.com/iamshaunjp/Getting-Started-with-Firebase-9.git");

        //System.out.println(Ygit.getOrigineURLRepo(test.getgit()));
        System.out.println(test.getLogs().size());;
        test.getstatus();

        //Ygit.getallbranches(test.getgit()).forEach(o -> System.out.println(o));
    }
}