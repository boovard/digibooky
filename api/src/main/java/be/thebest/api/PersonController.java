package be.thebest.api;

import be.thebest.api.admins.AdminDto;
import be.thebest.api.admins.AdminMapper;
import be.thebest.api.librarians.LibrarianDto;
import be.thebest.api.librarians.LibrarianMapper;
import be.thebest.domain.objects.persons.Librarian;
import be.thebest.domain.objects.persons.Member;
import be.thebest.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/people")
public class PersonController {
    private PersonService personService;
    private MemberMapper memberMapper;
    private AdminMapper adminMapper;
    private LibrarianMapper librarianMapper;


    @Inject
    public PersonController(PersonService personService, MemberMapper memberMapper, AdminMapper adminMapper, LibrarianMapper librarianMapper) {
        this.personService = personService;
        this.memberMapper = memberMapper;
        this.adminMapper = adminMapper;
        this.librarianMapper = librarianMapper;
    }

    @GetMapping(path = "/members", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<MemberDto> getMembers() {
        return personService.getMembers().stream()
                .map(memberMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public MemberDto addMember(MemberDto memberDto) {
        return memberMapper.toDto(personService.addMember(memberMapper.toDomain(memberDto)));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public AdminDto addAdmin(AdminDto adminDto) {
        return adminMapper.toDto(personService.addAdmin(adminMapper.toDomain(adminDto)));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public LibrarianDto addLibrarian(LibrarianDto librarianDto){
        return librarianMapper.toDto(personService.addLibrarian(librarianMapper.toDomain(librarianDto)));
    }
}
