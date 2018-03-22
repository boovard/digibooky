package be.thebest.domain.objects;

import java.util.Objects;

public class Book {
    private String isbn;
    private String title;
    private Author author;

    public Book(String isbn, String title, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

}
