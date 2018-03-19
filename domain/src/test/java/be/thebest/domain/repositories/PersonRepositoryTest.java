package be.thebest.domain.repositories;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonRepositoryTest {
    PersonRepository testRepo;

    @Before
    public void setUp() {
        testRepo = new PersonRepository();
    }

    @Test
    public void addPerson_whenGivenAllNecessaryArguments_shouldAddNewPersonToHashMap() {

    }

}