package be.thebest.api;

import be.thebest.domain.objects.lendings.Lending;
import be.thebest.service.LendingService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class LendingControllerTest {
    private LendingController testController;
    private LendingMapper mockMapper;
    private LendingService mockService;
    private LendingDto firstMockLendingDto;
    private Lending mockLending;

    @Before
    public void setUp() {
        mockMapper = mock(LendingMapper.class);
        mockLending = mock(Lending.class);
        mockService = mock(LendingService.class);
        firstMockLendingDto = mock(LendingDto.class);
        testController = new LendingController(mockService, mockMapper);
    }

    @Test
    public void createLending_shouldCallServiceAddLending() {
        when(mockMapper.toDomain(firstMockLendingDto)).thenReturn(mockLending);
        testController.createLending(firstMockLendingDto);
        Mockito.verify(mockService, times(1)).addLending(mockMapper.toDomain(firstMockLendingDto));
    }

}