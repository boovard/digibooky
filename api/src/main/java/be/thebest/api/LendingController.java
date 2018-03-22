package be.thebest.api;

import be.thebest.service.LendingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/lendings")
public class LendingController {
    private LendingService lendingService;
    private LendingMapper lendingMapper;
    private ReturnObjectMapper returnObjectMapper;

    @Inject
    public LendingController(LendingService lendingService, LendingMapper lendingMapper, ReturnObjectMapper returnObjectMapper) {
        this.lendingService = lendingService;
        this.lendingMapper = lendingMapper;
        this.returnObjectMapper = returnObjectMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public LendingDto createLending(LendingDto lendingDto) {
        return lendingMapper.toDto(lendingService.addLending(lendingMapper.toDomain(lendingDto)));
    }

    @DeleteMapping(path = "/lendingId", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ReturnObjectDto returnBook(Long lendingId) {
        return returnObjectMapper.toDto(lendingService.returnBook(lendingId));
    }
}
