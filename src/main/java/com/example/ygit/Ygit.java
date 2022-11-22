package com.example.ygit;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Ygit {
    private final Path Directory;
    private Git git;

    public Ygit(String Directory){
        this.Directory = Paths.get(Directory).toAbsolutePath().normalize();
        try{
            this.git = Git.init().setDirectory(this.Directory.toFile()).call();
        }
        catch (GitAPIException e){
            System.out.println("git hub exception");
        }
    }

    public Git getgit(){
        return this.git;
    }

    @SuppressWarnings("static-access")
    public void clonerepository(String repository){
        try {
            File file = this.Directory.toFile();
            this.git = Git.cloneRepository().setURI(repository).setDirectory(this.Directory.toFile()).call();
        } catch (InvalidRemoteException e) {
            throw new RuntimeException(e);
        } catch (TransportException e) {
            throw new RuntimeException(e);
        } catch (GitAPIException e) {
            throw new RuntimeException(e);
        }
    }

    public void cloneRepoAllBranche(String reposotirylink){
        try {
            File file = this.Directory.toFile();
            this.git = Git.cloneRepository().setURI(reposotirylink).setDirectory(this.Directory.toFile()).setCloneAllBranches(true).call();
        } catch (InvalidRemoteException e) {
            throw new RuntimeException(e);
        } catch (TransportException e) {
            throw new RuntimeException(e);
        } catch (GitAPIException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getOrigineURLRepo(Git git) throws GitAPIException {
        //Git git = Git.init().setDirectory(new File(path)).call();
        return (git.getRepository().getConfig().getString("remote", "origin", "url"));
    }

    public static List getallbranches(Git git) throws GitAPIException {

        //TODO complete the method
        ListBranchCommand bracnhlist= (ListBranchCommand) git.branchList().call();
        return new LinkedList();
    }

}


