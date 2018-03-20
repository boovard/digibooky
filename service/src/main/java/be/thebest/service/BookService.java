package be.thebest.service;

import be.thebest.domain.objects.Book;
import be.thebest.domain.repositories.BookRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;


@Named
public class BookService {
    BookRepository bookRepository;

    @Inject
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        List<Book> booksToReturn = new ArrayList<>();

        for (Book book: bookRepository.getAllBooks().values()) {
            booksToReturn.add(book);
        }
        return booksToReturn;
    }
}
