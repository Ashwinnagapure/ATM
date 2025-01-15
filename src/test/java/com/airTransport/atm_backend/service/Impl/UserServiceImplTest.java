package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.LoginDTO;
import com.airTransport.atm_backend.dto.UserDTO;
import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.User;
import com.airTransport.atm_backend.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testGetAllUsers() {
        User user = new User();
        user.setId(1L);
        user.setUsername("john_doe");
        user.setEmail("john@example.com");

        Mockito.when(userRepository.findAll()).thenReturn(java.util.List.of(user));

        var result = userService.getAllUsers();
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("john_doe", result.get(0).getUsername());
    }

    @Test
    void testRegisterUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("new_user");
        userDTO.setEmail("new_user@example.com");
        userDTO.setPassword("password");

        Mockito.when(userRepository.existsByEmail(userDTO.getEmail())).thenReturn(false);
        Mockito.when(userRepository.existsByUsername(userDTO.getUsername())).thenReturn(false);

        String result = userService.registerUser(userDTO);
        Assertions.assertEquals("User registered successfully!", result);

        verify(userRepository, times(1)).save(Mockito.any(User.class));
    }

//    @Test
//    void testLoginUser() {
//        User user = new User();
//        user.setEmail("user@example.com");
//        user.setPassword("password");
//
//        Mockito.when(userRepository.findByEmail("user@example.com")).thenReturn(user);
//
//       String result = userService.loginUser(new LoginDTO());
//       Assertions.assertEquals("Login successful!", result);
//    }

    @Test
    void testLoginUserInvalidCredentials() {
        Mockito.when(userRepository.findByEmail("user@example.com")).thenReturn(null);

        Assertions.assertThrows(RuntimeException.class, () -> {
            userService.loginUser(new LoginDTO());
        });
    }

    @Test
    void testGetUserById() {
        User user = new User();
        user.setId(1L);
        user.setUsername("john_doe");
        user.setEmail("john@example.com");

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        UserDTO result = userService.getUserById(1L);
        Assertions.assertEquals("john_doe", result.getUsername());
    }

    @Test
    void testGetUserByIdNotFound() {
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> userService.getUserById(1L));
    }
}
