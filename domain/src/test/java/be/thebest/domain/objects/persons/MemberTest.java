package be.thebest.domain.objects.persons;

import be.thebest.domain.objects.Address;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.UUID;

public class MemberTest {

    @Test
    public void memberBuilder_givenAMemberBuiltWithBuilder_returnsTheSameResultAsAPersonCreatedWithConstructor(){
        UUID testId = UUID.randomUUID();
        Address testAdress = new Address("5000","Namur");
        Member memberWithConstructor = new Member("testINSS","Kat", "Kit", "kit.kat@test.com", testAdress);
        memberWithConstructor.setUniqueID(testId);
        Person memberWithBuilder = new Member.MemberBuilder()
                .withUniqueID(testId)
                .withInss("testINSS")
                .withLastName("Kat")
                .withFirstName("Kit")
                .withEmail("kit.kat@test.com")
                .withAddress(testAdress)
                .build();
        Assertions.assertThat(memberWithBuilder).isEqualToComparingFieldByField(memberWithConstructor);
    }

}