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
        addAdmin("Deletinne", "Niels", "niels.delestinne@switchfully.com");
    }

    public Map<UUID, Person> getPersonRepository() {
        return Collections.unmodifiableMap(personRepository);
    }

    public Map<UUID, Person> getMembersFromRepository(){
        Map<UUID, Person> memberRepository = new HashMap<>();
        for (Person person : personRepository.values()){
            if (person instanceof Member){
                memberRepository.put(person.getUniqueID(),person);
            }
        }
        return memberRepository;
    }

    public void addPerson(Person person) {
        personRepository.put(person.getUniqueID(), person);
    }

    public void addMember(String inss, String lastName, String firstName, String eMailAddress, Address address) {
        UUID uuid = UUID.randomUUID();
        Member member = new Member(uuid, inss, lastName, firstName, eMailAddress, address);
        addPerson(member);
    }

    public void addAdmin(String lastName, String firstName, String email) {
        UUID uuid = UUID.randomUUID();
        Admin admin = new Admin(uuid, lastName, firstName, email);
        addPerson(admin);
    }

    public void addLibrarian(String lastName, String firstName, String email) {
        UUID uuid = UUID.randomUUID();
        Librarian librarian = new Librarian(uuid, lastName, firstName, email);
        addPerson(librarian);
    }
}
