package be.thebest.service;

import be.thebest.domain.exception.LendingException;
import be.thebest.domain.objects.Book;
import be.thebest.domain.objects.lendings.Lending;
import be.thebest.domain.objects.lendings.LendingRepository;
import be.thebest.domain.objects.persons.Member;
import be.thebest.domain.repositories.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class LendingServiceTest {
    LendingRepository mockLendingRepo;
    BookRepository mockBookRepo;
    LendingService testService;
    Map<Long, Lending> testLendingMap;
    Map<Book, LocalDate> testLentBooksMap;

    @Before
    public void setUp() {
        mockLendingRepo = mock(LendingRepository.class);
        mockBookRepo = mock(BookRepository.class);
        testService = new LendingService(mockLendingRepo, mockBookRepo);
        testLendingMap = new HashMap<>();
        testLentBooksMap = new HashMap<>();

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

    @Test
    public void returnBook_happyPath_shouldCallRepoRemoveBook() {
        Lending firstMockLending = mock(Lending.class);
        Lending secondMockLending = mock(Lending.class);
        when(firstMockLending.getLendingId()).thenReturn(0L);
        when(mockLendingRepo.getLendingRepository()).thenReturn(testLendingMap);
        when(mockLendingRepo.getLending(firstMockLending.getLendingId())).thenReturn(firstMockLending);
        when(firstMockLending.getDueDate(Lending.NORMAL_LENDING_PERIOD))
                .thenReturn(LocalDate.now());
        testLendingMap.put(0L, firstMockLending);
        testLendingMap.put(1L, secondMockLending);
        testService.addLending(firstMockLending);

        testService.returnBook(firstMockLending.getLendingId());

        Mockito.verify(mockLendingRepo, times(1)).removeLending(firstMockLending.getLendingId());
    }

    @Test
    public void returnBook_happyPath_shouldReturnReturnObjectWithReturnCode1() {
        Lending firstMockLending = mock(Lending.class);
        Lending secondMockLending = mock(Lending.class);
        testLendingMap.put(0L, firstMockLending);
        testLendingMap.put(1L, secondMockLending);
        when(firstMockLending.getLendingId()).thenReturn(0L);
        when(mockLendingRepo.getLendingRepository()).thenReturn(testLendingMap);
        when(mockLendingRepo.getLending(firstMockLending.getLendingId())).thenReturn(firstMockLending);
        when(firstMockLending.getDueDate(Lending.NORMAL_LENDING_PERIOD))
                .thenReturn(LocalDate.now());
        testService.addLending(firstMockLending);

        Assertions.assertThat(testService.returnBook(firstMockLending.getLendingId()).getReturnCode()).isEqualTo(1);
    }

    @Test
    public void returnBook_whenLendingIdIsFalse_shouldReturnReturnObjectWithReturnCode3() {
        Lending firstMockLending = mock(Lending.class);
        when(firstMockLending.getLendingId()).thenReturn(0L);
        when(mockLendingRepo.getLendingRepository()).thenReturn(testLendingMap);
        when(mockLendingRepo.getLending(firstMockLending.getLendingId())).thenReturn(firstMockLending);
        when(firstMockLending.getDueDate(Lending.NORMAL_LENDING_PERIOD))
                .thenReturn(LocalDate.now().plusDays(1));

        Assertions.assertThat(testService.returnBook(firstMockLending.getLendingId()).getReturnCode()).isEqualTo(3);
    }

    @Test
    public void returnBook_whenBookIsLate_shouldReturnReturnObjectWithReturnCode2() {
        Lending firstMockLending = mock(Lending.class);
        Lending secondMockLending = mock(Lending.class);
        testLendingMap.put(0L, firstMockLending);
        testLendingMap.put(1L, secondMockLending);
        when(firstMockLending.getLendingId()).thenReturn(0L);
        when(mockLendingRepo.getLendingRepository()).thenReturn(testLendingMap);
        when(mockLendingRepo.getLending(firstMockLending.getLendingId())).thenReturn(firstMockLending);
        when(firstMockLending.getDueDate(Lending.NORMAL_LENDING_PERIOD))
                .thenReturn(LocalDate.now().minusDays(1));
        testService.addLending(firstMockLending);

        Assertions.assertThat(testService.returnBook(firstMockLending.getLendingId()).getReturnCode()).isEqualTo(2);
    }

    @Test
    public void getBooksByMember_shouldCallRepoMethod() {
        Member mockMember = mock(Member.class);
        when(mockLendingRepo.getLentBooksByMember(mockMember)).thenReturn(testLentBooksMap);

        testService.getLentBooksByMember(mockMember);

        Mockito.verify(mockLendingRepo, times(1)).getLentBooksByMember(mockMember);
    }
}