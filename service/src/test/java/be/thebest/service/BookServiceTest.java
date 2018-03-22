package be.thebest.service;

import be.thebest.domain.objects.Book;
import be.thebest.domain.repositories.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;


public class BookServiceTest {

    BookRepository mockBookRepository;
    BookService testBookService;

    @Before
    public void setUp(){
        mockBookRepository = mock(BookRepository.class);
        testBookService = new BookService(mockBookRepository);
    }

    @Test
    public void registerNewBook_shouldCallTheDomainRegisterNewBookMethod(){
        Book mockBook = mock(Book.class);
        testBookService.registerNewBook(mockBook);
        Mockito.verify(mockBookRepository, times(1)).registerNewBook(mockBook);
    }

    @Test
    public void updateBook_shouldCallTheDomainUpdateBookMethod(){
        Book mockBook = mock(Book.class);
        testBookService.updateBook(mockBook);
        Mockito.verify(mockBookRepository, times(1)).updateBook(mockBook);
    }

}