package com.airtribe.learntrack.librarymanagementsystem;

import com.airtribe.learntrack.librarymanagementsystem.entities.Book;
import com.airtribe.learntrack.librarymanagementsystem.entities.BookBuilder;
import com.airtribe.learntrack.librarymanagementsystem.entities.Patron;
import com.airtribe.learntrack.librarymanagementsystem.searchstrategies.SearchStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManagementSystem {
    private static long bookISBNCounter = 1;
    private static long patronMemberID=1;
   private final static LibraryManagementSystem instance = new LibraryManagementSystem();
   private final Map<String , ArrayList<String>> reservedBooks = new HashMap<>();
    private LibraryManagementSystem() {
    }
    public static LibraryManagementSystem getInstance() {
        return instance;    }

    private final Map<String , Book> bookInventory= new HashMap<>();
    private final Map<String , Book> borrowedBooks= new HashMap<>();
    private final Map<String , Patron> patrons = new HashMap<>();

    public void addBook(String title, String author, String yearOfPublication){

        Book book=new BookBuilder().setTitle(title).setAuthor(author).setIsbn(String.valueOf(bookISBNCounter++)).build();
        bookInventory.put(book.getIsbn(), book);
        System.out.println("Book added: " + book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");
    }
    public void updatebook(long isbn, String title, String author, String yearOfPublication){

        Book book = bookInventory.get(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setYearOfPublication(yearOfPublication);

    }
    public void removeBook(String isbn) {
        Book book = bookInventory.get(isbn);
        if (book != null) {
            bookInventory.remove(isbn);
            System.out.println("Book removed: " + book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }

    public void registerPatron(String name, String email) {
        Patron patron = new Patron();
        patron.setMemberId(String.valueOf(patronMemberID++));
        patron.setName(name);
        patron.setEmail(email);
        patrons.put(patron.getMemberId().toString(), patron);
        System.out.println("Patron registered: " + patron.getName() + " (Member ID: " + patron.getMemberId() + ")");
    }
    public void removePatron(String memberId) {
        Patron patron = patrons.get(memberId);
        if (patron != null) {
            patrons.remove(memberId);
            System.out.println("Patron removed: " + patron.getName() + " (Member ID: " + patron.getMemberId() + ")");
        } else {
            System.out.println("Patron with Member ID " + memberId + " not found.");
        }
    }
    public void updatePatron(String memberId, String name, String email) {
        Patron patron = patrons.get(memberId);
        if (patron != null) {
            patron.setName(name);
            patron.setEmail(email);
            System.out.println("Patron updated: " + patron.getName() + " (Member ID: " + patron.getMemberId() + ")");
        } else {
            System.out.println("Patron with Member ID " + memberId + " not found.");
        }
    }

    public void borrowBook(String memberID, String isbn) {
        Patron patron = patrons.get(memberID);
        Book book = bookInventory.get(isbn);

        if (patron == null) {
            System.out.println("Patron with Member ID " + memberID + " not found.");
            return;
        }

        if (book == null) {
            System.out.println("Book with ISBN " + isbn + " not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book '" + book.getTitle() + "' is currently not available for borrowing.");
            return;
        }

        book.setAvailable(false);
        borrowedBooks.put(memberID, book);
        patron.setBorrowedBooks(String.valueOf(isbn));
        System.out.println("Book '" + book.getTitle() + "' borrowed by " + patron.getName() + " (Member ID: " + patron.getMemberId() + ")");
    }

    public void returnBook(String memberId, String isbn){
    Patron patron
            =patrons.get(memberId);
        Book book = bookInventory.get(isbn);

        if (patron == null) {
            System.out.println("Patron with Member ID " + memberId + " not found.");
            return;
        }
        if (book == null) {
            System.out.println("Book with ISBN " + isbn + " not found.");
            return;
        }
            if (reservedBooks.containsKey(isbn)) {
                List<String> reservedPatrons = reservedBooks.get(isbn);
                if (!reservedPatrons.isEmpty()) {
                    String nextPatronId = reservedPatrons.getFirst();
                    Patron nextPatron = patrons.get(nextPatronId);
                    if (nextPatron != null) {
                        System.out.println("Book '" + book.getTitle() + "' is now available for reservation by " + nextPatron.getName() + " (Member ID: " + nextPatron.getMemberId() + ")");
                        reservedPatrons.removeFirst(); // Remove the patron from the reservation list
                    }
                }
            }
            book.setAvailable(true);
            borrowedBooks.remove(memberId);
            patron.getBorrowedBooks().remove(isbn);
            System.out.println("Book '" + book.getTitle() + "' returned by " + patron.getName() + " (Member ID: " + patron.getMemberId() + ")");

    }

    public  void userBorrowedBooks(String memberId) {
        Patron patron = patrons.get(memberId);
        if (patron == null) {
            System.out.println("Patron with Member ID " + memberId + " not found.");
            return;
        }

        List<String> borrowedBookIsbns = patron.getBorrowedBooks();
        if (borrowedBookIsbns.isEmpty()) {
            System.out.println(patron.getName() + " has not borrowed any books.");
            return;
        }

        System.out.println(patron.getName() + " has borrowed the following books:");
        for (String isbn : borrowedBookIsbns) {
            Book book = bookInventory.get(isbn);
            if (book != null) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");
            }
        }

    }

    public void reserveBook(String memberId, String isbn) {
        Patron patron = patrons.get(memberId);
        Book book = bookInventory.get(isbn);

        if (patron == null) {
            System.out.println("Patron with Member ID " + memberId + " not found.");
            return;
        }

        if (book == null) {
            System.out.println("Book with ISBN " + isbn + " not found.");
            return;
        }

        if (book.isAvailable()) {
            System.out.println("Book '" + book.getTitle() + "' is currently not available for reservation.");
            return;
        }
        if (reservedBooks.containsKey(isbn)) {
            reservedBooks.get(isbn).add(memberId);
        }
        else {
            reservedBooks.computeIfAbsent(isbn,  k -> new ArrayList<>()).add(memberId);
        }
    }
    public List<Book> search(String query, SearchStrategy strategy){
        return strategy.search(query, List.copyOf(bookInventory.values()));
    }


}
