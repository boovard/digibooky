package be.thebest.api.books;

import be.thebest.domain.objects.Book;
import be.thebest.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(path = "/books")
@RestController
public class BookController {
    private BookService bookService;
    private BookMapper bookMapper;

    @Inject
    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }


    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getAllBooks() {
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : bookService.getAllBooks()) {
            bookDtos.add(bookMapper.toDto(book));
        }
        return bookDtos;
    }

    @GetMapping(path = "/{isbn}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBooksByIsbn(@PathVariable("isbn") String isbn) {
        List<BookDto> booksFound = new ArrayList<>();
        if (isbn.contains(".")) {
            for (Book book : bookService.getBookByIsbnWithWildCard(isbn)) {
                booksFound.add(bookMapper.toDto(book));
            }
            return booksFound;
        }
        booksFound.add(bookMapper.toDto(bookService.getBookByIsbn(isbn)));
        return booksFound;
    }
}
