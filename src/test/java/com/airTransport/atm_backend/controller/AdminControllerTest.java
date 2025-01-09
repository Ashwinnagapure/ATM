package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.service.AdminService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdminControllerTest {

    @InjectMocks
    private AdminController adminController;

    @Mock
    private AdminService adminService;

    private AutoCloseable closeable;
    private Admin admin;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        admin = new Admin();
        admin.setId(1L);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void getAdminById() {
        when(adminService.getAdminById(1L)).thenReturn(admin);
        Admin result = adminController.getAdminById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(adminService, times(1)).getAdminById(1L);
    }

    @Test
    void getAllAdmins() {
        List<Admin> adminList = new ArrayList<>();
        adminList.add(admin);
        when(adminService.getAllAdmins()).thenReturn(adminList);

        List<Admin> result = adminController.getAllAdmins();
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(adminService, times(1)).getAllAdmins();
    }

    @Test
    void createAdmin() {
        doAnswer(invocation -> {
            Admin adminToSave = invocation.getArgument(0);
            assertNotNull(adminToSave);
            assertEquals(1L, adminToSave.getId());
            return null;
        }).when(adminService).createAdmin(any(Admin.class));

        String result = adminController.createAdmin(admin);
        assertEquals("Admin created", result);
        verify(adminService, times(1)).createAdmin(admin);
    }

    @Test
    void updateAdmin() {
        doAnswer(invocation -> {
            Admin adminToUpdate = invocation.getArgument(0);
            assertNotNull(adminToUpdate);
            assertEquals(1L, adminToUpdate.getId());
            return null;
        }).when(adminService).updateAdmin(any(Admin.class));

        String result = adminController.updateAdmin(admin);
        assertEquals("Admin updated", result);
        verify(adminService, times(1)).updateAdmin(admin);
    }

    @Test
    void deleteAdmin() {
        doAnswer(invocation -> {
            Long adminIdToDelete = invocation.getArgument(0);
            assertNotNull(adminIdToDelete);
            assertEquals(1L, adminIdToDelete);
            return null;
        }).when(adminService).deleteAdmin(anyLong());

        String result = adminController.deleteAdmin(1L);
        assertEquals("Admin deleted", result);
        verify(adminService, times(1)).deleteAdmin(1L);
    }

}
