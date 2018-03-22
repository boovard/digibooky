package be.thebest.service;

import be.thebest.domain.objects.Book;
import be.thebest.domain.repositories.BookRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;


@Named
public class BookService {
    private BookRepository bookRepository;

    @Inject
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookRepository.getAllBooks().values());
    }

    public List<Book> getBook(String isbn) {
        if (isbn.contains(".")) {
            return bookRepository.getBookByIsbnWithWildCard(isbn);
        }
        return bookRepository.getBookByIsbn(isbn);
    }
}
