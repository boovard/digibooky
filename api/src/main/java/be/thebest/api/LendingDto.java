package be.thebest.api;

import be.thebest.domain.objects.Book;
import be.thebest.domain.objects.persons.Member;
import be.thebest.domain.objects.persons.Person;

import java.time.LocalDate;

public class LendingDto {
    private Book book;
    private Member member;
    private LocalDate lendingDate;
    private Long lendingId;

    public static LendingDto lendingDto() {
        return new LendingDto();
    }

    public LendingDto withBook(Book book) {
        this.book = book;
        return this;
    }

    public LendingDto withMember(Member member) {
        this.member = member;
        return this;
    }

    public LendingDto withLendingDate(LocalDate lendingDate) {
        this.lendingDate = lendingDate;
        return this;
    }

    public LendingDto withLendingId(Long lendingId) {
        this.lendingId = lendingId;
        return this;
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

    public Long getLendingId() {
        return lendingId;
    }
}
