package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.controller.UserController;
import com.airTransport.atm_backend.dto.LoginDTO;
import com.airTransport.atm_backend.dto.UserDTO;
import com.airTransport.atm_backend.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        // Arrange
        List<UserDTO> mockUsers = new ArrayList<>();
        UserDTO user1 = new UserDTO();
        user1.setId(1L);
        user1.setUsername("JohnDoe");
        user1.setEmail("john.doe@example.com");
        user1.setPassword("password123");
        user1.setRole("USER");

        UserDTO user2 = new UserDTO();
        user2.setId(2L);
        user2.setUsername("JaneDoe");
        user2.setEmail("jane.doe@example.com");
        user2.setPassword("password456");
        user2.setRole("ADMIN");

        mockUsers.add(user1);
        mockUsers.add(user2);

        when(userService.getAllUsers()).thenReturn(mockUsers);

        // Act
        List<UserDTO> users = userController.getAllUsers();

        // Assert
        assertEquals(2, users.size());
        assertEquals("JohnDoe", users.get(0).getUsername());
        assertEquals("JaneDoe", users.get(1).getUsername());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testRegisterUser() {
        // Arrange
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("NewUser");
        userDTO.setEmail("new.user@example.com");
        userDTO.setPassword("password789");
        userDTO.setRole("USER");

        when(userService.registerUser(userDTO)).thenReturn("Registration successful");

        // Act
        ResponseEntity<String> response = userController.registerUser(userDTO);

        // Assert
        assertEquals("Registration successful", response.getBody());
        verify(userService, times(1)).registerUser(userDTO);
    }

    @Test
    void testLoginUser() {
        // Arrange
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("login.user@example.com");
        loginDTO.setPassword("password123");

        when(userService.loginUser(loginDTO)).thenReturn("Login successful");

        // Act
        ResponseEntity<String> response = userController.loginUser(loginDTO);

        // Assert
        assertEquals("Login successful", response.getBody());
        verify(userService, times(1)).loginUser(loginDTO);
    }

    @Test
    void testLogoutUser() {
        // Arrange
        doNothing().when(userService).logout();

        // Act
        ResponseEntity<String> response = userController.logoutUser();

        // Assert
        assertEquals("Logout successful!", response.getBody());
        verify(userService, times(1)).logout();
    }
}
