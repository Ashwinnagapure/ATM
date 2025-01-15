//package com.airTransport.atm_backend.controller;
//
//import com.airTransport.atm_backend.dto.LoginDTO;
//import com.airTransport.atm_backend.dto.UserDTO;
//import com.airTransport.atm_backend.service.UserService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(UserController.class)
//public class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private UserDTO userDTO;
//    private LoginDTO loginDTO;
//
//    @BeforeEach
//    void setUp() {
//        userDTO = new UserDTO();
//        userDTO.setId(1L);
//        userDTO.setUsername("JohnDoe");
//        userDTO.setEmail("johndoe@example.com");
//        userDTO.setPassword("password123");
//        userDTO.setRole("USER");
//
//        loginDTO = new LoginDTO();
//        loginDTO.setEmail("johndoe@example.com");
//        loginDTO.setPassword("password123");
//    }
//
//    @Test
//    void testGetAllUsers() throws Exception {
//        List<UserDTO> users = Arrays.asList(userDTO, userDTO);
//        Mockito.when(userService.getAllUsers()).thenReturn(users);
//
//        mockMvc.perform(get("/auth/all"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.size()").value(users.size()))
//                .andExpect(jsonPath("$[0].username").value(userDTO.getUsername()))
//                .andExpect(jsonPath("$[0].email").value(userDTO.getEmail()));
//    }
//
//    @Test
//    void testRegisterUser() throws Exception {
//        Mockito.when(userService.registerUser(any(UserDTO.class)))
//                .thenReturn("User registered successfully!");
//
//        mockMvc.perform(post("/auth/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(userDTO)))
//                .andExpect(status().isOk())
//                .andExpect(content().string("User registered successfully!"));
//    }
//
//    @Test
//    void testRegisterUserWithExistingEmail() throws Exception {
//        Mockito.when(userService.registerUser(any(UserDTO.class)))
//                .thenThrow(new RuntimeException("Email is already taken!"));
//
//        mockMvc.perform(post("/auth/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(userDTO)))
//                .andExpect(status().is4xxClientError())
//                .andExpect(content().string("Email is already taken!"));
//    }
//
//    @Test
//    void testLoginUser() throws Exception {
//        Mockito.when(userService.loginUser(any(LoginDTO.class)))
//                .thenReturn("Login successful!");
//
//        mockMvc.perform(post("/auth/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(loginDTO)))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Login successful!"));
//    }
//
//    @Test
//    void testLoginUserInvalidCredentials() throws Exception {
//        Mockito.when(userService.loginUser(any(LoginDTO.class)))
//                .thenThrow(new RuntimeException("Invalid email or password!"));
//
//        mockMvc.perform(post("/auth/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(loginDTO)))
//                .andExpect(status().is4xxClientError())
//                .andExpect(content().string("Invalid email or password!"));
//    }
//
//    @Test
//    void testLogoutUser() throws Exception {
//        mockMvc.perform(post("/auth/logout"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Logout successful!"));
//    }
//}
