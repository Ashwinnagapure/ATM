package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {

    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setUsername("testUser");
        userDTO.setEmail("testUser@example.com");
        userDTO.setPassword("password123");
        userDTO.setRole("ADMIN");
    }

    @AfterEach
    void tearDown() {
        userDTO = null;
    }

    @Test
    void getId() {
        assertEquals(1L, userDTO.getId());
    }

    @Test
    void setId() {
        userDTO.setId(2L);
        assertEquals(2L, userDTO.getId());
    }

    @Test
    void getUsername() {
        assertEquals("testUser", userDTO.getUsername());
    }

    @Test
    void setUsername() {
        userDTO.setUsername("newUser");
        assertEquals("newUser", userDTO.getUsername());
    }

    @Test
    void getEmail() {
        assertEquals("testUser@example.com", userDTO.getEmail());
    }

    @Test
    void setEmail() {
        userDTO.setEmail("newEmail@example.com");
        assertEquals("newEmail@example.com", userDTO.getEmail());
    }

    @Test
    void getPassword() {
        assertEquals("password123", userDTO.getPassword());
    }

    @Test
    void setPassword() {
        userDTO.setPassword("newPassword");
        assertEquals("newPassword", userDTO.getPassword());
    }
}
