package be.thebest.api;

import be.thebest.domain.objects.persons.Member;
import be.thebest.domain.objects.persons.Person;

import javax.inject.Named;

@Named
public class MemberMapper {

    public MemberDto toDto(Member member) {
        return MemberDto.memberDto()
                .withUUID(member.getUniqueID())
                .withLastName(member.getLastName())
                .withFirstName(member.getFirstName())
                .withEmail(member.getEmail())
                .withAddress(member.getAddress());
    }

    public Person toDomain(MemberDto memberDto) {
        return Member.MemberBuilder.member()
                .withUniqueID(memberDto.getUuid())
                .withLastName(memberDto.getLastName())
                .withAddress(memberDto.getAddress())
                .withInss(memberDto.getInss())
                .build();
    }
}
