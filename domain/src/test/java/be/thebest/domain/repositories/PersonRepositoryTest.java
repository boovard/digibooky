package be.thebest.domain.repositories;

import be.thebest.domain.objects.persons.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.powermock.api.mockito.PowerMockito.when;


@PrepareForTest({UUID.class, PersonRepository.class})
@RunWith(PowerMockRunner.class)
public class PersonRepositoryTest {
    private PersonRepository testRepo;

    private void addFourMembers(PersonRepository repo) {
        repo.addMember(new Member("147258", "Van Reeth", "Leander", "yolo@swag.com", new Address("2800", "Mechelen")));
        repo.addMember(new Member("456789", "Bouvy", "Simon", "cappy@odysey.com", new Address("1000", "New Donk City")));
        repo.addMember(new Member("789156", "Hermans", "Dirk", "diher@81.com", new Address("Diher", "81", "8181", "Dihertown")));
        repo.addMember(new Member("164978", "Block", "Marie-Lynne", "machine@learning.com", new Address("4659", "Middle of nowhere")));
    }

    private void addFourMembersAndAnAdmin(PersonRepository repo) {
        addFourMembers(repo);
        repo.addAdmin(new Admin("Code", "Mike", "mike.code@gmail.com"));
    }

    @Before
    public void setUp() {
        testRepo = new PersonRepository();
    }

    @Test
    public void addMember_whenGivenAllDetails_shouldAddThisMemberToRepo() {
        final String id = "493410b3-dd0b-4b78-97bf-289f50f6e74f";
        UUID testUUID = UUID.fromString(id);
        PowerMockito.mockStatic(UUID.class);
        when(UUID.randomUUID()).thenReturn(testUUID);
        Member testMember = new Member("123456789", "Tolkien", "John", "j.r.r.tolkien@gmail.com", new Address("Oxford Street", "21", "2800", "Mechelen"));
        testRepo.addMember(testMember);
        assertThat(testRepo.getPersonRepository().get(testUUID).getEmail()).isEqualTo("j.r.r.tolkien@gmail.com");
        assertThat(testRepo.getPersonRepository().get(testUUID).getFirstName()).isEqualTo("John");
        assertThat(testRepo.getPersonRepository().get(testUUID).getLastName()).isEqualTo("Tolkien");
        assertThat(testRepo.getPersonRepository().get(testUUID).getUniqueID()).isEqualTo(testUUID);
    }

    @Test
    public void addMember_whenGivenAllDetails_shouldReturnThisMember() {
        final String id = "493410b3-dd0b-4b78-97bf-289f50f6e74f";
        UUID testUUID = UUID.fromString(id);
        PowerMockito.mockStatic(UUID.class);
        when(UUID.randomUUID()).thenReturn(testUUID);
        Member testMember = new Member("123456789", "Tolkien", "John", "j.r.r.tolkien@gmail.com", new Address("Oxford Street", "21", "2800", "Mechelen"));
        Member actualMember = testRepo.addMember(testMember);
        assertThat(testRepo.getPersonRepository().get(testUUID).getEmail()).isEqualTo("j.r.r.tolkien@gmail.com");
        assertThat(testRepo.getPersonRepository().get(testUUID).getFirstName()).isEqualTo("John");
        assertThat(testRepo.getPersonRepository().get(testUUID).getLastName()).isEqualTo("Tolkien");
        assertThat(testRepo.getPersonRepository().get(testUUID).getUniqueID()).isEqualTo(testUUID);
        assertThat(actualMember).isEqualTo(testMember);
    }

    @Test
    public void addLibrarian_whenGivenAllDetails_shouldAddThisLibrarianToRepo() {
        final String id = "493410b3-dd0b-4b78-97bf-289f50f6e74f";
        UUID testUUID = UUID.fromString(id);
        PowerMockito.mockStatic(UUID.class);
        when(UUID.randomUUID()).thenReturn(testUUID);
        testRepo.addLibrarian(new Librarian("Rowling", "Joanne", "j.k.rowling@pottermore.com"));
        assertThat(testRepo.getPersonRepository().get(testUUID).getEmail()).isEqualTo("j.k.rowling@pottermore.com");
        assertThat(testRepo.getPersonRepository().get(testUUID).getFirstName()).isEqualTo("Joanne");
        assertThat(testRepo.getPersonRepository().get(testUUID).getLastName()).isEqualTo("Rowling");
        assertThat(testRepo.getPersonRepository().get(testUUID).getUniqueID()).isEqualTo(testUUID);
    }

    @Test
    public void addAdmin_whenGivenAllDetails_shouldAddThisAdminToRepo() {
        final String id = "493410b3-dd0b-4b78-97bf-289f50f6e74f";
        UUID testUUID = UUID.fromString(id);
        PowerMockito.mockStatic(UUID.class);
        when(UUID.randomUUID()).thenReturn(testUUID);
        testRepo.addAdmin(new Admin("Code", "Mike", "mike.code@gmail.com"));
        assertThat(testRepo.getPersonRepository().get(testUUID).getEmail()).isEqualTo("mike.code@gmail.com");
        assertThat(testRepo.getPersonRepository().get(testUUID).getFirstName()).isEqualTo("Mike");
        assertThat(testRepo.getPersonRepository().get(testUUID).getLastName()).isEqualTo("Code");
        assertThat(testRepo.getPersonRepository().get(testUUID).getUniqueID()).isEqualTo(testUUID);
    }

    @Test
    public void getPersonRepository_whenFourPeopleInRepo_shouldReturnCollectionWithAllFourPeopleAndOriginalAdmin() {
        addFourMembers(testRepo);
        assertThat(testRepo.getPersonRepository()).hasSize(5);
    }

    @Test
    public void getMembersFromRepository_shouldReturnCollectionWithOnlyTheMembers() {
        addFourMembersAndAnAdmin(testRepo);
        for (UUID key : testRepo.getMembersFromRepository().keySet()) {
            assertThat(testRepo.getMembersFromRepository().get(key).getLastName()).isNotEqualTo("Code");
            assertThat(testRepo.getMembersFromRepository().get(key).getLastName()).isNotEqualTo("Deletinne");
        }
        assertThat(testRepo.getMembersFromRepository()).hasSize(4);
    }
}