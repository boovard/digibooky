package be.thebest.api.books;


import be.thebest.domain.objects.Book;
import be.thebest.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class BookControllerTest {
    private BookController testBookController;
    private BookMapper mockBookMapper;
    private BookService mockBookService;
    private BookDto mockBookDto;
    private Book mockBook;

    @Before
    public void setUp(){
        mockBookMapper = mock(BookMapper.class);
        mockBook = mock(Book.class);
        mockBookService = mock(BookService.class);
        mockBookDto = mock(BookDto.class);
        testBookController = new BookController(mockBookService,mockBookMapper);
    }

    @Test
    public void registerNewBook_shouldCallServiceRegisterNewBook(){
        when(mockBookMapper.toDomain(mockBookDto)).thenReturn(mockBook);
        testBookController.registerNewBook(mockBookDto);
        Mockito.verify(mockBookService, times(1)).registerNewBook(mockBookMapper.toDomain(mockBookDto));
    }
}