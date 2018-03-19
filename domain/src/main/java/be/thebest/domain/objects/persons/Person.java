package be.thebest.domain.objects.persons;

import java.util.UUID;

public abstract class Person {

    private String lastName;
    private String firstName;
    private String email;
    private UUID uniqueID;

    public Person(UUID uniqueID, String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.uniqueID = uniqueID;
    }

    public Person(String lastName, String email, UUID uniqueID) {
        this.lastName = lastName;
        this.email = email;
        this.uniqueID = uniqueID;
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

    public UUID getUniqueID() {
        return uniqueID;
    }
}
