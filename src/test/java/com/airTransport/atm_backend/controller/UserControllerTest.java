//package com.airTransport.atm_backend.controller;
//
//import com.airTransport.atm_backend.dto.LoginDTO;
//import com.airTransport.atm_backend.dto.UserDTO;
//import com.airTransport.atm_backend.service.UserService;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//
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
//    @Test
//    void testGetAllUsers() throws Exception {
//        UserDTO user1 = new UserDTO();
//        user1.setId(1L);
//        user1.setUsername("john_doe");
//        user1.setEmail("john@example.com");
//
//        UserDTO user2 = new UserDTO();
//        user2.setId(2L);
//        user2.setUsername("jane_doe");
//        user2.setEmail("jane@example.com");
//
//        Mockito.when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));
//
//        mockMvc.perform(get("/auth/all"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].username").value("john_doe"))
//                .andExpect(jsonPath("$[1].username").value("jane_doe"));
//    }
//
//    @Test
//    void testRegisterUser() throws Exception {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUsername("new_user");
//        userDTO.setEmail("new_user@example.com");
//        userDTO.setPassword("password");
//
//        Mockito.when(userService.registerUser(Mockito.any(UserDTO.class)))
//                .thenReturn("User registered successfully!");
//
//        mockMvc.perform(post("/auth/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"username\":\"new_user\",\"email\":\"new_user@example.com\",\"password\":\"password\"}"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("User registered successfully!"));
//    }
//
//    @Test
//    void testLoginUser() throws Exception {
//        LoginDTO loginDTO = new LoginDTO();
//        loginDTO.setEmail("user@example.com");
//        loginDTO.setPassword("password");
//
//        Mockito.when(userService.loginUser(Mockito.any(LoginDTO.class)))
//                .thenReturn("Login successful!");
//
//        mockMvc.perform(post("/auth/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"email\":\"user@example.com\",\"password\":\"password\"}"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Login successful!"));
//    }
//
//    @Test
//    void testLogoutUser() throws Exception {
//        mockMvc.perform(post("/auth/logout"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Logout successful!"));
//    }
//
//    @Test
//    void testGetUserById() throws Exception {
//        UserDTO user = new UserDTO();
//        user.setId(1L);
//        user.setUsername("john_doe");
//        user.setEmail("john@example.com");
//
//        Mockito.when(userService.getUserById(1L)).thenReturn(user);
//
//        mockMvc.perform(get("/auth/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.username").value("john_doe"));
//    }
//}
