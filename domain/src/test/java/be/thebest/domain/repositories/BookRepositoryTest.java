package be.thebest.domain.repositories;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookRepositoryTest {

    @Test
    public void getBookRepository_when5BooksAreInTheRepository_then5BooksShouldBeReturned() {
        BookRepository bookRepository = new BookRepository();
    }

    @Test
    public void getBookRepository_whenThereAreNoBooksInTheRepository_thenAnEmptyListShouldBeReturned() {
    }

    @Test
    public void getAllBooks() {
    }

    @Test
    public void getBookDetails() {
    }

    @Test
    public void searchOnIsbn() {
    }
}