package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.config.TestSecurityConfig;
import com.airTransport.atm_backend.dto.LoginDTO;
import com.airTransport.atm_backend.dto.UserDTO;
import com.airTransport.atm_backend.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@Import(TestSecurityConfig.class) // Import the security test configuration
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private UserDTO userDTO;
    private LoginDTO loginDTO;

    @BeforeEach
    void setUp() {
        userDTO = new UserDTO();
        userDTO.setUsername("testuser");
        userDTO.setEmail("testuser@example.com");
        userDTO.setPassword("password123");

        loginDTO = new LoginDTO();
        loginDTO.setEmail("testuser@example.com");
        loginDTO.setPassword("password123");
    }

    @Test
    @WithMockUser
    void shouldRegisterUserSuccessfully() throws Exception {
        when(userService.registerUser(any(UserDTO.class))).thenReturn("User registered successfully!");

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"testuser\", \"email\":\"testuser@example.com\", \"password\":\"password123\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("User registered successfully!"));

        verify(userService, times(1)).registerUser(any(UserDTO.class));
    }

    @Test
    @WithMockUser
    void shouldLoginUserSuccessfully() throws Exception {
        when(userService.loginUser(any(LoginDTO.class))).thenReturn("Login successful!");

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"testuser@example.com\", \"password\":\"password123\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Login successful!"));

        verify(userService, times(1)).loginUser(any(LoginDTO.class));
    }

    @Test
    @WithMockUser
    void shouldReturnAllUsers() throws Exception {
        UserDTO anotherUser = new UserDTO();
        anotherUser.setUsername("anotheruser");
        anotherUser.setEmail("anotheruser@example.com");

        when(userService.getAllUsers()).thenReturn(java.util.Arrays.asList(userDTO, anotherUser));

        mockMvc.perform(get("/auth/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username").value("testuser"))
                .andExpect(jsonPath("$[1].username").value("anotheruser"));

        verify(userService, times(1)).getAllUsers();
    }

    @Test
    @WithMockUser
    void shouldLogoutUserSuccessfully() throws Exception {
        doNothing().when(userService).logout();

        mockMvc.perform(post("/auth/logout"))
                .andExpect(status().isOk())
                .andExpect(content().string("Logout successful!"));

        verify(userService, times(1)).logout();
    }

    @Test
    @WithMockUser
    void shouldReturnBadRequestOnInvalidLogin() throws Exception {
        when(userService.loginUser(any(LoginDTO.class))).thenThrow(new RuntimeException("Invalid email or password!"));

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"invaliduser@example.com\", \"password\":\"wrongpassword\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid email or password!"));
    }
}