package be.thebest.api;

import be.thebest.api.books.BookMapper;
import be.thebest.domain.objects.lendings.Lending;

import javax.inject.Inject;

public class LendingMapper {
    private BookMapper bookMapper;
    private MemberMapper memberMapper;

    @Inject
    public LendingMapper(BookMapper bookMapper, MemberMapper memberMapper) {
        this.bookMapper = bookMapper;
        this.memberMapper = memberMapper;
    }

    public LendingDto toDto(Lending lending){
        return LendingDto.lendingDto()
                .withBookDto(bookMapper.toDto(lending.getBook()))
                .withLendingDate(lending.getLendingDate())
                .withLendingId(lending.getLendingId())
                .withMemberDto(memberMapper.toDto(lending.getMember()));
    }

    public Lending toDomain(LendingDto lendingDto) {
return null;
    }

}
