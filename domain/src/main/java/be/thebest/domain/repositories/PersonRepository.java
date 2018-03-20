package be.thebest.domain.repositories;

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
        addAdmin("Deletinne", "Niels", "niels.delestinne@switchfully.com");
    }

    public Map<UUID, Person> getPersonRepository() {
        return Collections.unmodifiableMap(personRepository);
    }

    public Map<UUID, Member> getMembersFromRepository(){
        Map<UUID, Member> memberRepository = new HashMap<>();
        for (Person person : personRepository.values()){
            if (person instanceof Member){
                memberRepository.put(person.getUniqueID(),(Member)person);
            }
        }
        return memberRepository;
    }

    public Person addPerson(Person person) {
        return personRepository.put(person.getUniqueID(), person);
    }

    public Member addMember(String inss, String lastName, String firstName, String eMailAddress, Address address) {
        UUID uuid = UUID.randomUUID();
        Member member = new Member(uuid, inss, lastName, firstName, eMailAddress, address);
        return (Member)addPerson(member);
    }


    public Admin addAdmin(String lastName, String firstName, String email) {
        UUID uuid = UUID.randomUUID();
        Admin admin = new Admin(uuid, lastName, firstName, email);
        return (Admin)addPerson(admin);
    }

    public Librarian addLibrarian(String lastName, String firstName, String email) {
        UUID uuid = UUID.randomUUID();
        Librarian librarian = new Librarian(uuid, lastName, firstName, email);
        return (Librarian)addPerson(librarian);
    }
}
