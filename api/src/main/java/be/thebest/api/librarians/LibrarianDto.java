package be.thebest.api.librarians;

import be.thebest.domain.objects.persons.Librarian;

import java.util.UUID;

public class LibrarianDto {

    private UUID uniqueID;
    private String lastName;
    private String firstName;
    private String email;

    public static LibrarianDto librarianDto(){
        return new LibrarianDto();
    }

    public LibrarianDto withUniqueID(UUID uniqueID) {
        this.uniqueID = uniqueID;
        return this;
    }

    public LibrarianDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LibrarianDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public LibrarianDto withEmail(String email) {
        this.email = email;
        return this;
    }

    public UUID getUniqueID() {
        return uniqueID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

}
