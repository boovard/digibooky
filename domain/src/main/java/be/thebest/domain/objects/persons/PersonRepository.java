package be.thebest.domain.objects.persons;

import be.thebest.domain.objects.persons.*;

import javax.inject.Named;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Named
public class PersonRepository {

    private Map<UUID, Person> personRepository;

    public PersonRepository() {
        this.personRepository = new HashMap<>();
        addAdmin(new Admin("Deletinne", "Niels", "niels.delestinne@switchfully.com"));
    }

    public Map<UUID, Person> getPersonRepository() {
        return Collections.unmodifiableMap(personRepository);
    }

    public Map<UUID, Member> getMembersFromRepository() {
        Map<UUID, Member> memberRepository = new HashMap<>();
        for (Person person : personRepository.values()) {
            if (person instanceof Member) {
                memberRepository.put(person.getUniqueID(), (Member) person);
            }
        }
        return memberRepository;
    }

    private Person addPerson(Person person) {
        person.setUniqueID(UUID.randomUUID());
        personRepository.put(person.getUniqueID(), person);
        return personRepository.get(person.getUniqueID());
    }

    public Member addMember(Member member) {
        return (Member) addPerson(member);
    }


    public Admin addAdmin(Admin admin) {
        return (Admin) addPerson(admin);
    }

    public Librarian addLibrarian(Librarian librarian) {
        return (Librarian) addPerson(librarian);
    }

    public void removePerson(UUID uuid) {
        personRepository.remove(uuid);
    }

    //Necessary because we don't have transactions
    //Do not use outside of test scope!
    public void clearRepository() {
        personRepository.clear();
    }
}
