package be.thebest.service;

import be.thebest.domain.repositories.PersonRepository;

import javax.inject.Named;

@Named
public class PersonService {
    private PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }
}
