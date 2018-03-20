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
        repo.addMember("147258", "Van Reeth", "Leander", "yolo@swag.com", new Address("2800", "Mechelen"));
        repo.addMember("456789", "Bouvy", "Simon", "cappy@odysey.com", new Address("1000", "New Donk City"));
        repo.addMember("789156", "Hermans", "Dirk", "diher@81.com", new Address("Diher", "81", "8181", "Dihertown"));
        repo.addMember("164978", "Block", "Marie-Lynne", "machine@learning.com", new Address("4659", "Middle of nowhere"));
    }

    private void addFourMembersAndAnAdmin(PersonRepository repo) {
        addFourMembers(repo);
        repo.addAdmin("Code", "Mike", "mike.code@gmail.com");
    }

    @Before
    public void setUp() {
        testRepo = new PersonRepository();
    }

    @Test
    public void addPerson_whenAnyPerson_shouldAddNewPersonToHashMapWithUUIDAsKey() {
        UUID testId = UUID.randomUUID();
        Person testAdmin = new Admin(testId, "Code", "Mike", "mike.code@gmail.com");
        testRepo.addPerson(testAdmin);
        assertThat(testRepo.getPersonRepository()).contains(entry(testId, testAdmin));
    }

    @Test
    public void addMember_whenGivenAllDetails_shouldAddThisMemberToRepo() {
        final String id = "493410b3-dd0b-4b78-97bf-289f50f6e74f";
        UUID testUUID = UUID.fromString(id);
        PowerMockito.mockStatic(UUID.class);
        when(UUID.randomUUID()).thenReturn(testUUID);
        testRepo.addMember("123456789", "Tolkien", "John", "j.r.r.tolkien@gmail.com", new Address("Oxford Street", "21", "2800", "Mechelen"));
        assertThat(testRepo.getPersonRepository().get(testUUID).getEmail()).isEqualTo("j.r.r.tolkien@gmail.com");
        assertThat(testRepo.getPersonRepository().get(testUUID).getFirstName()).isEqualTo("John");
        assertThat(testRepo.getPersonRepository().get(testUUID).getLastName()).isEqualTo("Tolkien");
        assertThat(testRepo.getPersonRepository().get(testUUID).getUniqueID()).isEqualTo(testUUID);
    }

    @Test
    public void addLibrarian_whenGivenAllDetails_shouldAddThisLibrarianToRepo() {
        final String id = "493410b3-dd0b-4b78-97bf-289f50f6e74f";
        UUID testUUID = UUID.fromString(id);
        PowerMockito.mockStatic(UUID.class);
        when(UUID.randomUUID()).thenReturn(testUUID);
        testRepo.addLibrarian("Rowling", "Joanne", "j.k.rowling@pottermore.com");
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
        testRepo.addAdmin("Code", "Mike", "mike.code@gmail.com");
        assertThat(testRepo.getPersonRepository().get(testUUID).getEmail()).isEqualTo("mike.code@gmail.com");
        assertThat(testRepo.getPersonRepository().get(testUUID).getFirstName()).isEqualTo("Mike");
        assertThat(testRepo.getPersonRepository().get(testUUID).getLastName()).isEqualTo("Code");
        assertThat(testRepo.getPersonRepository().get(testUUID).getUniqueID()).isEqualTo(testUUID);
    }

    @Test
    public void getPersonRepository_whenFourPeopleInRepo_shouldReturnCollectionWithAllFourPeople() {
        addFourMembers(testRepo);
        assertThat(testRepo.getPersonRepository()).hasSize(4);
    }

    @Test
    public void getMembersFromRepository_shouldReturnCollectionWithOnlyTheMembers() {
        addFourMembersAndAnAdmin(testRepo);
        for (UUID key : testRepo.getMembersFromRepository().keySet()) {
            assertThat(testRepo.getMembersFromRepository().get(key).getLastName()).isNotEqualTo("Code");
        }
    }
}