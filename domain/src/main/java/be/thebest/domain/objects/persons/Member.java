package be.thebest.domain.objects.persons;

import java.util.UUID;

public class Member extends Person {

    private String inss;
    private Address address;

    public Member() {
    }

    public Member(String inss, String lastName, String firstName, String email, Address address) {
        super(lastName, firstName, email);
        this.inss = inss;
        this.address = address;
    }

    public Member( String inss, String lastName, String email, Address address) {
        super(lastName, email);
        this.inss = inss;
        this.address = address;
    }

    public String getInss() {
        return inss;
    }

    public void setInss(String inss) {
        this.inss = inss;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static class MemberBuilder extends PersonBuilder<MemberBuilder> {

        private String inss;
        private Address address;

        public static MemberBuilder member() {
            return new MemberBuilder();
        }

        @Override
        public Person build() {
            Member member = new Member();
            member.setUniqueID(this.getUniqueID());
            member.setInss(inss);
            member.setLastName(this.getLastName());
            member.setFirstName(this.getFirstName());
            member.setEmail(this.getEmail());
            member.setAddress(address);
            return member;
        }

        public MemberBuilder withInss(String inss){
            this.inss = inss;
            return this;
        }

        public MemberBuilder withAddress(Address address){
            this.address = address;
            return this;
        }
    }
}
