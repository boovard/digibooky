package be.thebest.api;

import be.thebest.domain.objects.persons.Member;
import be.thebest.domain.repositories.PersonRepository;
import be.thebest.service.PersonService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.inject.Inject;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestApplication.class})
public class DigibookyControllerIntegrationTest {

    @Inject
    private PersonController controller;
    @Inject
    private PersonService service;
    @Inject
    private PersonRepository repository;
    @Inject
    private MemberMapper mapper;

    @Test
    public void addMember_givenAMemberDTO_shouldReturnAMemberFromRepository() {
        MemberDto memberDto = new MemberDto()
                .withInss("123456789")
                .withLastName("McTesty")
                .withFirstName("Tester")
                .withEmail("test@test.com")
                .withAddressDto(new AddressDto().withCity("Namur").withpostCode("5000"));
        controller.addMember(memberDto);
        Member tempMember = mapper.toDomain(memberDto);
        Assertions.assertThat(service.getMembers().get(0).getInss()).isEqualTo(tempMember.getInss());
        Assertions.assertThat(service.getMembers().get(0).getLastName()).isEqualTo(tempMember.getLastName());
        Assertions.assertThat(service.getMembers().get(0).getFirstName()).isEqualTo(tempMember.getFirstName());
        Assertions.assertThat(service.getMembers().get(0).getEmail()).isEqualTo(tempMember.getEmail());
    }

}
