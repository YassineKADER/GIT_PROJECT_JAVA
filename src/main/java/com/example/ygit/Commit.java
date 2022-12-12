package com.example.ygit;

import java.text.SimpleDateFormat;

//this class used to show the data on the table view in logs section
public class Commit {
    private String date;
    private String author;
    private String description;

    public Commit(String date, String author, String description) {
        this.date = date;
        this.author = author;
        this.description = description;
    }

    public String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return date;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }
}
