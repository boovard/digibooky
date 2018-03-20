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
        this.books = new HashMap<>();
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
