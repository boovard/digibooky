package be.thebest.domain.objects.persons;


import java.util.UUID;

public class Admin extends Person {

    public Admin(){
    }

    public Admin(UUID uniqueID, String lastName, String firstName, String email, HasNoAddress hasNoAddress) {
        super(uniqueID, lastName, firstName, email, hasNoAddress);
    }

    public static class AdminBuilder extends PersonBuilder{

        public static AdminBuilder admin(){
            return new AdminBuilder();
        }

        @Override
        public Person build() {
            Admin admin = new Admin();
            admin.setUniqueID(this.getUniqueID());
            admin.setLastName(this.getLastName());
            admin.setFirstName(this.getFirstName());
            admin.setEmail(this.getEmail());
            return admin;
        }
    }
}
