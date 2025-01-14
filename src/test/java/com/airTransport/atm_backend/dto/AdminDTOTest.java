package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdminDTOTest {

    @Test
    void testAdminDTO() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setName("John Doe");
        adminDTO.setEmail("john.doe@example.com");
        adminDTO.setPassword("password123");

        assertEquals("John Doe", adminDTO.getName());
        assertEquals("john.doe@example.com", adminDTO.getEmail());
        assertEquals("password123", adminDTO.getPassword());
    }
}