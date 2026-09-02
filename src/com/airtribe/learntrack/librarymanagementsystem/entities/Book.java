package com.airtribe.learntrack.librarymanagementsystem.entities;

public class Book {
    public String getIsbn() {
        return isbn;
    }

    public Book(String isbn, String title, String author, String yearOfPublication) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.isAvailable = true;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public void setAvailable(boolean available) {

        isAvailable = available;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


    public boolean isAvailable() {
        return isAvailable;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    private String isbn;
    private String title;
    private String author;
    private String yearOfPublication;
    private boolean isAvailable;

}
