package be.thebest.api;

import be.thebest.api.books.BookMapper;
import be.thebest.domain.objects.lendings.Lending;
import be.thebest.domain.objects.persons.Member;
import be.thebest.domain.objects.persons.Person;
import be.thebest.service.LendingService;
import be.thebest.service.PersonService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class LendingControllerTest {
    private LendingController testController;
    private LendingMapper mockLendingMapper;
    private LendingService mockLendingService;
    private LendingDto firstMockLendingDto;
    private Lending mockLending;
    private ReturnObjectMapper mockReturnObjectMapper;
    private PersonService mockPersonService;
    private BookMapper mockBookMapper;

    @Before
    public void setUp() {
        mockLendingMapper = mock(LendingMapper.class);
        mockLending = mock(Lending.class);
        mockLendingService = mock(LendingService.class);
        mockReturnObjectMapper = mock(ReturnObjectMapper.class);
        mockPersonService = mock(PersonService.class);
        mockBookMapper = mock(BookMapper.class);
        firstMockLendingDto = mock(LendingDto.class);
        testController = new LendingController(mockLendingService, mockLendingMapper, mockReturnObjectMapper, mockPersonService, mockBookMapper);
    }

    @Test
    public void createLending_shouldCallServiceAddLending() {
        when(mockLendingMapper.toDomain(firstMockLendingDto)).thenReturn(mockLending);

        testController.createLending(firstMockLendingDto);

        Mockito.verify(mockLendingService, times(1)).addLending(mockLendingMapper.toDomain(firstMockLendingDto));
    }

    @Test
    public void returnBook_shouldCallServiceReturnBook() {
        Long lendingId = 1L;

        testController.returnBook(lendingId);

        Mockito.verify(mockLendingService, times(1)).returnBook(lendingId);
    }

    @Test
    @Ignore
    public void getLentBooksByMember_shouldCallServiceMethod() {
        Member mockMember = mock(Member.class);
        when(mockMember.getUniqueID()).thenReturn(UUID.randomUUID());

        testController.getLentBooksByMember(mockMember.getUniqueID());

        Mockito.verify(mockLendingService, times(1)).getLentBooksByMember(mockMember);
    }

}