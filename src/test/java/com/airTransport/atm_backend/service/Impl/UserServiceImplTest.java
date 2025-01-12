package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.LoginDTO;
import com.airTransport.atm_backend.dto.UserDTO;
import com.airTransport.atm_backend.model.User;
import com.airTransport.atm_backend.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    private UserDTO userDTO;
    private LoginDTO loginDTO;
    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize test data
        userDTO = new UserDTO();
        userDTO.setUsername("testUser");
        userDTO.setEmail("testUser@example.com");
        userDTO.setPassword("password123");

        loginDTO = new LoginDTO();
        loginDTO.setEmail("testUser@example.com");
        loginDTO.setPassword("password123");

        user = new User("testUser", "testUser@example.com", "password123");
    }

    @AfterEach
    void tearDown() {
    }

//    @Test
//    void getAllUsers() {
//        when(userRepository.findAll()).thenReturn(List<User> list);
//
//        assertEquals(1, userService.getAllUsers().size());
//        verify(userRepository, times(1)).findAll();
//    }

    @Test
    void registerUser_UserAlreadyExists() {
        when(userRepository.existsByEmail(userDTO.getEmail())).thenReturn(true);

        assertEquals("false", userService.registerUser(userDTO));
        verify(userRepository, times(1)).existsByEmail(userDTO.getEmail());
    }

    @Test
    void registerUser_Success() {
        when(userRepository.existsByEmail(userDTO.getEmail())).thenReturn(false);
        when(userRepository.existsByUsername(userDTO.getUsername())).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(user);

        assertEquals("true", userService.registerUser(userDTO));
        verify(userRepository, times(1)).existsByEmail(userDTO.getEmail());
        verify(userRepository, times(1)).existsByUsername(userDTO.getUsername());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void loginUser_Success() {
        when(userRepository.findByEmail(loginDTO.getEmail())).thenReturn(user);

        assertEquals("true", userService.loginUser(loginDTO));
        verify(userRepository, times(1)).findByEmail(loginDTO.getEmail());
    }

    @Test
    void loginUser_Failure() {
        when(userRepository.findByEmail(loginDTO.getEmail())).thenReturn(null);

        assertEquals("false", userService.loginUser(loginDTO));
        verify(userRepository, times(1)).findByEmail(loginDTO.getEmail());
    }

    @Test
    void logout() {
        userService.logout();
        // You can add verification here if necessary
        assertTrue(true);  // Just ensuring the method is called
    }
}
