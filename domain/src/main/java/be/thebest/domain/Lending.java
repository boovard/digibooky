package be.thebest.domain;


import be.thebest.domain.Persons.Person;

import java.time.LocalDate;

public class Lending {
    private Book book;
    private Person person;
    private LocalDate lendingDate;

    public Lending(Book book, Person person, LocalDate lendingDate) {
        this.book = book;
        this.person = person;
        this.lendingDate = lendingDate;
    }

    public Book getBook() {
        return book;
    }

    public Person getPerson() {
        return person;
    }

    public LocalDate getLendingDate() {
        return lendingDate;
    }

}
