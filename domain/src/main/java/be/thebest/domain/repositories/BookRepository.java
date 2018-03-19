package be.thebest.domain.repositories;

import be.thebest.domain.objects.Book;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BookRepository {
    private Map<String, Book> bookRepository;

    public BookRepository() {
        this.bookRepository = new HashMap<>();
    }

    public Map<String, Book> getBookRepository() {
        return Collections.unmodifiableMap(bookRepository);
    }

    public Map<String, Book> getAllBooks() {
        return null;
    }

    public String getBookDetails() {
        return null;
    }

    public Book searchOnIsbn() {
        return null;
    }
}
