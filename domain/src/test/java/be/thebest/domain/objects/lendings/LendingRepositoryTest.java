package be.thebest.domain.objects.lendings;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class LendingRepositoryTest {
    private LendingRepository lendingRepository;

    @Before
    public void setUp() {
        lendingRepository = new LendingRepository();
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

//    @Test
//    public void addLending_whenBookAlreadyLent_shouldThrowException() {
//        Lending mockLending = mock(Lending.class);
//        lendingRepository.addLending(mockLending);
//        Assertions.assertThatExceptionOfType(LendingException.class).isThrownBy(() -> {
//                lendingRepository.addLending(mockLending);
//        }).withMessage("That book is already lent out.");
//    }

}