package be.thebest.api.books;

import be.thebest.api.authors.AuthorMapper;
import be.thebest.domain.objects.Book;

import javax.inject.Named;

@Named
public class BookMapper {

    private AuthorMapper authorMapper;

    public BookMapper(AuthorMapper authorMapper){
        this.authorMapper = authorMapper;
    }

    public BookDto toDto(Book book) {
        return BookDto.bookDto()
                .withIsbn(book.getIsbn())
                .withTitle(book.getTitle())
                .withAuthorDto(authorMapper.toDto(book.getAuthor()))
                .withAvailability(book.getAvailability());
    }

    public Book toDomain(BookDto bookDto) {
        return Book.BookBuilder.bookBuilder()
                .withIsbn(bookDto.getIsbn())
                .withTitle(bookDto.getTitle())
                .withAuthor(authorMapper.toDomain(bookDto.getAuthorDto()))
                .withAvailability(bookDto.getAvailability())
                .build();
    }


}
