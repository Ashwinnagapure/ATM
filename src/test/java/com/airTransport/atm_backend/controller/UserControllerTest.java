package com.airTransport.atm_backend.controller;

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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class UserControllerTest {

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
        List<UserDTO> mockUsers = new ArrayList<>();
        mockUsers.add(new UserDTO());
        when(userService.getAllUsers()).thenReturn(mockUsers);

        List<UserDTO> result = userController.getAllUsers();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testGetAllUsers_EmptyList() {
        when(userService.getAllUsers()).thenReturn(new ArrayList<>());

        List<UserDTO> result = userController.getAllUsers();

        assertNotNull(result);
        assertEquals(0, result.size());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testRegisterUser() {
        // Arrange
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("testUser");
        String mockResponse = "Registration successful";
        when(userService.registerUser(userDTO)).thenReturn(mockResponse);

        ResponseEntity<String> response = userController.registerUser(userDTO);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockResponse, response.getBody());
        verify(userService, times(1)).registerUser(userDTO);
    }

    @Test
    void testLoginUser() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("test@example.com");
        loginDTO.setPassword("password123");
        String mockResponse = "Login successful";
        when(userService.loginUser(loginDTO)).thenReturn(mockResponse);

        ResponseEntity<String> response = userController.loginUser(loginDTO);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockResponse, response.getBody());
        verify(userService, times(1)).loginUser(loginDTO);
    }

    @Test
    void testLogoutUser() {
        doNothing().when(userService).logout();

        ResponseEntity<String> response = userController.logoutUser();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Logout successful!", response.getBody());
        verify(userService, times(1)).logout();
    }

    @Test
    void testRegisterUser_Exception() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("testUser");
        when(userService.registerUser(userDTO)).thenThrow(new RuntimeException("Error during registration"));

        try {
            userController.registerUser(userDTO);
        } catch (Exception e) {
            assertEquals("Error during registration", e.getMessage());
        }
        verify(userService, times(1)).registerUser(userDTO);
    }

    @Test
    void testLoginUser_Exception() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("test@example.com");
        loginDTO.setPassword("password123");
        when(userService.loginUser(loginDTO)).thenThrow(new RuntimeException("Invalid credentials"));

        try {
            userController.loginUser(loginDTO);
        } catch (Exception e) {
            assertEquals("Invalid credentials", e.getMessage());
        }
        verify(userService, times(1)).loginUser(loginDTO);
    }
}
