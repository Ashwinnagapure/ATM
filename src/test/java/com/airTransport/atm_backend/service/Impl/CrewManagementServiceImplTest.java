//package com.airTransport.atm_backend.service.Impl;
//
//import com.airTransport.atm_backend.model.Admin;
//import com.airTransport.atm_backend.model.CrewManagement;
//import com.airTransport.atm_backend.model.enums.Role;
//import com.airTransport.atm_backend.repository.CrewManagementRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class CrewManagementServiceImplTest {
//
//    @Mock
//    private CrewManagementRepository crewMemberRepository;
//
//    @Mock
//    private AdminServiceImpl adminService;
//
//    @InjectMocks
//    private CrewManagementServiceImpl crewManagementService;
//
//    private AutoCloseable closeable;
//    private CrewManagement crewMember;
//
//    @BeforeEach
//    void setUp() {
//        closeable = MockitoAnnotations.openMocks(this);
//        crewMember = new CrewManagement();
//        crewMember.setId(1L);
//        crewMember.setName("John Doe");
//        crewMember.setRole(Role.PILOT);
//        crewMember.setAvailability(true);
//    }
//
//    @AfterEach
//    void tearDown() throws Exception {
//        closeable.close();
//    }
//
//    @Test
//    void addCrewMember() {
//        when(crewMemberRepository.save(any(CrewManagement.class))).thenReturn(crewMember);
//
//        CrewManagement result = crewManagementService.addCrewMember(crewMember);
//
//        assertNotNull(result);
//        assertEquals(crewMember.getName(), result.getName());
//        verify(crewMemberRepository, times(1)).save(crewMember);
//    }
//
//    @Test
//    void updateCrewMember() {
//        when(crewMemberRepository.findById(anyLong())).thenReturn(Optional.of(crewMember));
//        when(crewMemberRepository.save(any(CrewManagement.class))).thenReturn(crewMember);
//
//        crewMember.setName("Jane Doe");
//        CrewManagement result = crewManagementService.updateCrewMember(1L, crewMember);
//
//        assertNotNull(result);
//        assertEquals("Jane Doe", result.getName());
//        verify(crewMemberRepository, times(1)).findById(1L);
//        verify(crewMemberRepository, times(1)).save(crewMember);
//    }
//
//    @Test
//    void updateCrewMember_NotFound() {
//        when(crewMemberRepository.findById(anyLong())).thenReturn(Optional.empty());
//
//        RuntimeException exception = assertThrows(RuntimeException.class, () ->
//                crewManagementService.updateCrewMember(1L, crewMember));
//
//        assertEquals("Crew Member not found", exception.getMessage());
//        verify(crewMemberRepository, times(1)).findById(1L);
//        verify(crewMemberRepository, never()).save(any());
//    }
//
//    @Test
//    void deleteCrewMember() {
//        doNothing().when(crewMemberRepository).deleteById(anyLong());
//
//        crewManagementService.deleteCrewMember(1L);
//
//        verify(crewMemberRepository, times(1)).deleteById(1L);
//    }
//
//    @Test
//    void getCrewMemberById() {
//        when(crewMemberRepository.findById(anyLong())).thenReturn(Optional.of(crewMember));
//
//        CrewManagement result = crewManagementService.getCrewMemberById(1L);
//
//        assertNotNull(result);
//        assertEquals(crewMember.getId(), result.getId());
//        verify(crewMemberRepository, times(1)).findById(1L);
//    }
//
//    @Test
//    void getCrewMemberById_NotFound() {
//        when(crewMemberRepository.findById(anyLong())).thenReturn(Optional.empty());
//
//        RuntimeException exception = assertThrows(RuntimeException.class, () ->
//                crewManagementService.getCrewMemberById(1L));
//
//        assertEquals("Crew Member not found", exception.getMessage());
//        verify(crewMemberRepository, times(1)).findById(1L);
//    }
//
//    @Test
//    void getCrewMembersByRole() {
//        when(crewMemberRepository.findByRole(any(Role.class))).thenReturn(Collections.singletonList(crewMember));
//
//        List<CrewManagement> result = crewManagementService.getCrewMembersByRole(Role.PILOT);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals(Role.PILOT, result.get(0).getRole());
//        verify(crewMemberRepository, times(1)).findByRole(Role.PILOT);
//    }
//
//    @Test
//    void getAvailableCrewMembers() {
//        when(crewMemberRepository.findByAvailability(true)).thenReturn(Collections.singletonList(crewMember));
//
//        List<CrewManagement> result = crewManagementService.getAvailableCrewMembers();
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertTrue(result.get(0).isAvailability());
//        verify(crewMemberRepository, times(1)).findByAvailability(true);
//    }
//
//    @Test
//    void getCrewByAdmin() {
//        Admin admin = new Admin();
//        admin.setId(1L);
//        when(adminService.getAdminById(anyLong())).thenReturn(admin);
//        when(crewMemberRepository.findByAdmin(any(Admin.class))).thenReturn(Collections.singletonList(crewMember));
//
//        List<CrewManagement> result = crewManagementService.getCrewByAdmin(1L);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        verify(adminService, times(1)).getAdminById(1L);
//        verify(crewMemberRepository, times(1)).findByAdmin(admin);
//    }
//}
