package be.thebest.api;

import be.thebest.domain.objects.persons.Address;

import java.util.UUID;

public class MemberDto {
    private UUID uuid;
    private String inss;
    private String lastName;
    private String firstName;
    private String email;
    private AddressDto addressDto;

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

    public MemberDto withAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
        return this;
    }

    public MemberDto withInss(String inss) {
        this.inss = inss;
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

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public String getInss() {
        return inss;
    }
}
