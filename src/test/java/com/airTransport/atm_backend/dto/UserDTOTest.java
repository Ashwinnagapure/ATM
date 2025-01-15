package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserDTOTest {

    @Test
    void testUserDTOSettersAndGetters() {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(1L);
        userDTO.setUsername("john_doe");
        userDTO.setEmail("john@example.com");
        userDTO.setPassword("password");
        userDTO.setRole("ADMIN");

        Assertions.assertEquals(1L, userDTO.getId());
        Assertions.assertEquals("john_doe", userDTO.getUsername());
        Assertions.assertEquals("john@example.com", userDTO.getEmail());
        Assertions.assertEquals("password", userDTO.getPassword());
    }

//    @Test
//    void testUserDTOEquality() {
//        UserDTO user1 = new UserDTO();
//        user1.setId(1L);
//        user1.setUsername("john_doe");
//        user1.setEmail("john@example.com");
//        user1.setPassword("password");
//        user1.setRole("ADMIN");
//
//        UserDTO user2 = new UserDTO();
//        user2.setId(1L);
//        user2.setUsername("john_doe");
//        user2.setEmail("john@example.com");
//        user2.setPassword("password");
//        user2.setRole("ADMIN");
//
//        Assertions.assertEquals(user1, user2);
//        Assertions.assertEquals(user1.hashCode(), user2.hashCode());
//    }

    @Test
    void testUserDTODifferentObjects() {
        UserDTO user1 = new UserDTO();
        user1.setId(1L);
        user1.setUsername("john_doe");

        UserDTO user2 = new UserDTO();
        user2.setId(2L);
        user2.setUsername("jane_doe");

        Assertions.assertNotEquals(user1, user2);
    }
}
