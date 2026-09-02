package com.airtribe.learntrack.librarymanagementsystem.searchstrategies;

import com.airtribe.learntrack.librarymanagementsystem.entities.Book;

import java.util.List;

public interface SearchStrategy {

   public List<Book> search(String query, List<Book> books);
}
