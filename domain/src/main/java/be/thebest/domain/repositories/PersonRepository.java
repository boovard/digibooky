package be.thebest.domain.repositories;

import be.thebest.domain.objects.persons.Admin;
import be.thebest.domain.objects.persons.Librarian;
import be.thebest.domain.objects.persons.Member;
import be.thebest.domain.objects.persons.Person;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PersonRepository {

    private Map<UUID, Person> personRepository;

    public PersonRepository() {
        this.personRepository = new HashMap<>();
    }

    public Map<UUID, Person> getPersonRepository() {
        return Collections.unmodifiableMap(personRepository);
    }

    public void addPerson(Person person) {
    }

    public void addMember(Member member) {

    }

    public void addAdmin(Admin admin) {

    }

    public void addLibrarian(Librarian librarian) {

    }
}
