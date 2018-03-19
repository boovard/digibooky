package be.thebest.domain.Persons;

import java.util.UUID;

public class Member extends Person {

    private String inss;
    private Address address;

    public Member(UUID uniqueID, String inss, String lastName, String firstName, String email, Address address) {
        super(uniqueID, lastName, firstName, email);
        this.inss = inss;
        this.address = address;
    }

    public String getInss() {
        return inss;
    }

    public Address getAddress() {
        return address;
    }
}
