package be.thebest.domain.repositories;

import be.thebest.domain.objects.Author;
import be.thebest.domain.objects.Book;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BookRepository {
    private Map<String, Book> bookRepository;

    public BookRepository() {
        this.bookRepository = new HashMap<>();
    }

    public void registerNewBook(Book book) {
        bookRepository.put(book.getIsbn(), book);
    }

    public Map<String, Book> getBookRepository() {
        return Collections.unmodifiableMap(bookRepository);
    }

    public Map<String, Book> getAllBooks() {
        return null;
    }

    public String getBookDetails(String isbn) {
        return null;
    }

    public Book getBookByIsbn(String isbn) {
        return null;
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
