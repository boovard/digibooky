package be.thebest.service;

import be.thebest.domain.exception.EmailValidationException;
import be.thebest.domain.exception.InssValidationException;
import be.thebest.domain.objects.persons.Address;
import be.thebest.domain.objects.persons.Member;
import be.thebest.domain.objects.persons.Person;
import be.thebest.domain.repositories.PersonRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Named
public class PersonService {
    private PersonRepository repository;

    @Inject
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Map<UUID, Person> getAllPeople() {
        //TODO is this method necessary?
        return repository.getPersonRepository();
    }

    public List<Member> getMembers() {
        verifyPermission();
        return Collections.unmodifiableList(repository.getMembersFromRepository().entrySet().stream()
                .map(person -> (Member) person)
                .collect(Collectors.toList()));
    }

    public Member addMember(Member member) {
        Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        Matcher m = p.matcher(member.getEmail());
        if (!m.matches()){
            throw new EmailValidationException("invalid email address");
        }
        for (Member existingMember : repository.getMembersFromRepository().values()) {
            if (existingMember.getInss().equals(member.getInss())){
                throw new InssValidationException("INSS number already used");
            }
            if (existingMember.getEmail().equals(member.getEmail())){
                throw new EmailValidationException("email address already used");
            }
        }
        return repository.addMember(member);
    }

    private void verifyPermission() {
        //Asked Niels: can be ignored
    }
}
