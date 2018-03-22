package be.thebest.domain.repositories;

import be.thebest.domain.exception.NotFoundException;
import be.thebest.domain.objects.Author;
import be.thebest.domain.objects.Book;
import org.assertj.core.api.Assertions;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.hamcrest.CoreMatchers;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookRepositoryTest {
    @Rule
    public ExpectedException expectedBookException = ExpectedException.none();
    private BookRepository testBookRepo;
    private Book book0, book1, book2, book3, book4, book5, book6, book7, book8, book9;

    @Before
    public void setUp() {
        testBookRepo = new BookRepository();
        book0 = new Book("ISBN0", "Title0",
                new Author(0, "LastName0", "FirstName0"));
        book1 = new Book("ISBN1", "Title1",
                new Author(1, "LastName1", "FirstName1"));
        book2 = new Book("ISBN2", "Title2",
                new Author(2, "LastName2", "FirstName2"));
        book3 = new Book("ISBN3", "Title3",
                new Author(3, "LastName3", "FirstName3"));
        book4 = new Book("ISBN4", "Title4",
                new Author(4, "LastName4", "FirstName4"));
        book5 = new Book("Wildcard1ISBN", "Title5",
                new Author(5, "LastName5", "FirstName5"));
        book6 = new Book("Wildcard2ISBN", "Title6",
                new Author(6, "LastName6", "FirstName6"));
        book7 = new Book("RegexISBN", "Title7",
                new Author(7, "LastName7", "FirstName7"));
        book8 =  new Book("ISBN5", "Harry Potter",
                new Author(8, "Rowling", "J.K."));

        testBookRepo.registerNewBook(book0);
        testBookRepo.registerNewBook(book1);
        testBookRepo.registerNewBook(book2);
        testBookRepo.registerNewBook(book3);
        testBookRepo.registerNewBook(book4);
        testBookRepo.registerNewBook(book5);
        testBookRepo.registerNewBook(book6);
        testBookRepo.registerNewBook(book7);
        testBookRepo.registerNewBook(book8);
    }

//    @Test
//    public void getBook_whenBookNotFound_returnStringMessage() {
//        expectedBookException.expect(NotFoundException.class);
//        expectedBookException.expectMessage("Book not found. Check ISBN again.");
//        testBookRepo.getBookByIsbn("Unknown ISBN");
//    }

    @Test
    public void getBookByIsbn_whenFullIsbnIsProvidedAndCorrect_returnTheBook() {
        assertEquals(book4, testBookRepo.getBookByIsbn("ISBN4"));
    }

//    @Test(expected = NotFoundException.class)
//    public void getBookByIsbn_whenIsbnIsNotFound_returnNotFoundException() {
//        testBookRepo.getBookByIsbn("Unknown ISBN");
//    }

    @Test
    public void getBookByIsbn_whenProvidedAWildCardForTheFirstCharacter_returnCorrespondingListOfBooks() {
        List<Book> testBooks = new ArrayList<>();
        testBooks.add(book5);
        testBooks.add(book6);
        assertEquals(testBooks, testBookRepo.getBookByIsbnWithWildCard(".ildcard.ISBN"));
    }

    @Test
    public void getBookByIsbn_whenProvidedAWildCardForTheLastCharacter_returnCorrespondingListOfBooks() {
        List<Book> testBooks = new ArrayList<>();
        testBooks.add(book7);
        assertEquals(testBooks, testBookRepo.getBookByIsbnWithWildCard("RegexISB."));
    }

    @Test
    public void getBookByIsbn_whenProvidedTwoWildCardsForCharacterInTheMiddle_returnCorrespondingListOfBooks() {
        List<Book> testBooks = new ArrayList<>();
        testBooks.add(book5);
        testBooks.add(book6);
        assertEquals(testBooks, testBookRepo.getBookByIsbnWithWildCard("Wildca...ISBN"));
    }

    @Test
    public void getBookByIsbn_whenProvidedOnlyWildCards_returnAllBooks() {
        List<Book> testBooks = new ArrayList<>();
        testBooks.add(book8);
        assertEquals(testBooks, testBookRepo.getBookByTitleWithWildCard("............"));
    }

    // Title
    @Test
    public void getBookByTitle_whenFullTitleIsProvidedAndCorrect_returnTheBook() {
        assertEquals(book8, testBookRepo.getBookByTitle("Harry Potter"));
    }

    @Test(expected = NotFoundException.class)
    public void getBookByTitle_whenTitleIsNotFound_returnNotFoundException() {
        testBookRepo.getBookByTitle("Unknown Title");
    }

    @Test
    public void getBookByTitle_whenProvidedAWildCardForTheFirstCharacter_returnCorrespondingListOfBooks() {
        List<Book> testBooks = new ArrayList<>();
        testBooks.add(book8);
        assertEquals(testBooks, testBookRepo.getBookByTitleWithWildCard(".arry Potter"));
    }

    @Test
    public void getBookByTitle_whenProvidedAWildCardForTheLastCharacter_returnCorrespondingListOfBooks() {
        List<Book> testBooks = new ArrayList<>();
        testBooks.add(book8);
        assertEquals(testBooks, testBookRepo.getBookByTitleWithWildCard("Harry Potte."));
    }

    @Test
    public void getBookByTitle_whenProvidedTwoWildCardsForCharacterInTheMiddle_returnCorrespondingListOfBooks() {
        List<Book> testBooks = new ArrayList<>();
        testBooks.add(book8);
        assertEquals(testBooks, testBookRepo.getBookByTitleWithWildCard("Har.y..otter"));
    }

    @Test
    public void getBookByTitle_whenProvidedOnlyWildCards_returnAllBooks() {
        List<Book> testBooks = new ArrayList<>();
        testBooks.add(book8);
        assertEquals(testBooks, testBookRepo.getBookByTitleWithWildCard("............"));
    }
}