package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.CrewManagementDTO;
import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.CrewManagement;
import com.airTransport.atm_backend.model.enums.Role;
import com.airTransport.atm_backend.repository.CrewManagementRepository;
import com.airTransport.atm_backend.service.AdminService;
import com.airTransport.atm_backend.service.Impl.CrewManagementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CrewManagementServiceImplTest {

    @Mock
    private CrewManagementRepository crewRepository;

    @Mock
    private AdminService adminService;

    @InjectMocks
    private CrewManagementServiceImpl crewService;

    private CrewManagement crew;
    private CrewManagementDTO crewDTO;

    @BeforeEach
    void setUp() {
        crew = new CrewManagement();
        crew.setId(1L);
        crew.setName("John Doe");
        crew.setRole(Role.PILOT);
        crew.setAvailability(true);

        crewDTO = new CrewManagementDTO();
        crewDTO.setId(1L);
        crewDTO.setName("John Doe");
        crewDTO.setRole(Role.PILOT);
        crewDTO.setAvailability(true);
        crewDTO.setAdminId(1L);
    }

//    @Test
//    void testAddCrewMember() {
//        Admin admin = new Admin();
//        admin.setId(1L);
//
//        when(adminService.getAdminById(1L)).thenReturn(admin);
//        when(crewRepository.save(any())).thenReturn(crew);
//
//        CrewManagementDTO savedCrewDTO = crewService.addCrewMember(crewDTO);
//        assertEquals("John Doe", savedCrewDTO.getName());
//    }
//
//    @Test
//    void testGetCrewMemberById() {
//        when(crewRepository.findById(1L)).thenReturn(Optional.of(crew));
//
//        CrewManagementDTO foundCrew = crewService.getCrewMemberById(1L);
//        assertEquals("John Doe", foundCrew.getName());
//    }

    @Test
    void testDeleteCrewMember() {
        when(crewRepository.findById(1L)).thenReturn(Optional.of(crew));

        crewService.deleteCrewMember(1L);
        verify(crewRepository, times(1)).delete(crew);
    }
}
