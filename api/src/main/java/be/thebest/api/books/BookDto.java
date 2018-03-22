package be.thebest.api.books;

import be.thebest.api.authors.AuthorDto;
import be.thebest.domain.objects.Author;

public class BookDto {
    private String isbn;
    private String title;
    private AuthorDto authorDto;

    public static BookDto bookDto(){
        return new BookDto();
    }

    public BookDto withIsbn(String isbn){
        this.isbn = isbn;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public BookDto withTitle(String title){
        this.title = title;
        return this;
    }

    public AuthorDto getAuthorDto() {
        return authorDto;
    }

    public BookDto withAuthorDto(AuthorDto authorDto) {
        this.authorDto = authorDto;
        return this;
    }

}

