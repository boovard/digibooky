package be.thebest.domain.objects.persons;

import java.util.UUID;

public abstract class Person {

    private String lastName;
    private String firstName;
    private String email;
    private UUID uniqueID;

    public Person(){
    }

    public Person(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public Person(String lastName, String email) {
        this.lastName = lastName;
        this.email = email;
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

    public static abstract class PersonBuilder<T extends PersonBuilder> {
        private String lastName;
        private String firstName;
        private String email;
        private UUID uniqueID;

        public abstract Person build();

        public T withLastName(String lastName){
            this.lastName = lastName;
            return (T) this;
        }

        public T withFirstName(String firstName){
            this.firstName = firstName;
            return (T) this;
        }

        public T withEmail(String email){
            this.email = email;
            return (T) this;
        }

        public T withUniqueID(UUID uniqueID){
            this.uniqueID = uniqueID;
            return (T) this;
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
