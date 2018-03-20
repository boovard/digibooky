package be.thebest.api.books;

import be.thebest.api.authors.AuthorDto;
import be.thebest.domain.objects.Author;

public class BookDto {
    private String isbn;
    private String title;
    private AuthorDto authorDto;

    public BookDto(String isbn, String title, AuthorDto authorDto) {
        this.isbn = isbn;
        this.title = title;
        this.authorDto = authorDto;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public AuthorDto getAuthorDto() {
        return authorDto;
    }

}

