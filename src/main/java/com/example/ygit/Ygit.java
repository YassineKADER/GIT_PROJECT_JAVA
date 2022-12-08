package com.example.ygit;

import javafx.scene.control.skin.SliderSkin;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.lib.IndexDiff;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevCommit;

import java.io.File;
import java.io.IOException;
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
    public static void clonerepository(String repository, File Directory) {
        try {
            File file = Directory;
            Git git = Git.cloneRepository().setURI(repository).setDirectory(file).call();
        } catch (InvalidRemoteException e) {
            throw new RuntimeException(e);
        } catch (TransportException e) {
            throw new RuntimeException(e);
        } catch (GitAPIException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFiles(File dirPath) {
        File filesList[] = dirPath.listFiles();
        for (File file : filesList) {
            if (file.isFile()) {
                file.delete();
                System.out.println("files deleted");
            } else {

                deleteFiles(file);
            }
        }
    }

    public static void cloneRepoAllBranche(String reposotirylink,File Directory) {
        try {
            File file = Directory;
            Git git = Git.cloneRepository().setURI(reposotirylink).setDirectory(file).setCloneAllBranches(true).call();
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

    public String getstatus() throws IOException, GitAPIException {
        Status test = this.git.status().call();
        System.out.println(test.getModified() +" "+test.getModified());
        String text = new String();
        for(String element: test.getModified()){
            text += "Modified:"+element.toString()+"\n";
        }
        for(String element: test.getChanged()){
            text += "Changed:"+element.toString()+"\n";
        }
        for(String element: test.getRemoved()){
            text += "Removed:"+element.toString()+"\n";
        }
        for(String element: test.getUntracked()){
            text += "Untracked:"+element.toString()+"\n";
        }
        for(String element: test.getMissing()){
            text += "Missed:"+element.toString()+"\n";
        }

        return text;
    }

}


