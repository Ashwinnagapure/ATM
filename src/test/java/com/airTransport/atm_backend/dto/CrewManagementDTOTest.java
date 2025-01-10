package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrewManagementDTOTest {

    @Test
    void testCrewManagementDTOGettersAndSetters() {
        // Arrange
        CrewManagementDTO crewManagementDTO = new CrewManagementDTO();

        Long expectedId = 1L;
        String expectedName = "John Doe";
        String expectedRole = "Pilot";
        boolean expectedAvailability = true;
        Long expectedAdminId = 101L;

        // Act
        crewManagementDTO.setId(expectedId);
        crewManagementDTO.setName(expectedName);
        crewManagementDTO.setRole(expectedRole);
        crewManagementDTO.setAvailability(expectedAvailability);
        crewManagementDTO.setAdminId(expectedAdminId);

        // Assert
        assertEquals(expectedId, crewManagementDTO.getId());
        assertEquals(expectedName, crewManagementDTO.getName());
        assertEquals(expectedRole, crewManagementDTO.getRole());
        assertTrue(crewManagementDTO.isAvailability());
        assertEquals(expectedAdminId, crewManagementDTO.getAdminId());
    }

    @Test
    void testDefaultConstructor() {
        // Arrange & Act
        CrewManagementDTO crewManagementDTO = new CrewManagementDTO();

        // Assert
        assertNull(crewManagementDTO.getId());
        assertNull(crewManagementDTO.getName());
        assertNull(crewManagementDTO.getRole());
        assertFalse(crewManagementDTO.isAvailability());
        assertNull(crewManagementDTO.getAdminId());
    }
}
