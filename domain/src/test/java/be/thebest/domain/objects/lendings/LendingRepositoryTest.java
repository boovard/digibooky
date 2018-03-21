package be.thebest.domain.objects.lendings;

import be.thebest.domain.objects.Author;
import be.thebest.domain.objects.Book;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LendingRepositoryTest {
    private LendingRepository lendingRepository;

    @Before
    public void setUp() {
        lendingRepository = new LendingRepository();
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

        Assertions.assertThat(lendingRepository.contains(mockLending)).isTrue();

    }

    @Test
    @Ignore
    public void addLending_whenBookAlreadyLent_shouldThrowException() {
        Lending mockLending = mock(Lending.class);
        Lending secondMockLending = mock(Lending.class);
        when(mockLending.getBook()).thenReturn(new Book("123", "456", new Author(5, "789", "465")));
        when(secondMockLending.getBook()).thenReturn(new Book("123", "456", new Author(5, "789", "465")));
        lendingRepository.addLending(mockLending);
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
                lendingRepository.addLending(mockLending);
        }).withMessage("That book is already lent out.");
    }

}