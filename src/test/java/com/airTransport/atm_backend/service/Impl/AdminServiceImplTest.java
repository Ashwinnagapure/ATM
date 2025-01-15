package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.AdminDTO;
import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

public class AdminServiceImplTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminServiceImpl adminService;

    public AdminServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAdminById() {
        Admin admin = new Admin();
        admin.setId(1L);
        admin.setName("John Doe");

        when(adminRepository.findById(1L)).thenReturn(Optional.of(admin));

        Admin result = adminService.getAdminById(1L);
        assertEquals("John Doe", result.getName());
    }

    @Test
    void testCreateAdmin() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setName("John Doe");
        adminDTO.setEmail("john.doe@example.com");
        adminDTO.setPassword("password123");

        Admin admin = new Admin();
        admin.setId(1L);
        admin.setName("John Doe");

        when(adminRepository.save(any(Admin.class))).thenReturn(admin);

        Admin result = adminService.createAdmin(adminDTO);
        assertEquals("John Doe", result.getName());
    }
}