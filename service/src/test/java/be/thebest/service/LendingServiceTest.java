package be.thebest.service;

import be.thebest.domain.exception.LendingException;
import be.thebest.domain.objects.Book;
import be.thebest.domain.objects.lendings.Lending;
import be.thebest.domain.objects.lendings.LendingRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class LendingServiceTest {
    LendingRepository mockLendingRepo;
    LendingService testService;

    @Before
    public void setUp() {
        mockLendingRepo = mock(LendingRepository.class);
        testService = new LendingService(mockLendingRepo);
    }

    @Test
    public void addLending_shouldCallRepositoryAddLending() {
        Lending mockLending = mock(Lending.class);
        testService.addLending(mockLending);
        Mockito.verify(mockLendingRepo, times(1)).addLending(mockLending);
    }

    @Test
    public void addLending_whenBookAlreadyLent_shouldThrowException() {
        Lending mockLending = mock(Lending.class);
        Book testBook = mock(Book.class);
        when(mockLending.getBook()).thenReturn(testBook);
        when(mockLendingRepo.getLendingRepositorySize()).thenReturn(5);
        when(mockLendingRepo.containsBook(mockLending.getBook())).thenReturn(true);
        Assertions.assertThatExceptionOfType(LendingException.class)
                .isThrownBy(() -> testService.addLending(mockLending))
                .withMessage("That book is already lent out.");
    }
}