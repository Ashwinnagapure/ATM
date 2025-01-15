package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AdminRepositoryTest {

    @Autowired
    private AdminRepository adminRepository;

    @Test
    void testSaveAdmin() {
        Admin admin = new Admin();
        admin.setName("John Doe");
        admin.setEmail("john.doe@example.com");
        admin.setPassword("password123");

        Admin savedAdmin = adminRepository.save(admin);
        assertNotNull(savedAdmin.getId());
        assertEquals("John Doe", savedAdmin.getName());
    }
}