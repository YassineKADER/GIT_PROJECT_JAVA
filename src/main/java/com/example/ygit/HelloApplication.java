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
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws GitAPIException {
        launch();
        Ygit test = new Ygit("/home/mpower/IdeaProjects/YGIT");
        //test.cloneRepoAllBranche("https://github.com/iamshaunjp/Getting-Started-with-Firebase-9.git");

        //System.out.println(Ygit.getOrigineURLRepo(test.getgit()));
        test.getLogs();

        //Ygit.getallbranches(test.getgit()).forEach(o -> System.out.println(o));
    }
}