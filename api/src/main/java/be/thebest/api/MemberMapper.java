package be.thebest.api;

import be.thebest.domain.objects.persons.Member;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MemberMapper {

    private AddressMapper addressMapper;

    @Inject
    public MemberMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public MemberDto toDto(Member member) {
        return MemberDto.memberDto()
                .withUUID(member.getUniqueID())
                .withLastName(member.getLastName())
                .withFirstName(member.getFirstName())
                .withEmail(member.getEmail())
                .withInss(member.getInss())
                .withAddressDto(addressMapper.toDto(member.getAddress()));
    }

    public Member toDomain(MemberDto memberDto) {
        return (Member) Member.MemberBuilder.member()
                .withUniqueID(memberDto.getUuid())
                .withLastName(memberDto.getLastName())
                .withFirstName(memberDto.getFirstName())
                .withEmail(memberDto.getEmail())
                .withAddress(addressMapper.toDomain(memberDto.getAddressDto()))
                .withInss(memberDto.getInss())
                .build();
    }
}
