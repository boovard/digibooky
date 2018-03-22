package be.thebest.domain.objects.lendings;

import be.thebest.domain.exception.LendingException;
import be.thebest.domain.objects.Author;
import be.thebest.domain.objects.Book;
import be.thebest.domain.objects.persons.Member;
import be.thebest.domain.repositories.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LendingRepositoryTest {
    private LendingRepository lendingRepository;
    private BookRepository mockBookRepo;
    private Member mockMember;

    @Before
    public void setUp() {
        mockMember = mock(Member.class);
        mockBookRepo = mock(BookRepository.class);
        lendingRepository = new LendingRepository(mockBookRepo);
        Book firstMockBook = mock(Book.class);
        when(mockBookRepo.getBookByIsbn("1")).thenReturn(firstMockBook);
    }

    @After
    public void breakDown() {
        lendingRepository.clear();
    }

    @Test
    public void addLending_shouldReturnLending() {
        Lending mockLending = mock(Lending.class);
        Lending actualLending = lendingRepository.addLending(mockLending);

        Assertions.assertThat(actualLending).isEqualTo(mockLending);
    }

    @Test
    public void addLending_shouldAddLendingToRepo() {
        Lending mockLending = mock(Lending.class);
        lendingRepository.addLending(mockLending);

        Assertions.assertThat(lendingRepository.containsLending(mockLending)).isTrue();
    }

    @Test
    public void addLending_shouldSetLendingId() {
        Lending testLending = new Lending(mockBookRepo.getBookByIsbn("1"), mockMember, LocalDate.now());
        lendingRepository.addLending(testLending);

        Assertions.assertThat(testLending.getLendingId()).isEqualTo(lendingRepository.getLendingCounter() - 1);
    }

}