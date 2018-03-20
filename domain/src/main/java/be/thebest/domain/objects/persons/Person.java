package be.thebest.domain.objects.persons;

import java.util.UUID;

public abstract class Person {

    private String lastName;
    private String firstName;
    private String email;
    private UUID uniqueID;

    public Person(){
    }

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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUniqueID(UUID uniqueID) {
        this.uniqueID = uniqueID;
    }

    public static abstract class PersonBuilder {
        private String lastName;
        private String firstName;
        private String email;
        private UUID uniqueID;

        public abstract Person build();

        public PersonBuilder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder withEmail(String email){
            this.email = email;
            return this;
        }

        public PersonBuilder withUniqueID(UUID uniqueID){
            this.uniqueID = uniqueID;
            return this;
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
}
