package be.thebest.service;

import be.thebest.domain.objects.persons.Member;
import be.thebest.domain.objects.persons.Person;
import be.thebest.domain.repositories.PersonRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Named
public class PersonService {
    private PersonRepository repository;

    @Inject
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Map<UUID, Person> getAllPeople() {
        return repository.getPersonRepository();
    }

    public List<Member> getMembers() {
        verifyPermission();
        return repository.getMembersFromRepository().entrySet().stream()
                .map(person -> (Member) person)
                .collect(Collectors.toList());
    }

    private void verifyPermission() {

    }
}
