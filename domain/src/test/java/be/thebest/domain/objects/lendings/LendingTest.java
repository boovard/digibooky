package be.thebest.domain.objects.lendings;

import be.thebest.domain.objects.Book;
import be.thebest.domain.objects.persons.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class LendingTest {

    @Test
    public void getDueDate_shouldReturnTodayPlusThreeWeeks() {
        Book testBook = mock(Book.class);
        Member testMember = mock(Member.class);
        Lending testLending = new Lending(testBook, testMember, LocalDate.of(1999,1,1));

        LocalDate actualDueDate = testLending.getDueDate(Lending.NORMAL_LENDING_PERIOD);
        LocalDate expectedDueDate = LocalDate.of(1999, 1, 22);
        Assertions.assertThat(actualDueDate).isEqualTo(expectedDueDate);
    }

}