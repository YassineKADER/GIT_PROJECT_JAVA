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
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws GitAPIException {
       //launch();
        try {
            System.out.println("test");
            Git git = Git.cloneRepository().setURI("https://github.com/YassineKADER/HANDEL_GIT_JAVA-PROJECT.git").setDirectory(new File("/home/mpower/Documents/folder/folder90")).call();
        }
        catch(Exception e){
            System.out.println();
        };
        System.out.println("hello");

    }
}