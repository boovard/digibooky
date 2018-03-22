package be.thebest.domain.objects.lendings;

import be.thebest.domain.objects.Book;
import be.thebest.domain.objects.persons.Member;

import java.time.LocalDate;
import java.util.Objects;

public class Lending {
    private Book book;
    private Member member;
    private LocalDate lendingDate;
    private Long lendingId;
    public static final long NORMAL_LENDING_PERIOD = 3;

    public Lending(Book book, Member member, LocalDate lendingDate) {
        this.book = book;
        this.member = member;
        this.lendingDate = lendingDate;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getLendingDate() {
        return lendingDate;
    }

    public LocalDate getDueDate(long period) {
        return this.lendingDate.plusWeeks(NORMAL_LENDING_PERIOD);
    }

    public void setLendingId(Long lendingId) {
        this.lendingId = lendingId;
    }

    public Long getLendingId() {
        return lendingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lending lending = (Lending) o;
        return Objects.equals(book, lending.book) &&
                Objects.equals(member, lending.member) &&
                Objects.equals(lendingDate, lending.lendingDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(book, member, lendingDate);
    }

    public static class LendingBuilder {
        private Book book;
        private Member member;
        private LocalDate lendingDate;
        private Long lendingId;

        public LendingBuilder withBook(Book book) {
            this.book = book;
            return this;
        }

        public LendingBuilder withMember(Member person) {
            this.member = person;
            return this;
        }

        public LendingBuilder withLendingDate(LocalDate lendingDate) {
            this.lendingDate = lendingDate;
            return this;
        }

        public LendingBuilder withLendingId(Long lendingId) {
            this.lendingId = lendingId;
            return this;
        }

        public Lending build() {
            Lending tempLending = new Lending(book, member, lendingDate);
            tempLending.setLendingId(lendingId);
            return tempLending;
        }


    }
}
