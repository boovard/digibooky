package be.thebest.domain.objects.lendings;

import be.thebest.domain.objects.Book;
import be.thebest.domain.objects.persons.Member;
import be.thebest.domain.repositories.BookRepository;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import static org.mockito.Mockito.mock;

public class LendingRepositoryTest {
    private LendingRepository lendingRepository;
    private Member mockMember;
    private Book firstMockBook;

    @Before
    public void setUp() {
        mockMember = mock(Member.class);
        lendingRepository = new LendingRepository();
        firstMockBook = mock(Book.class);
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
        Lending testLending = new Lending(firstMockBook, mockMember, LocalDate.now());
        lendingRepository.addLending(testLending);

        Assertions.assertThat(testLending.getLendingId()).isEqualTo(lendingRepository.getLendingCounter() - 1);
    }

}