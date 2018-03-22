package be.thebest.api;

import be.thebest.api.books.BookMapper;
import be.thebest.domain.objects.lendings.Lending;
import be.thebest.domain.repositories.BookRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;

@Named
public class LendingMapper {
    private BookMapper bookMapper;
    private MemberMapper memberMapper;
    private BookRepository bookRepository;

    @Inject
    public LendingMapper(BookMapper bookMapper, MemberMapper memberMapper, BookRepository bookRepository) {
        this.bookMapper = bookMapper;
        this.memberMapper = memberMapper;
        this.bookRepository = bookRepository;
    }

    public LendingDto toDto(Lending lending) {
        return LendingDto.lendingDto()
                .withISBN(lending.getBook().getIsbn())
                .withLendingId(lending.getLendingId())
                .withlendingDateYear(lending.getLendingDate().getYear())
                .withlendingDateMonth(lending.getLendingDate().getMonthValue())
                .withlendingDateDay(lending.getLendingDate().getDayOfMonth())
                .withMemberDto(memberMapper.toDto(lending.getMember()));
    }

    public Lending toDomain(LendingDto lendingDto) {
        return Lending.LendingBuilder.lending()
                .withBook(bookRepository.getBookByIsbn(lendingDto.getIsbn()))
                .withMember(memberMapper.toDomain(lendingDto.getMemberDto()))
                .withLendingId(lendingDto.getLendingId())
                .withLendingDate(LocalDate.of(lendingDto.getLendingDateYear(), lendingDto.getLendingDateMonth(), lendingDto.getLendingDateDay()))
                .build();
    }

}
