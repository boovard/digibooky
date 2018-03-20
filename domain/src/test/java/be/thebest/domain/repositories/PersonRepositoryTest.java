package be.thebest.domain.repositories;

import be.thebest.domain.objects.persons.Address;
import be.thebest.domain.objects.persons.Admin;
import be.thebest.domain.objects.persons.Person;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.powermock.api.mockito.PowerMockito.when;

@PrepareForTest({UUID.class})
@RunWith(PowerMockRunner.class)
public class PersonRepositoryTest {
    private PersonRepository testRepo;
    private UUID testUUID;

    @Before
    public void setUp() {
        PowerMockito.mockStatic(UUID.class);
        testUUID = new  UUID(56, 53);
        when(UUID.randomUUID()).thenReturn(testUUID);
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
    @Ignore
    public void addMember_whenGivenAllDetails_shouldAddThisMemberToRepo() {
        //TODO change test when Member constructor changes
//        testRepo.addMember("123456789", "Tolkien", "John", "j.r.r.tolkien@gmail.com", new Address("Oxford Street", "21", "2800", "Mechelen"));
//        assertThat(testRepo.getPersonRepository().get(testUUID).getEmail()).isEqualTo("j.r.r.tolkien@gmail.com");
//        assertThat(testRepo.getPersonRepository().get(testUUID).getFirstName()).isEqualTo("John");
//        assertThat(testRepo.getPersonRepository().get(testUUID).getLastName()).isEqualTo("Tolkien");
//        assertThat(testRepo.getPersonRepository().get(testUUID).getUniqueID()).isEqualTo(testUUID);
    }

}