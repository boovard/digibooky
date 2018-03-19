package be.thebest.domain.objects.persons;

import java.util.UUID;

public class Member extends Person {

    private String inss;
    private Address address;

    public Member(UUID uniqueID, String inss, String lastName, String firstName, String email, Address address) {
        super(uniqueID, lastName, firstName, email);
        this.inss = inss;
        this.address = address;
    }

    public Member(String lastName, String email, UUID uniqueID, String inss, Address address) {
        super(lastName, email, uniqueID);
        this.inss = inss;
        this.address = address;
    }

    public String getInss() {
        return inss;
    }

    public be.thebest.domain.objects.persons.Address getAddress() {
        return address;
    }
}
