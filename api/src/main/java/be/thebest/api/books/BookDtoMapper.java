package be.thebest.api.books;

import be.thebest.api.authors.AuthorDtoMapper;
import be.thebest.domain.objects.Author;
import be.thebest.domain.objects.Book;

public class BookDtoMapper {

    static public BookDto bookMapper(Book book) {
        return new BookDto(book.getIsbn(), book.getTitle(), AuthorDtoMapper.authorMapper(book.getAuthor()));
    }
}
