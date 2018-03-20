package be.thebest.domain.repositories;

import be.thebest.domain.objects.Author;
import be.thebest.domain.objects.Book;
import com.sun.javafx.binding.StringFormatter;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

@Named
public class BookRepository {
    private Map<String, Book> books;

    @Inject
    public BookRepository() {
        Book book1 = new Book("ISBN1", "History for dummies",
                new Author(1,"Van Reeth", "Leander"));
        Book book2 = new Book("ISBN2", "Geography for dummies",
                new Author(2,"Bouvy", "Simon"));
        Book book3 = new Book("ISBN3", "Javascript for dummies",
                new Author(3,"Block", "Marie-Lynne"));
        Book book4 = new Book("ISBN4", "Biology for dummmies",
                new Author(4,"Hermans", "Dirk"));
        this.books = new HashMap<>();
        books.put(book1.getIsbn(), book1);
        books.put(book2.getIsbn(), book2);
        books.put(book3.getIsbn(), book3);
        books.put(book4.getIsbn(), book4);
    }

    public void registerNewBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Map<String, Book> getAllBooks() {
        return Collections.unmodifiableMap(books);
    }

    public String getBookDetails(String isbn) {
        Book book = getBookByIsbn(isbn);
        return String.format("title: %s \n Author: %s %s \n ISBN: %s",
            book.getTitle(), book.getAuthor().getLastName(), book.getAuthor().getFirstName() , isbn);
    }

    public Book getBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    public List<Book> getBookByIsbnWithWildCard(String isbnWithWildcard) {
        List<Book> booksFound = new ArrayList<>();
        return booksFound;
    }

    public Book getBookByTitle(String title) {
        return null;
    }

    public Book getBookByAuthor(String authorId) {
        return null;
    }

    public Book updateBook(String title) {
        return null;
    }

    public Book updateBook(Author author) {
        return null;
    }

    public void deleteBook(String isbn) {

    }

    public void lendBook(String isbn) {

    }

    public void returnBook(String isbn) {

    }

    public void getOverdueBooks() {

    }
}
