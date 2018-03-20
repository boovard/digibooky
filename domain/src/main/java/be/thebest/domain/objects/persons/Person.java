package be.thebest.domain.objects.persons;

import java.util.UUID;

public abstract class Person {

    private String lastName;
    private String firstName;
    private String email;
    private UUID uniqueID;
    private Addressable addressable;
    private INSSable inssable;

    public Person(){
    }

    public Person(UUID uniqueID, String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.uniqueID = uniqueID;
    }

    public Person(UUID uniqueID, String lastName, String email) {
        this.lastName = lastName;
        this.email = email;
        this.uniqueID = uniqueID;
    }

    public Address getAddress(){
        return addressable.getAddress();
    }

    public void setAddressable(Addressable addressable) {
        this.addressable = addressable;
    }

    public void setAddress(Address address){
        addressable.setAddress(address);
    }

    public void setInssable(INSSable inssable) {
        this.inssable = inssable;
    }

    public void setInss(String inss){
        inssable.setInns(inss);
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
        private Addressable addressable;
        private INSSable inssable;

        public abstract Person build();

        public T withInss(INSSable inssable, String inss){
            this.inssable = inssable;
            inssable.setInns(inss);
            return (T) this;
        }

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

        public T withAddress(Addressable addressable, Address address){
            this.addressable = addressable;
            addressable.setAddress(address);
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

        public Address getAddress(){
            return addressable.getAddress();
        }

        public Addressable getAddressable() {
            return addressable;
        }

        public String getInss(){
            return inssable.getInss();
        }

        public INSSable getInssable() {
            return inssable;
        }
    }
}
