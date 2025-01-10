//package com.airTransport.atm_backend.controller;
//
//import com.airTransport.atm_backend.model.CrewManagement;
//import com.airTransport.atm_backend.model.enums.Role;
//import com.airTransport.atm_backend.service.CrewManagementService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.*;
//
//class CrewManagementControllerTest {
//
//    @Mock
//    private CrewManagementService crewManagementService;
//
//    @InjectMocks
//    private CrewManagementController crewManagementController;
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
//        when(crewManagementService.addCrewMember(any(CrewManagement.class))).thenReturn(crewMember);
//
//        CrewManagement result = crewManagementController.addCrewMember(crewMember);
//        assertEquals(crewMember.getName(), result.getName());
//        verify(crewManagementService, times(1)).addCrewMember(any(CrewManagement.class));
//    }
//
//    @Test
//    void updateCrewMember() {
//        when(crewManagementService.updateCrewMember(anyLong(), any(CrewManagement.class))).thenReturn(crewMember);
//
//        CrewManagement result = crewManagementController.updateCrewMember(1L, crewMember);
//        assertEquals(crewMember.getName(), result.getName());
//        verify(crewManagementService, times(1)).updateCrewMember(1L, crewMember);
//    }
//
//    @Test
//    void deleteCrewMember() {
//        doNothing().when(crewManagementService).deleteCrewMember(anyLong());
//
//        crewManagementController.deleteCrewMember(1L);
//        verify(crewManagementService, times(1)).deleteCrewMember(1L);
//    }
//
//    @Test
//    void getCrewMemberById() {
//        when(crewManagementService.getCrewMemberById(anyLong())).thenReturn(crewMember);
//
//        CrewManagement result = crewManagementController.getCrewMemberById(1L);
//        assertEquals(crewMember.getId(), result.getId());
//        verify(crewManagementService, times(1)).getCrewMemberById(1L);
//    }
//
//    @Test
//    void getCrewMembersByRole() {
//        when(crewManagementService.getCrewMembersByRole(any(Role.class))).thenReturn(Collections.singletonList(crewMember));
//
//        List<CrewManagement> result = crewManagementController.getCrewMembersByRole(Role.PILOT);
//        assertEquals(1, result.size());
//        assertEquals(Role.PILOT, result.get(0).getRole());
//        verify(crewManagementService, times(1)).getCrewMembersByRole(Role.PILOT);
//    }
//
//    @Test
//    void getAvailableCrewMembers() {
//        when(crewManagementService.getAvailableCrewMembers()).thenReturn(Collections.singletonList(crewMember));
//
//        List<CrewManagement> result = crewManagementController.getAvailableCrewMembers();
//        assertEquals(1, result.size());
//        assertEquals(true, result.get(0).isAvailability());
//        verify(crewManagementService, times(1)).getAvailableCrewMembers();
//    }
//
//    @Test
//    void getCrewByAdmin() {
//        when(crewManagementService.getCrewByAdmin(anyLong())).thenReturn(Collections.singletonList(crewMember));
//
//        List<CrewManagement> result = crewManagementController.getCrewByAdmin(1L);
//        assertEquals(1, result.size());
//        verify(crewManagementService, times(1)).getCrewByAdmin(1L);
//    }
//}
