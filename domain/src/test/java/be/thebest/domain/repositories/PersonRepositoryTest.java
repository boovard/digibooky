package be.thebest.domain.repositories;

import be.thebest.domain.objects.persons.Admin;
import be.thebest.domain.objects.persons.Member;
import be.thebest.domain.objects.persons.Person;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class PersonRepositoryTest {
    private PersonRepository testRepo;

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
    @Ignore
    public void addMember_whenGivenAllDetails_shouldAddMemberToRepo() {
        //testRepo.addMember("Tolkien", "John", "j.r.r.tolkien@gmail.com");
    }

}