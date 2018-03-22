package be.thebest.api;

import be.thebest.domain.objects.lendings.Lending;
import be.thebest.service.LendingService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class LendingControllerTest {
    private LendingController testController;
    private LendingMapper mockLendingMapper;
    private LendingService mockService;
    private LendingDto firstMockLendingDto;
    private Lending mockLending;
    private ReturnObjectMapper mockReturnObjectMapper;

    @Before
    public void setUp() {
        mockLendingMapper = mock(LendingMapper.class);
        mockLending = mock(Lending.class);
        mockService = mock(LendingService.class);
        mockReturnObjectMapper = mock(ReturnObjectMapper.class);
        firstMockLendingDto = mock(LendingDto.class);
        testController = new LendingController(mockService, mockLendingMapper, mockReturnObjectMapper);
    }

    @Test
    public void createLending_shouldCallServiceAddLending() {
        when(mockLendingMapper.toDomain(firstMockLendingDto)).thenReturn(mockLending);

        testController.createLending(firstMockLendingDto);

        Mockito.verify(mockService, times(1)).addLending(mockLendingMapper.toDomain(firstMockLendingDto));
    }

    @Test
    public void returnBook_shouldCallServiceReturnBook() {
        Long lendingId = 1L;

        testController.returnBook(lendingId);

        Mockito.verify(mockService, times(1)).returnBook(lendingId);
    }

}