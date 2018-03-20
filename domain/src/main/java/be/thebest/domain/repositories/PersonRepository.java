package be.thebest.domain.repositories;

import be.thebest.domain.objects.persons.*;

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

    public Map<UUID, Person> getMemebersFromRepository(){
        return null;
    }

    public void addPerson(Person person) {
        personRepository.put(person.getUniqueID(), person);
    }

    public void addMember(String inss, String lastName, String firstName, String eMailAddress, Address address) {
        UUID uuid = UUID.randomUUID();
        Member member = new Member(uuid, inss, lastName, firstName, eMailAddress, address);
        addPerson(member);
    }

    public void addAdmin(Admin admin) {

    }

    public void addLibrarian(Librarian librarian) {

    }
}
