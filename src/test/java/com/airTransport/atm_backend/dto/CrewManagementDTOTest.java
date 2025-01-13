package com.airTransport.atm_backend.dto;

import com.airTransport.atm_backend.dto.CrewManagementDTO;
import com.airTransport.atm_backend.model.enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CrewManagementDTOTest {

    private CrewManagementDTO crewManagementDTO;

    @BeforeEach
    void setUp() {
        crewManagementDTO = new CrewManagementDTO();
        crewManagementDTO.setId(1L);
        crewManagementDTO.setName("John Doe");
        crewManagementDTO.setRole(Role.PILOT);
        crewManagementDTO.setAvailability(true);
        crewManagementDTO.setAdminId(1L);
    }

    @Test
    void testGetId() {
        assertEquals(1L, crewManagementDTO.getId());
    }

    @Test
    void testSetId() {
        crewManagementDTO.setId(2L);
        assertEquals(2L, crewManagementDTO.getId());
    }

    @Test
    void testGetName() {
        assertEquals("John Doe", crewManagementDTO.getName());
    }

    @Test
    void testSetName() {
        crewManagementDTO.setName("Jane Doe");
        assertEquals("Jane Doe", crewManagementDTO.getName());
    }

    @Test
    void testGetRole() {
        assertEquals(Role.PILOT, crewManagementDTO.getRole());
    }

//    @Test
//    void testSetRole() {
//        crewManagementDTO.setRole(Role.CREW_MEMBER);
//        assertEquals(Role.CREW_MEMBER, crewManagementDTO.getRole());
//    }

    @Test
    void testGetAvailability() {
        assertTrue(crewManagementDTO.isAvailability());
    }

    @Test
    void testSetAvailability() {
        crewManagementDTO.setAvailability(false);
        assertFalse(crewManagementDTO.isAvailability());
    }

    @Test
    void testGetAdminId() {
        assertEquals(1L, crewManagementDTO.getAdminId());
    }

    @Test
    void testSetAdminId() {
        crewManagementDTO.setAdminId(2L);
        assertEquals(2L, crewManagementDTO.getAdminId());
    }
}
