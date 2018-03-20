package be.thebest.domain.objects.persons;

import java.util.UUID;

public class Member extends Person {

    private String inss;

    public Member() {
    }

    public Member(UUID uniqueID, String inss, String lastName, String firstName, String email, HasAddress hasAddress, Address address) {
        super(uniqueID, lastName, firstName, email, hasAddress);
        this.setAddress(address);
        this.inss = inss;
    }

    public Member(UUID uniqueID, String inss, String lastName, String email, HasAddress hasAddress, Address address) {
        super(uniqueID, lastName, email, hasAddress);
        this.setAddress(address);
        this.inss = inss;
    }

    public String getInss() {
        return inss;
    }


    public void setInss(String inss) {
        this.inss = inss;
    }


    public static class MemberBuilder extends PersonBuilder<MemberBuilder> {
        private String inss;

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
            member.setInss(inss);
            member.setAddressable(this.getAddressable());
            member.setAddress(this.getAddress());
            return member;
        }

        public MemberBuilder withInss(String inss) {
            this.inss = inss;
            return this;
        }
    }
}
