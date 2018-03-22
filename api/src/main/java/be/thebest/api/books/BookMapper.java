package be.thebest.api.books;

import be.thebest.api.authors.AuthorMapper;
import be.thebest.domain.objects.Book;

public class BookMapper {

    static public BookDto bookMapper(Book book) {
        return new BookDto(book.getIsbn(), book.getTitle(), AuthorMapper.toDto(book.getAuthor()));
    }
}
