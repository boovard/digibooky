package be.thebest.api.librarians;

import be.thebest.domain.objects.persons.Librarian;

import javax.inject.Named;

@Named
public class LibrarianMapper {

    public LibrarianDto toDto(Librarian librarian) {
        return LibrarianDto.librarianDto()
                .withUniqueID(librarian.getUniqueID())
                .withLastName(librarian.getLastName())
                .withFirstName(librarian.getFirstName())
                .withEmail(librarian.getEmail());
    }

    public Librarian toDomain(LibrarianDto librarianDto){
        return (Librarian)Librarian.LibrarianBuilder.librarian()
                .withUniqueID(librarianDto.getUniqueID())
                .withLastName(librarianDto.getLastName())
                .withFirstName(librarianDto.getFirstName())
                .withEmail(librarianDto.getEmail())
                .build();
    }
}
