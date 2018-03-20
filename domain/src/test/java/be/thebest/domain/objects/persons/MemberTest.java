package be.thebest.domain.objects.persons;

import be.thebest.domain.objects.persons.Address;
import be.thebest.domain.objects.persons.Member;
import be.thebest.domain.objects.persons.Person;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.UUID;

public class MemberTest {

    @Test
    public void memberBuilder_givenAMemberBuiltWithBuilder_returnsTheSameResultAsAPersonCreatedWithConstructor(){
        UUID testId = UUID.randomUUID();
        Address testAdress = new Address("5000","Namur");
        HasAddress hasAddress = new HasAddress();
//        hasAddress.setAddress(testAdress);
        Member memberWithConstructor = new Member(testId,"testINSS","Kat", "Kit", "kit.kat@test.com", hasAddress, testAdress);
        Person memberWithBuilder = new Member.MemberBuilder()
                .withUniqueID(testId)
                .withInss("testINSS")
                .withLastName("Kat")
                .withFirstName("Kit")
                .withEmail("kit.kat@test.com")
                .withAddress(hasAddress, testAdress)
                .build();
        Assertions.assertThat(memberWithBuilder).isEqualToComparingFieldByField(memberWithConstructor);
    }

}