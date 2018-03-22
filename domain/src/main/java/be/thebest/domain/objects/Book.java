package be.thebest.domain.objects;

import java.util.Objects;

public class Book {
    private String isbn;
    private String title;
    private Author author;
    private Boolean availability;

    public Book() {
    }

    public Book(String isbn, String title, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        availability = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }


    public void setAuthor(Author author) {
        this.author = author;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(isbn, title, author);
    }

    public static class BookBuilder{
        private String isbn;
        private String title;
        private Author author;
        private Boolean availability;

        private BookBuilder(){}

        public static BookBuilder bookBuilder(){
            return new BookBuilder();
        }

        public Book build(){
            Book book = new Book();
            book.setIsbn(isbn);
            book.setTitle(title);
            book.setAuthor(author);
            book.setAvailability(availability);
            return book;
        }

        public BookBuilder withIsbn(String isbn){
            this.isbn = isbn;
            return this;
        }

        public BookBuilder withTitle(String title){
            this.title = title;
            return this;
        }

        public BookBuilder withAuthor(Author author){
            this.author = author;
            return this;
        }

        public BookBuilder withAvailability(Boolean availability){
            this.availability = availability;
            return this;
        }
    }

}
