package be.thebest.api;

import be.thebest.service.LendingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/lendings")
public class LendingController {
    private LendingService lendingService;
    private LendingMapper lendingMapper;

    @Inject
    public LendingController(LendingService lendingService, LendingMapper lendingMapper) {
        this.lendingService = lendingService;
        this.lendingMapper = lendingMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public LendingDto createLending(LendingDto lendingDto) {
        return lendingMapper.toDto(lendingService.addLending(lendingMapper.toDomain(lendingDto)));
    }
}
