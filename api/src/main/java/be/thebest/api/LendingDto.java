package be.thebest.api;

import be.thebest.api.books.BookDto;

import java.time.LocalDate;

public class LendingDto {
    private BookDto bookDto;
    private MemberDto memberDto;
    private LocalDate lendingDate;
    private Long lendingId;

    public static LendingDto lendingDto() {
        return new LendingDto();
    }

    public LendingDto withBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
        return this;
    }

    public LendingDto withMemberDto(MemberDto memberDto) {
        this.memberDto = memberDto;
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

    public BookDto getBookDto() {
        return bookDto;
    }

    public MemberDto getMemberDto() {
        return memberDto;
    }

    public LocalDate getLendingDate() {
        return lendingDate;
    }

    public Long getLendingId() {
        return lendingId;
    }
}
