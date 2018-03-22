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

    @Inject
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getAllBooks() {
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : bookService.getAllBooks()) {
            bookDtos.add(BookMapper.bookMapper(book));
        }
        return bookDtos;
    }

    @GetMapping(path = "/{isbn}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBook(@PathVariable("isbn") String isbn) {
        return BookMapper.bookMapper(bookService.getBookByIsbn(isbn));
    }

}
