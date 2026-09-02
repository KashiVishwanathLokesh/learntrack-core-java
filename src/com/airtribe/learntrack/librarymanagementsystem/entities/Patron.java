package com.airtribe.learntrack.librarymanagementsystem.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Patron {

    private String memberId;
    private String name;
    private String email;
    private List< String> borrowedBooks= new ArrayList<>();

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(String borrowedBook) {
        borrowedBooks.add(borrowedBook);
    }
}
