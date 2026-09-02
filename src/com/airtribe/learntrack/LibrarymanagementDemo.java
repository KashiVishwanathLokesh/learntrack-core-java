package com.airtribe.learntrack;

import com.airtribe.learntrack.librarymanagementsystem.LibraryManagementSystem;
import com.airtribe.learntrack.librarymanagementsystem.searchstrategies.SearchByAuthor;
import com.airtribe.learntrack.librarymanagementsystem.searchstrategies.SearchbyTitle;

public class LibrarymanagementDemo {
    public static void main(String[] args) {
        // Create an instance of the LibraryManagementSystem
        LibraryManagementSystem libraryManagementSystem =LibraryManagementSystem.getInstance() ;

        // Add some books to the library
        libraryManagementSystem.addBook("The Great Gatsby", "F. Scott Fitzgerald", "1999");
        libraryManagementSystem.addBook("To Kill a Mockingbird", "Harper Lee", "1899");
        libraryManagementSystem.addBook("1984", "George Orwell", "1902");
        libraryManagementSystem.addBook("Pride and Prejudice", "Jane Austen", "1915");
        // Search for books by title
        System.out.println("Searching for books by author 'Harper Lee':");
        libraryManagementSystem.search("1984", new SearchbyTitle());
        libraryManagementSystem.registerPatron("Damini","damini@gmail.com");
        libraryManagementSystem.registerPatron("anuj", "anuj@gmail.com");
        libraryManagementSystem.registerPatron("Rahul", "rahulsam@gmail.com");
        // Search for books by author
        System.out.println("\nSearching for books by author 'Harper Lee':");
        libraryManagementSystem.search("Harper Lee", new SearchByAuthor());
        System.out.println("damini borrowed books");
        libraryManagementSystem.borrowBook("1", "1");
        System.out.println("anuj reserved books");
        libraryManagementSystem.reserveBook("2", "1");
        System.out.println("damini returned books");
        libraryManagementSystem.returnBook("1","1");


        libraryManagementSystem.userBorrowedBooks("1");

    }
}
