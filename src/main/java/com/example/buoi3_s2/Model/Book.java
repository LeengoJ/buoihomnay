package com.example.buoi3_s2.Model;

public class Book {
    private int id;
    private String title;
    private String author;
    private long price;

    public Book(int id, String title, String author, long price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
