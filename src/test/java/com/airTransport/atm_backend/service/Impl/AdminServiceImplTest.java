package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.repository.AdminRepository;
import com.airTransport.atm_backend.repository.AdminRepositoryTest;
import com.airTransport.atm_backend.service.AdminService;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AdminServiceImplTest {

    @Mock
    private AdminRepository adminRepository;
    private AdminService adminService;
    AutoCloseable autoCloseable;

    Admin admin;

    @BeforeEach
    void setUp() {
autoCloseable = MockitoAnnotations.openMocks(this);
adminService = new AdminServiceImpl(adminRepository);
admin = new Admin();
            admin.setUserId(1L);
            admin.setUsername("adminUser");
            admin.setEmail("admin@example.com");
            admin.setPassword("securePassword123");
            admin.setRole("ADMIN");

        }

    @AfterEach
    void tearDown() throws Exception {




        autoCloseable.close();

    }

    @Test
    void getAdminById() {



       Mockito.when(adminRepository.findById(1L)).thenReturn(Optional.ofNullable(admin));
       Admin result = adminService.getAdminById(1L);
     Mockito.verify(adminRepository).findById(1L);

        Assertions.assertNotNull(result);
     Assertions.assertEquals(admin.getUserId(),result.getUserId());
     Assertions.assertEquals(admin.getEmail(), result.getEmail());
     Assertions.assertEquals(admin.getPassword(), result.getPassword());
     Assertions.assertEquals(admin.getRole(), result.getRole());
     Assertions.assertEquals(admin.getUsername(),result.getUsername());


    }

    @Test
    void getAllAdmins() {

            // Prepare a mock list of admins
            List<Admin> admins = List.of(admin);

            // Mock the behavior of adminRepository.findAll()
            Mockito.when(adminRepository.findAll()).thenReturn(admins);

            // Call the service method
            List<Admin> result = adminService.getAllAdmins();

            // Verify that the repository's findAll method was called
            Mockito.verify(adminRepository).findAll();

            // Assertions to ensure the result is as expected
            Assertions.assertNotNull(result);
            Assertions.assertEquals(1, result.size()); // Verify the list contains one admin
            Admin retrievedAdmin = result.get(0);
            Assertions.assertEquals(admin.getUserId(), retrievedAdmin.getUserId());
            Assertions.assertEquals(admin.getEmail(), retrievedAdmin.getEmail());
            Assertions.assertEquals(admin.getPassword(), retrievedAdmin.getPassword());
            Assertions.assertEquals(admin.getRole(), retrievedAdmin.getRole());
            Assertions.assertEquals(admin.getUsername(), retrievedAdmin.getUsername());
        }

    @Test
    void createAdmin() {


            Mockito.when(adminRepository.save(admin)).thenReturn(admin); // Mock the save behavior

            String result = adminService.createAdmin(admin); // Call the service method

            Mockito.verify(adminRepository).save(admin); // Verify that the save method was called
            Assertions.assertEquals("Admin created", result); // Assert the returned message matches
        }

    @Test
    void updateAdmin() {

        Mockito.when(adminRepository.save(admin)).thenReturn(admin); // Mock the save behavior

        String result = adminService.updateAdmin(admin); // Call the service method

        Mockito.verify(adminRepository).save(admin); // Verify that the save method was called
        Assertions.assertEquals("Admin updated", result);


    }

    @Test
    void deleteAdmin() {
        // Mock the adminRepository's behavior
        Long adminId = 1L;

        // Call the service method
        adminService.deleteAdmin(adminId);

        // Verify that the repository's deleteById method was called with the correct ID
        Mockito.verify(adminRepository).deleteById(adminId);
    }
    @Test
    void getAdminById_AdminNotFound() {
        Long invalidId = 999L;
        Mockito.when(adminRepository.findById(invalidId)).thenReturn(Optional.empty());
        Assertions.assertThrows(RuntimeException.class, () -> adminService.getAdminById(invalidId));
        Mockito.verify(adminRepository).findById(invalidId);
    }

    @Test
    void getAdminById_NullId() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> adminService.getAdminById(null));
    }

    @Test
    void getAdminById_RepositoryException() {
        Long validId = 1L;
        Mockito.when(adminRepository.findById(validId)).thenThrow(new RuntimeException("Database error"));
        Assertions.assertThrows(RuntimeException.class, () -> adminService.getAdminById(validId));
    }
    @Test
    void getAllAdmins_NoAdmins() {
        Mockito.when(adminRepository.findAll()).thenReturn(List.of());
        List<Admin> result = adminService.getAllAdmins();
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void getAllAdmins_RepositoryException() {
        Mockito.when(adminRepository.findAll()).thenThrow(new RuntimeException("Database error"));
        Assertions.assertThrows(RuntimeException.class, () -> adminService.getAllAdmins());
    }
    @Test
    void deleteAdmin_AdminNotFound() {
        Long invalidId = 999L;
        Mockito.doThrow(new RuntimeException("Admin not found")).when(adminRepository).deleteById(invalidId);
        Assertions.assertThrows(RuntimeException.class, () -> adminService.deleteAdmin(invalidId));
        Mockito.verify(adminRepository).deleteById(invalidId);
    }

    @Test
    void deleteAdmin_NullId() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> adminService.deleteAdmin(null));
    }

    @Test
    void deleteAdmin_InvalidId() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> adminService.deleteAdmin(-1L));
    }

    @Test
    void deleteAdmin_RepositoryException() {
        Long validId = 1L;
        Mockito.doThrow(new RuntimeException("Database error")).when(adminRepository).deleteById(validId);
        Assertions.assertThrows(RuntimeException.class, () -> adminService.deleteAdmin(validId));
    }


}