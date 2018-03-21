package be.thebest.api;

import be.thebest.service.PersonService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class PersonControllerTest {
    PersonService mockService;
    MemberMapper mockMapper;
    PersonController controller;


    @Before
    public void setUp() {
        mockService = Mockito.mock(PersonService.class);
        mockMapper = Mockito.mock(MemberMapper.class);
        controller = new PersonController(mockService, mockMapper);
    }

    @Test
    public void getMembers_shouldCallServiceGetMembers() {
        controller.getMembers();
        Mockito.verify(mockService, times(1)).getMembers();
    }

    @Test
    public void addMember_shouldCallServiceAddMember() {
        MemberDto mockDto = Mockito.mock(MemberDto.class);
        controller.addMember(mockDto);
        Mockito.verify(mockService, times(1)).addMember(mockMapper.toDomain(mockDto));
    }

    @Test
    public void addMember_shouldCallMapperToDtoAndToDomain() {
        MemberDto mockDto = Mockito.mock(MemberDto.class);
        controller.addMember(mockDto);
        Mockito.verify(mockMapper, times(1)).toDto(mockMapper.toDomain(mockDto));
        Mockito.verify(mockMapper, times(1)).toDomain(mockDto);

    }


}