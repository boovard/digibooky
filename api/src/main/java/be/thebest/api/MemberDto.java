package be.thebest.api;

import be.thebest.domain.objects.persons.Address;

import java.util.UUID;

public class MemberDto {
    private UUID uuid;
    private String inss;
    private String lastName;
    private String firstName;
    private String email;
    private Address address;

    public static MemberDto memberDto() {
        return new MemberDto();
    }

    public MemberDto withUUID(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public MemberDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public MemberDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public MemberDto withEmail(String email) {
        this.email = email;
        return this;
    }

    public MemberDto withAddress(Address address) {
        this.address = address;
        return this;
    }

    public UUID getUuid() {
        return uuid;
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

    public Address getAddress() {
        return address;
    }

    public String getInss() {
        return inss;
    }
}
