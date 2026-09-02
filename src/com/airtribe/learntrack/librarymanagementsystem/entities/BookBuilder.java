package com.airtribe.learntrack.librarymanagementsystem.entities;

public class BookBuilder {
    private String isbn;
    private String title;
    private String author;
    private int yearOfPublication;
    private boolean available = true; // default


    public BookBuilder setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }
    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }
    public BookBuilder setAuthor(String author) {
        if (title==null || title.isEmpty()) {
            throw new IllegalArgumentException("Title must be set before setting the author.");
        }
        this.author = author;
        return this;
    }
    public BookBuilder setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
        return this;
    }
    public BookBuilder setAvailable(boolean available) {
        this.available = available;
        return this;
    }
    public Book build() {
        return new Book(isbn, title, author, String.valueOf(yearOfPublication));
    }
}
