package be.thebest.domain.repositories;

import be.thebest.domain.objects.Persons.Admin;
import be.thebest.domain.objects.Persons.Person;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class PersonRepositoryTest {
    PersonRepository testRepo;

    @Before
    public void setUp() {
        testRepo = new PersonRepository();
    }

    @Test
    public void addPerson_whenAnyPerson_shouldAddNewPersonToHashMap() {
        Person testAdmin = new Admin(UUID.randomUUID(), "Code", "Mike", "mike.code@gmail.com");

        testRepo.addPerson(testAdmin);
        Assertions.assertThat(testRepo.getPersonRepository).contains(testAdmin);

    }

}