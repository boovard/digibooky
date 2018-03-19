package be.thebest.domain.objects.Persons;


import java.util.UUID;

public class Librarian extends Person {

    public Librarian(UUID uniqueID, String lastName, String firstName, String email) {
        super(uniqueID, lastName, firstName, email);
    }
}
