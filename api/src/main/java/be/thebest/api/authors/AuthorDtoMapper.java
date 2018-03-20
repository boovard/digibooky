package be.thebest.api.authors;

import be.thebest.domain.objects.Author;

public class AuthorDtoMapper {

    static public AuthorDto authorMapper(Author author) {
        return new AuthorDto(author.getAuthorId(), author.getLastName(), author.getFirstName());
    }
}
