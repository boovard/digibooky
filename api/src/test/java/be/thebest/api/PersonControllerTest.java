package be.thebest.api;

import be.thebest.api.admins.AdminDto;
import be.thebest.api.admins.AdminMapper;
import be.thebest.api.librarians.LibrarianDto;
import be.thebest.api.librarians.LibrarianMapper;
import be.thebest.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.internal.verification.VerificationModeFactory.times;

public class PersonControllerTest {
    private PersonService mockService;
    private MemberMapper mockMemberMapper;
    private AdminMapper mockAdminMapper;
    private LibrarianMapper mockLibrarianMapper;
    private PersonController controller;


    @Before
    public void setUp() {
        mockService = Mockito.mock(PersonService.class);
        mockMemberMapper = Mockito.mock(MemberMapper.class);
        mockAdminMapper = Mockito.mock(AdminMapper.class);
        mockLibrarianMapper = Mockito.mock(LibrarianMapper.class);
        controller = new PersonController(mockService, mockMemberMapper, mockAdminMapper, mockLibrarianMapper);
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
        Mockito.verify(mockService, times(1)).addMember(mockMemberMapper.toDomain(mockDto));
    }

    @Test
    public void addMember_shouldCallMapperToDtoAndToDomain() {
        MemberDto mockDto = Mockito.mock(MemberDto.class);
        controller.addMember(mockDto);
        Mockito.verify(mockMemberMapper, times(1)).toDto(mockMemberMapper.toDomain(mockDto));
        Mockito.verify(mockMemberMapper, times(1)).toDomain(mockDto);
    }

    @Test
    public void addLibrarian_shouldCallServiceAddMember() {
        LibrarianDto mockDto = Mockito.mock(LibrarianDto.class);
        controller.addLibrarian(mockDto);
        Mockito.verify(mockService, times(1)).addLibrarian(mockLibrarianMapper.toDomain(mockDto));
    }

    @Test
    public void addLibrarian_shouldCallMapperToDtoAndToDomain() {
        LibrarianDto mockDto = Mockito.mock(LibrarianDto.class);
        controller.addLibrarian(mockDto);
        Mockito.verify(mockLibrarianMapper, times(1)).toDto(mockLibrarianMapper.toDomain(mockDto));
        Mockito.verify(mockLibrarianMapper, times(1)).toDomain(mockDto);
    }

    @Test
    public void addAdmin_shouldCallServiceAddMember() {
        AdminDto mockDto = Mockito.mock(AdminDto.class);
        controller.addAdmin(mockDto);
        Mockito.verify(mockService, times(1)).addAdmin(mockAdminMapper.toDomain(mockDto));
    }

    @Test
    public void addAdmin_shouldCallMapperToDtoAndToDomain() {
        AdminDto mockDto = Mockito.mock(AdminDto.class);
        controller.addAdmin(mockDto);
        Mockito.verify(mockAdminMapper, times(1)).toDto(mockAdminMapper.toDomain(mockDto));
        Mockito.verify(mockAdminMapper, times(1)).toDomain(mockDto);
    }

}