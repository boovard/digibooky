package be.thebest.api.books;

import be.thebest.api.TestApplication;
import be.thebest.api.authors.AuthorDto;
import be.thebest.domain.repositories.BookRepository;
import be.thebest.service.BookService;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class BookControllerIntegrationTest {
    private BookDto bookDto;
    @Inject
    private BookController bookController;
    @Inject
    private BookService bookService;
    @Inject
    private BookRepository bookRepository;
    @Inject
    private BookMapper bookMapper;

    @Before
    public void setUp() {
        bookDto = new BookDto()
                .withIsbn("123456789")
                .withTitle("How to fail tests")
                .withAuthorDto(AuthorDto.authorDto().withAuthorId(9).withLastName("Bouvy").withFirstName("Simon"));
    }

    @After
    public void breakDown(){
        bookRepository.clearBookRepository();
    }


    @Test
    public void deleteBook_givenAnAvailableBook_shouldDeleteIt() {
        bookController.registerNewBook(bookDto);
        bookController.deleteBook(bookDto.getIsbn());
        Assertions.assertThat(bookRepository.getAllAvailableBooks().keySet()).doesNotContain(bookDto.getIsbn());
    }

    @Test
    public void restoreBook_givenADeletedBook_shouldRestoreIt() {
        bookController.registerNewBook(bookDto);
        bookController.deleteBook(bookDto.getIsbn());
        bookController.restoreBook(bookDto.getIsbn());
        Assertions.assertThat(bookRepository.getAllAvailableBooks().keySet()).contains(bookDto.getIsbn());
    }
}
