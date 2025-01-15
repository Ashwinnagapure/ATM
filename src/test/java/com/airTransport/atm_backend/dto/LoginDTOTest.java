package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginDTOTest {

    @Test
    void testSetAndGetUsername() {
        // Arrange
        LoginDTO loginDTO = new LoginDTO();
        String username = "JohnDoe";

        // Act
        loginDTO.setUsername(username);

        // Assert
        assertEquals(username, loginDTO.getUsername(), "The username should be set and retrieved correctly.");
    }

    @Test
    void testSetAndGetPassword() {
        // Arrange
        LoginDTO loginDTO = new LoginDTO();
        String password = "password123";

        // Act
        loginDTO.setPassword(password);

        // Assert
        assertEquals(password, loginDTO.getPassword(), "The password should be set and retrieved correctly.");
    }

    @Test
    void testSetAndGetEmail() {
        // Arrange
        LoginDTO loginDTO = new LoginDTO();
        String email = "johndoe@example.com";

        // Act
        loginDTO.setEmail(email);

        // Assert
        assertEquals(email, loginDTO.getEmail(), "The email should be set and retrieved correctly.");
    }

    @Test
    void testLoginDTOInitialization() {
        // Arrange & Act
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername("JohnDoe");
        loginDTO.setPassword("password123");
        loginDTO.setEmail("johndoe@example.com");

        // Assert
        assertEquals("JohnDoe", loginDTO.getUsername(), "The username should match the initialized value.");
        assertEquals("password123", loginDTO.getPassword(), "The password should match the initialized value.");
        assertEquals("johndoe@example.com", loginDTO.getEmail(), "The email should match the initialized value.");
    }

    @Test
    void testEmptyLoginDTO() {
        // Arrange & Act
        LoginDTO loginDTO = new LoginDTO();

        // Assert
        assertNull(loginDTO.getUsername(), "The username should be null initially.");
        assertNull(loginDTO.getPassword(), "The password should be null initially.");
        assertNull(loginDTO.getEmail(), "The email should be null initially.");
    }
}
