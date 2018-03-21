package be.thebest.api;

import be.thebest.domain.objects.persons.Address;
import be.thebest.domain.objects.persons.Member;
import be.thebest.domain.repositories.PersonRepository;
import be.thebest.service.PersonService;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestApplication.class})
public class DigibookyControllerIntegrationTest {
    private Member leander;
    private Member simon;
    private Member dirk;
    private Member lien;

    @Before
    public void setUp() {
        leander = new Member("147258", "Van Reeth", "Leander", "yolo@swag.com", new Address("2800", "Mechelen"));
        simon = new Member("456789", "Bouvy", "Simon", "cappy@odysey.com", new Address("1000", "New Donk City"));
        dirk = new Member("789156", "Hermans", "Dirk", "diher@81.com", new Address("Diher", "81", "8181", "Dihertown"));
        lien = new Member("164978", "Block", "Marie-Lynne", "machine@learning.com", new Address("4659", "Middle of nowhere"));
    }

    @Inject
    private PersonController controller;
    @Inject
    private PersonService service;
    @Inject
    private PersonRepository repository;
    @Inject
    private MemberMapper mapper;

    private void addFourMembers(PersonRepository repo) {
        repo.addMember(leander);
        repo.addMember(simon);
        repo.addMember(dirk);
        repo.addMember(lien);
    }

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

    @Test
    public void getMembers_givenRepoWithFourMembers_shouldReturnAllFourMembers() {
        addFourMembers(repository);
        List<MemberDto> actualMembers = controller.getMembers();
        List<MemberDto> expectedMembers = new ArrayList<>();
        expectedMembers.add(mapper.toDto(leander));
        expectedMembers.add(mapper.toDto(simon));
        expectedMembers.add(mapper.toDto(dirk));
        expectedMembers.add(mapper.toDto(lien));
        Assertions.assertThat(actualMembers).containsExactlyInAnyOrderElementsOf(expectedMembers);
    }

}
