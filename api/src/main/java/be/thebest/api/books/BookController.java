package be.thebest.api.books;

import be.thebest.domain.objects.Book;
import be.thebest.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


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

    // ISBN
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

    // Title
    @GetMapping(path = "/{title}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBooksByTitle(@PathVariable("title") String title) {
        List<BookDto> booksFound = new ArrayList<>();
        if (title.contains(".")) {
            for (Book book : bookService.getBookByTitleWithWildCard(title)) {
                booksFound.add(bookMapper.toDto(book));
            }
            return booksFound;
        }
        booksFound.add(bookMapper.toDto(bookService.getBookByTitle(title)));
        return booksFound;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDto registerNewBook(@RequestBody BookDto bookDto){
        return bookMapper.toDto(bookService.registerNewBook(bookMapper.toDomain(bookDto)));
    }

    @PutMapping(path = "/{isbn}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDto updateBook(@RequestBody BookDto bookDto){
        return bookMapper.toDto(bookService.updateBook(bookMapper.toDomain(bookDto)));
    }

    @DeleteMapping(path = "/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable("isbn") String isbn) {
        bookService.deleteBook(isbn);
    }

    @PutMapping(path = "/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto restoreBook(@RequestBody String isbn){
        return bookMapper.toDto(bookService.restoreBook(isbn));
    }
}
