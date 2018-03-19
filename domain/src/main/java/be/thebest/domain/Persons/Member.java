package be.thebest.domain.Persons;

public class Member extends Person {

    private String inss;
    private Address address;

    public Member(String inss, String lastName, String firstName, String email, Address address) {
        super(lastName, firstName, email);
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
