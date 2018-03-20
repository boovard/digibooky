package be.thebest.domain.objects.persons;

import java.util.UUID;

public class Member extends Person {

    public Member() {
    }

    public Member(UUID uniqueID, String inss, String lastName, String firstName, String email, Address address) {
        super(uniqueID, lastName, firstName, email);
        this.setAddressable(new HasAddress());
        this.setInssable(new HasInss());
        this.setAddress(address);
        this.setInss(inss);
    }

    public Member(UUID uniqueID, String inss, String lastName, String email, Address address) {
        super(uniqueID, lastName, email);
        this.setAddressable(new HasAddress());
        this.setInssable(new HasInss());
        this.setAddress(address);
        this.setInss(inss);
    }



    public static class MemberBuilder extends PersonBuilder<MemberBuilder> {

        public static MemberBuilder member() {
            return new MemberBuilder();
        }

        @Override
        public Person build() {
            Member member = new Member();
            member.setUniqueID(this.getUniqueID());
            member.setLastName(this.getLastName());
            member.setFirstName(this.getFirstName());
            member.setEmail(this.getEmail());
            member.setInssable(this.getInssable());
            member.setInss(this.getInss());
            member.setAddressable(this.getAddressable());
            member.setAddress(this.getAddress());
            return member;
        }
    }
}
