package com.airtribe.learntrack.librarymanagementsystem.searchstrategies;

import com.airtribe.learntrack.librarymanagementsystem.entities.Book;

import java.util.List;

public class SearchbyTitle implements SearchStrategy {

    @Override
    public List<Book> search(String query, List<Book> books) {
        System.out.println("Searching for items based on title : " + query);
      return books.stream().filter(book -> book.getTitle().toLowerCase().contains(query)).toList();
    }
}
