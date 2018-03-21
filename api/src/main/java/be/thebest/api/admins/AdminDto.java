package be.thebest.api.admins;

import java.util.UUID;

public class AdminDto {

    private UUID uniqueID;
    private String lastName;
    private String firstName;
    private String email;

    public static AdminDto adminDto(){
        return new AdminDto();
    }

    public AdminDto withUniqueID(UUID uniqueID) {
        this.uniqueID = uniqueID;
        return this;
    }

    public AdminDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AdminDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AdminDto withEmail(String email) {
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
