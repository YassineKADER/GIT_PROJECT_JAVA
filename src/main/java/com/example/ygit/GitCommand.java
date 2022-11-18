package com.example.ygit;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GitCommand {
    private String repository;
    private Path clonedirectory;
    private Git git;

    public GitCommand(String repository, String clonedirectory){
        this.repository = repository;
        this.clonedirectory = Paths.get(clonedirectory).toAbsolutePath().normalize();
        try{
            this.git = Git.init().call();
        }
        catch (GitAPIException e){
            System.out.println("git hub exception");
        }
    }
    @SuppressWarnings("static-access")
    public void clonerepository(){
        try {
            File file = this.clonedirectory.toFile();
            this.git = Git.cloneRepository().setURI(this.repository).setDirectory(this.clonedirectory.toFile()).call();
        } catch (InvalidRemoteException e) {
            throw new RuntimeException(e);
        } catch (TransportException e) {
            throw new RuntimeException(e);
        } catch (GitAPIException e) {
            throw new RuntimeException(e);
        }
    }
}


