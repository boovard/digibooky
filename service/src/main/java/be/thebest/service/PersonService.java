package be.thebest.service;

import be.thebest.domain.exception.EmailValidationException;
import be.thebest.domain.exception.InssValidationException;
import be.thebest.domain.objects.persons.Address;
import be.thebest.domain.objects.persons.Member;
import be.thebest.domain.objects.persons.Person;
import be.thebest.domain.repositories.PersonRepository;

import javax.inject.Inject;
import javax.inject.Named;
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
        //TODO make it an unmodifiable list
        verifyPermission();
        return repository.getMembersFromRepository().entrySet().stream()
                .map(person -> (Member) person)
                .collect(Collectors.toList());
    }

    public Member addMember(String inss, String lastName, String firstName, String eMailAddress, Address address) {
        Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        Matcher m = p.matcher(eMailAddress);
        if (!m.matches()){
            throw new EmailValidationException("invalid email address");
        }
        for (Member member : repository.getMembersFromRepository().values()) {
            if (member.getInss().equals(inss)){
                throw new InssValidationException("INSS number already used");
            }
            if (member.getEmail().equals(eMailAddress)){
                throw new EmailValidationException("email address already used");
            }
        }
        return repository.addMember(inss,lastName,firstName,eMailAddress,address);
    }

    private void verifyPermission() {
        //Asked Niels: can be ignored
    }
}
