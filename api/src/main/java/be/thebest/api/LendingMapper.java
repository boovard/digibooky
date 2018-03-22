package be.thebest.api;

import be.thebest.api.books.BookMapper;
import be.thebest.domain.objects.lendings.Lending;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;

@Named
public class LendingMapper {
    private BookMapper bookMapper;
    private MemberMapper memberMapper;

    @Inject
    public LendingMapper(BookMapper bookMapper, MemberMapper memberMapper) {
        this.bookMapper = bookMapper;
        this.memberMapper = memberMapper;
    }

    public LendingDto toDto(Lending lending) {
        return LendingDto.lendingDto()
                .withBookDto(bookMapper.toDto(lending.getBook()))
                .withLendingId(lending.getLendingId())
                .withlendingDateYear(lending.getLendingDate().getYear())
                .withlendingDateMonth(lending.getLendingDate().getMonthValue())
                .withlendingDateDay(lending.getLendingDate().getDayOfMonth())
                .withMemberDto(memberMapper.toDto(lending.getMember()));
    }

    public Lending toDomain(LendingDto lendingDto) {
        return Lending.LendingBuilder.lending()
                .withBook(bookMapper.toDomain(lendingDto.getBookDto()))
                .withLendingId(lendingDto.getLendingId())
                .withLendingDate(LocalDate.of(lendingDto.getLendingDateYear(), lendingDto.getLendingDateMonth(), lendingDto.getLendingDateDay()))
                .build();
    }

}
