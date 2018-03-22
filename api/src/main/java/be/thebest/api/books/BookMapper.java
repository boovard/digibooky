package be.thebest.api.books;

import be.thebest.api.authors.AuthorMapper;
import be.thebest.domain.objects.Book;

public class BookMapper {

    private AuthorMapper authorMapper;

    public BookMapper(AuthorMapper authorMapper){
        this.authorMapper = authorMapper;
    }

    public BookDto toDto(Book book) {
        return BookDto.bookDto()
                .withIsbn(book.getIsbn())
                .withTitle(book.getTitle())
                .withAuthorDto(authorMapper.toDto(book.getAuthor()));
    }

    public Book toDomain(BookDto bookDto) {
        return new Book(bookDto.getIsbn(), bookDto.getTitle(), authorMapper.toDomain(bookDto.getAuthorDto()));
    }


}
