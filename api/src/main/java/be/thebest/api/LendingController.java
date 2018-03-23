package be.thebest.api;

import be.thebest.api.books.BookDto;
import be.thebest.api.books.BookMapper;
import be.thebest.domain.objects.persons.Member;
import be.thebest.service.LendingService;
import be.thebest.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/lendings")
public class LendingController {
    private LendingService lendingService;
    private LendingMapper lendingMapper;
    private ReturnObjectMapper returnObjectMapper;
    private PersonService personService;
    private BookMapper bookMapper;

    @Inject
    public LendingController(LendingService lendingService, LendingMapper lendingMapper, ReturnObjectMapper returnObjectMapper, PersonService personService, BookMapper bookMapper) {
        this.lendingService = lendingService;
        this.lendingMapper = lendingMapper;
        this.returnObjectMapper = returnObjectMapper;
        this.personService = personService;
        this.bookMapper = bookMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public LendingDto createLending(@RequestBody LendingDto lendingDto) {
        return lendingMapper.toDto(lendingService.addLending(lendingMapper.toDomain(lendingDto)));
    }

    @DeleteMapping(path = "/{lendingId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ReturnObjectDto returnBook(@PathVariable("lendingId") Long lendingId) {
        return returnObjectMapper.toDto(lendingService.returnBook(lendingId));
    }

    @GetMapping(path = "/{memberId}")
    @ResponseStatus(HttpStatus.OK)
    public Map<BookDto, String> getLentBooksByMember(@PathVariable("memberId") UUID memberId) {
        Member member = personService.getMembers().get(memberId);
        return lendingService.getLentBooksByMember(member).entrySet().stream()
                .collect(Collectors.toMap(entry -> bookMapper.toDto(entry.getKey()), entry -> entry.getValue().toString()));
    }

    @GetMapping(path = "/overdue")
    @ResponseStatus(HttpStatus.OK)
    public List<LendingDto> getOverdueBooks() {
        //TODO LendingDto shows lending date; but this list should show the due date
        return lendingService.getOverdueBooks().stream()
                .map(lending -> lendingMapper.toDto(lending))
                .collect(Collectors.toList());
    }
}
