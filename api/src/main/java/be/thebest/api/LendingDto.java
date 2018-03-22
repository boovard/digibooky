package be.thebest.api;

public class LendingDto {
    private String isbn;
    private MemberDto memberDto;
    private int lendingDateYear;
    private int lendingDateMonth;
    private int lendingDateDay;
    private Long lendingId;

    public static LendingDto lendingDto() {
        return new LendingDto();
    }

    public LendingDto withISBN(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public LendingDto withMemberDto(MemberDto memberDto) {
        this.memberDto = memberDto;
        return this;
    }

    public LendingDto withlendingDateYear(int lendingDateYear) {
        this.lendingDateYear = lendingDateYear;
        return this;
    }

    public LendingDto withlendingDateMonth(int lendingDateMonth) {
        this.lendingDateMonth = lendingDateMonth;
        return this;
    }

    public LendingDto withlendingDateDay(int lendingDateDay) {
        this.lendingDateDay = lendingDateDay;
        return this;
    }

    public LendingDto withLendingId(Long lendingId) {
        this.lendingId = lendingId;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public MemberDto getMemberDto() {
        return memberDto;
    }

    public int getLendingDateYear() {
        return lendingDateYear;
    }

    public int getLendingDateMonth() {
        return lendingDateMonth;
    }

    public int getLendingDateDay() {
        return lendingDateDay;
    }

    public Long getLendingId() {
        return lendingId;
    }
}
