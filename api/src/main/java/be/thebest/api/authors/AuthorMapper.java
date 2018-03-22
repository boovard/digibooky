package be.thebest.api.authors;

import be.thebest.domain.objects.Author;

import javax.inject.Named;

@Named
public class AuthorMapper {

    public AuthorDto toDto(Author author) {
        return AuthorDto.authorDto()
                .withAuthorId(author.getAuthorId())
                .withLastName(author.getLastName())
                .withFirstName(author.getFirstName());
    }

    public Author toDomain(AuthorDto authorDto){
        return new Author(authorDto.getAuthorId(), authorDto.getLastName(), authorDto.getFirstName());
    }
}
