package be.thebest.domain.objects.lendings;

import be.thebest.domain.objects.Book;
import be.thebest.domain.objects.persons.Member;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

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

    @Test
    public void removeLending_shouldRemoveLendingFromRepo() {
        Lending mockLending = mock(Lending.class);
        lendingRepository.addLending(mockLending);
        lendingRepository.removeLending(mockLending.getLendingId());
        Assertions.assertThat(lendingRepository.getLendingRepository()).doesNotContainValue(mockLending);
    }

    @Test
    public void getLentBooks_shouldReturnMapOfBooksWithDueDates() {
        Member mockMember = mock(Member.class);
        Lending firstMockLending = mock(Lending.class);
        when(firstMockLending.getMember())
                .thenReturn(mockMember);
        when(firstMockLending.getDueDate(Lending.NORMAL_LENDING_PERIOD))
                .thenReturn(LocalDate.now().minusDays(1));
        when(firstMockLending.getBook())
                .thenReturn(firstMockBook);
        Book secondMockBook = mock(Book.class);
        Lending secondMockLending = mock(Lending.class);
        when(secondMockLending.getDueDate(Lending.NORMAL_LENDING_PERIOD))
                .thenReturn(LocalDate.now().minusDays(1));
        when(secondMockLending.getBook())
                .thenReturn(secondMockBook);
        when(secondMockLending.getMember())
                .thenReturn(mockMember);

        lendingRepository.addLending(firstMockLending);
        lendingRepository.addLending(secondMockLending);

        Assertions.assertThat(lendingRepository.getLentBooksByMember(mockMember).keySet())
                .containsExactlyInAnyOrder(firstMockBook, secondMockBook);
        Assertions.assertThat(lendingRepository.getLentBooksByMember(mockMember).values())
                .containsExactlyInAnyOrder(firstMockLending.getDueDate(Lending.NORMAL_LENDING_PERIOD), secondMockLending.getDueDate(Lending.NORMAL_LENDING_PERIOD));
    }

    @Test
    public void getLentBooks_whenNoLendingsForThisMember_shouldReturnEmptyMap() {
        Member mockMember = mock(Member.class);
        Assertions.assertThat(lendingRepository.getLentBooksByMember(mockMember)).isEmpty();
    }

}