package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        User user = new User();
        user.setUsername("john_doe");
        user.setEmail("john@example.com");
        user.setPassword("password");

        User savedUser = userRepository.save(user);

        Assertions.assertNotNull(savedUser.getId());
        Assertions.assertEquals("john_doe", savedUser.getUsername());
        Assertions.assertEquals("john@example.com", savedUser.getEmail());
    }

    @Test
    void testFindByEmail() {
        User user = new User();
        user.setUsername("jane_doe");
        user.setEmail("jane@example.com");
        user.setPassword("password");
        userRepository.save(user);

        User foundUser = userRepository.findByEmail("jane@example.com");
        Assertions.assertNotNull(foundUser);
        Assertions.assertEquals("jane_doe", foundUser.getUsername());
    }

    @Test
    void testExistsByEmail() {
        User user = new User();
        user.setUsername("john_doe");
        user.setEmail("john@example.com");
        user.setPassword("password");
        userRepository.save(user);

        boolean exists = userRepository.existsByEmail("john@example.com");
        Assertions.assertTrue(exists);
    }

    @Test
    void testExistsByUsername() {
        User user = new User();
        user.setUsername("john_doe");
        user.setEmail("john@example.com");
        user.setPassword("password");
        userRepository.save(user);

        boolean exists = userRepository.existsByUsername("john_doe");
        Assertions.assertTrue(exists);
    }

    @Test
    void testFindById() {
        User user = new User();
        user.setUsername("john_doe");
        user.setEmail("john@example.com");
        user.setPassword("password");
        User savedUser = userRepository.save(user);

        User foundUser = userRepository.findById(savedUser.getId()).orElse(null);
        Assertions.assertNotNull(foundUser);
        Assertions.assertEquals("john_doe", foundUser.getUsername());
    }
}
