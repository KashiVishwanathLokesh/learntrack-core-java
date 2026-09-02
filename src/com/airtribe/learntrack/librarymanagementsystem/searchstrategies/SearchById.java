package com.airtribe.learntrack.librarymanagementsystem.searchstrategies;

import com.airtribe.learntrack.librarymanagementsystem.entities.Book;

import java.util.List;

public class SearchById implements  SearchStrategy  {
    @Override
    public List<Book> search(String query, List<Book> books) {
        System.out.println("Searching for item with ID: " + query);
        List<Book> result = books.stream()
                .filter(book -> book.getIsbn().toString().equals(query))
                .toList();
        return result;
    }
}
