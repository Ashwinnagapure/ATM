package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginDTOTest {

    private LoginDTO loginDTO;

    @BeforeEach
    void setUp() {
        loginDTO = new LoginDTO();
        loginDTO.setUsername("testUser");
        loginDTO.setPassword("testPassword123");
        loginDTO.setEmail("testuser@example.com");
    }

    @AfterEach
    void tearDown() {
        loginDTO = null;
    }

    @Test
    void getUsername() {
        assertEquals("testUser", loginDTO.getUsername());
    }

    @Test
    void setUsername() {
        loginDTO.setUsername("newUser");
        assertEquals("newUser", loginDTO.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("testPassword123", loginDTO.getPassword());
    }

    @Test
    void setPassword() {
        loginDTO.setPassword("newPassword456");
        assertEquals("newPassword456", loginDTO.getPassword());
    }

    @Test
    void getEmail() {
        assertEquals("testuser@example.com", loginDTO.getEmail());
    }

    @Test
    void setEmail() {
        loginDTO.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", loginDTO.getEmail());
    }
}
