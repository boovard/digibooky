package be.thebest.domain.repositories;

import be.thebest.domain.exception.IllegalFieldException;
import be.thebest.domain.exception.NotFoundException;
import be.thebest.domain.objects.Author;
import be.thebest.domain.objects.Book;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Named
public class BookRepository {
    private Map<String, Book> books;

    @Inject
    public BookRepository() {
        Book book1 = new Book("ISBN1", "How to be The Smartest Guy in the Room?",
                new Author(1, "Delestinne", "Niels"));
        Book book2 = new Book("ISBN2", "However",
                new Author(2, "Delestinne", "Niels"));
        Book book3 = new Book("ISBN3", "Retrospective Meetings for Dummies",
                new Author(3, "Van Bets", "Reinout"));
        Book book4 = new Book("ISBN4", "Post-Its for Agile Practices",
                new Author(4, "Van Bets", "Reinout"));
        this.books = new HashMap<>();
        books.put(book1.getIsbn(), book1);
        books.put(book2.getIsbn(), book2);
        books.put(book3.getIsbn(), book3);
        books.put(book4.getIsbn(), book4);
    }

    public void registerNewBook(Book book) {
        books.put(book.getIsbn(), book);
    }


    public Book updateBook(Book updatedBook) {
        books.put(updatedBook.getIsbn(), updatedBook);
        return updatedBook;
    }

    public void deleteBook(String isbn) {
        books.get(isbn).setAvailability(false);
    }

    public Book restoreBook(String isbn) {
        books.get(isbn).setAvailability(true);
        return books.get(isbn);
    }

    public Map<String, Book> getAllBooks() {
        return Collections.unmodifiableMap(books);
    }

    public Map<String, Book> getAllAvailableBooks() {
        return books.entrySet().stream()
                .filter(entry -> entry.getValue().getAvailability())
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
    }

    public Book getBookByIsbn(String isbn) {
        return getAllAvailableBooks().get(isbn);
    }

    public List<Book> getBookByIsbnWithWildCard(String isbnWithWildcard) {
        String isbnRegex = createRegexExpressionForWildcardIsbn(isbnWithWildcard);
        List<Book> booksFound = new ArrayList<>();

        Pattern p = Pattern.compile(isbnRegex);

        for (String isbn : getAllAvailableBooks().keySet()) {
            Matcher m = p.matcher(isbn);
            if (m.matches()) {
                booksFound.add(getAllAvailableBooks().get(isbn));
            }
        }
        return booksFound;
    }

    private String createRegexExpressionForWildcardIsbn(String isbn) {
        String regexToReplaceWildcard = "[A-Za-z0-9]{1}";
        String regexExpression = "^";
        for (int i = 0; i < isbn.length(); i++) {
            if (isbn.charAt(i) == '.') {
                regexExpression = regexExpression + regexToReplaceWildcard;
            } else {
                regexExpression = regexExpression + isbn.charAt(i);
            }
        }
        return regexExpression + '$';
    }


//    DO NOT USE OUTSIDE OF TESTS
    public void clearBookRepository(){
        books.clear();
    }

    // Title
    public Book getBookByTitle(String title) {
        if (books != null) {
            for (String isbn : books.keySet()) {
                if (books.get(isbn).getTitle().equals(title)) {
                    return books.get(isbn);
                }
            }
            throw new NotFoundException("Book not found. Check Title again.");
        }
        throw new NotFoundException("No books in the library.");
    }

    public List<Book> getBookByTitleWithWildCard(String titleWithWildcard) {
        String titleRegex = createRegexExpressionForWildcardTitle(titleWithWildcard);
        List<Book> booksFound = new ArrayList<>();

        Pattern p = Pattern.compile(titleRegex);

        for (Book book : books.values()) {
            Matcher m = p.matcher(book.getTitle());
            if (m.matches()) {
                booksFound.add(book);
            }
        }
        return booksFound;
    }

    private String createRegexExpressionForWildcardTitle(String title) {
        String regexToReplaceWildcard = "[-A-Za-z0-9\\s.]{1}";
        String regexExpression = "^";
        for (int i = 0; i < title.length(); i++) {
            if (title.charAt(i) == '.') {
                regexExpression = regexExpression + regexToReplaceWildcard;
            } else {
                regexExpression = regexExpression + title.charAt(i);
            }
        }
        return regexExpression + '$';
    }
}