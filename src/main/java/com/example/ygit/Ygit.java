package com.example.ygit;

import javafx.scene.control.skin.SliderSkin;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevCommit;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Ygit {
    static public Path Directory;
    private Git git;

    public Ygit(String Directory) {
        this.Directory = Paths.get(Directory).toAbsolutePath().normalize();
        try {
            this.git = Git.init().setDirectory(this.Directory.toFile()).call();
        } catch (GitAPIException e) {
            System.out.println("git hub exception");
        }
    }

    public Git getgit() {
        return this.git;
    }

    @SuppressWarnings("static-access")
    public void clonerepository(String repository) {
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

    public void cloneRepoAllBranche(String reposotirylink) {
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
        ArrayList<String> returndeList = new ArrayList<String>();
        try {
            List<Ref> branches = git.branchList().setListMode(ListBranchCommand.ListMode.ALL).call();
            branches.forEach(ref -> returndeList.add(ref.getName().toString()));
        } catch (Exception e) {
            System.out.println("no branch");
        }
        return returndeList;
    }

    public  ArrayList<HashMap<String,String>> getLogs() throws GitAPIException {
        Iterable<RevCommit> log = this.git.log().call();
        ArrayList<HashMap<String,String>> returnedList = new ArrayList<HashMap<String,String>>();
        for (Iterator<RevCommit> iterator = log.iterator(); iterator.hasNext(); ) {
            HashMap<String, String> item = new HashMap<String, String>();
            RevCommit rev = iterator.next();
            item.put("Author", rev.getAuthorIdent().getName());
            item.put("Email", rev.getAuthorIdent().getEmailAddress());
            item.put("Date", rev.getAuthorIdent().getWhen().toString());
            item.put("Commit_id", rev.getId().getName());
            item.put("Message",rev.getFullMessage());
            returnedList.add(item);
        }
        return returnedList;
    }

}


