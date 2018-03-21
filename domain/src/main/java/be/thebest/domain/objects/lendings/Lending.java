package be.thebest.domain.objects.lendings;


import be.thebest.domain.objects.Book;
import be.thebest.domain.objects.persons.Person;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lending lending = (Lending) o;
        return Objects.equals(book, lending.book) &&
                Objects.equals(person, lending.person) &&
                Objects.equals(lendingDate, lending.lendingDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(book, person, lendingDate);
    }
}
