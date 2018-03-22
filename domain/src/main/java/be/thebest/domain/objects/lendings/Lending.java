package be.thebest.domain.objects.lendings;


import be.thebest.domain.objects.Book;
import be.thebest.domain.objects.persons.Person;

import java.time.LocalDate;

public class Lending {
    private Book book;
    private Person person;
    private LocalDate lendingDate;
    public static final long NORMAL_LENDING_PERIOD = 3;

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

    public LocalDate getDueDate(long period) {
        return this.lendingDate.plusWeeks(NORMAL_LENDING_PERIOD);
    }

}
