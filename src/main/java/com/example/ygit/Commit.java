package com.example.ygit;

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
        return date;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }
}
