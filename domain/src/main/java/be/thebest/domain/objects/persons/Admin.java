package be.thebest.domain.objects.persons;


import java.util.UUID;

public class Admin extends Person {


    public Admin(UUID uniqueID, String lastName, String firstName, String email) {
        super(uniqueID, lastName, firstName, email);
    }

}
