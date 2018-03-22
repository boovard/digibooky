package be.thebest.domain.repositories;

import be.thebest.domain.exception.NotFoundException;
import be.thebest.domain.objects.Author;
import be.thebest.domain.objects.Book;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Named
public class BookRepository {
    private Map<String, Book> books;

    @Inject
    public BookRepository() {
        Book book1 = new Book("ISBN1", "History for dummies",
                new Author(1, "Van Reeth", "Leander"));
        Book book2 = new Book("ISBN2", "Geography for dummies",
                new Author(2, "Bouvy", "Simon"));
        Book book3 = new Book("ISBN3", "Javascript for dummies",
                new Author(3, "Block", "Marie-Lynne"));
        Book book4 = new Book("ISBN4", "Biology for dummmies",
                new Author(4, "Hermans", "Dirk"));
        this.books = new HashMap<>();
        books.put(book1.getIsbn(), book1);
        books.put(book2.getIsbn(), book2);
        books.put(book3.getIsbn(), book3);
        books.put(book4.getIsbn(), book4);
    }

    public void registerNewBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book updateBook(String isbn, Book updatedBook){
        books.put(isbn, updatedBook);
        return updatedBook;
    }

    public Map<String, Book> getAllBooks() {
        return Collections.unmodifiableMap(books);
    }

    public Book getBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    public List<Book> getBookByIsbnWithWildCard(String isbnWithWildcard) {
        String isbnRegex = createRegexExpressionForWildcardIsbn(isbnWithWildcard);
        List<Book> booksFound = new ArrayList<>();

        Pattern p = Pattern.compile(isbnRegex);

        for (String isbn : books.keySet()) {
            Matcher m = p.matcher(isbn);
            if (m.matches()) {
                booksFound.add(books.get(isbn));
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
    /*

    // Title
    public Book getBookByTitle(String title) {
        if (books.get(title) != null) {
            return books.get(title);
        }
        throw new NotFoundException("Book not found. Check Title again.");
    }

    public List<Book> getBookByTitleWithWildCard(String titleWithWildcard) {
        String isbnRegex = createRegexExpressionForWildcardIsbn(titleWithWildcard);
        List<Book> booksFound = new ArrayList<>();

        Pattern p = Pattern.compile(isbnRegex);

        for (String title : books.keySet()) {
            Matcher m = p.matcher(title);
            if (m.matches()) {
                booksFound.add(books.get(title));
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
    */
}

