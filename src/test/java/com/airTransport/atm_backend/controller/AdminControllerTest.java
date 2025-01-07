package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(AdminController.class)
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService adminService;

    private Admin adminOne;
    private Admin adminTwo;

    @BeforeEach
    void setUp() {

//        mockMvc = MockMvcBuilders.standaloneSetup(new AdminController(adminService))
//                .apply(springSecurity())
//                .build();
//
        adminOne = new Admin();
        adminOne.setUserId(1L);
        adminOne.setUsername("adminUser");
        adminOne.setEmail("admin@example.com");
        adminOne.setPassword("securePassword123");
        adminOne.setRole("ADMIN");

        adminTwo = new Admin();
        adminTwo.setUserId(1L);
        adminTwo.setUsername("adminUser");
        adminTwo.setEmail("admin@example.com");
        adminTwo.setPassword("securePassword123");
        adminTwo.setRole("ADMIN");

    }

    @Test
    void getAdminById_ValidId_ReturnsAdmin() throws Exception {
        Mockito.when(adminService.getAdminById(1L)).thenReturn(adminOne);

        mockMvc.perform(get("/admin/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId", is(1)))
                .andExpect(jsonPath("$.username", is("adminUser")))
                .andExpect(jsonPath("$.email", is("admin@example.com")))
                .andExpect(jsonPath("$.role", is("ADMIN")));
    }

    @Test
    void getAdminById_InvalidId_ReturnsNotFound() throws Exception {
        Mockito.when(adminService.getAdminById(999L)).thenThrow(new RuntimeException("Admin not found"));

        mockMvc.perform(get("/admin/{id}", 999L))
                .andExpect(status().isNotFound());
    }

    @Test
    void getAllAdmins_ReturnsListOfAdmins() throws Exception {
        List<Admin> admins = Arrays.asList(adminOne, adminTwo);
        Mockito.when(adminService.getAllAdmins()).thenReturn(admins);

        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].userId", is(1)))
                .andExpect(jsonPath("$[0].username", is("adminUser")))
                .andExpect(jsonPath("$[1].userId", is(2)))
                .andExpect(jsonPath("$[1].username", is("adminUser2")));
    }

    @Test
    void getAllAdmins_ReturnsEmptyList() throws Exception {
        Mockito.when(adminService.getAllAdmins()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void createAdmin_ValidInput_ReturnsSuccessMessage() throws Exception {
        // Mocking the service response
        Mockito.when(adminService.createAdmin(any(Admin.class))).thenReturn("Admin created");

        // Perform the request with Basic Authentication
        mockMvc.perform(post("/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"username\": \"newAdmin\", " +
                                "\"email\": \"newadmin@example.com\", " +
                                "\"password\": \"password123\", " +
                                "\"role\": \"ADMIN\"}")
                        .with(httpBasic("adminair", "alpha")) // Add your credentials here
                        .with(csrf())) // CSRF token included
                .andExpect(status().isOk())
                .andExpect(content().string("Admin created"));
    }


    @Test
    void updateAdmin_ValidInput_ReturnsSuccessMessage() throws Exception {

        Mockito.when(adminService.createAdmin(any(Admin.class))).thenReturn("Admin updated");
        mockMvc.perform(put("/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"userId\": 1, " +
                                "\"username\": \"updatedAdmin\", " +
                                "\"email\": \"updated@example.com\", " +
                                "\"password\": \"newPassword123\", " +
                                "\"role\": \"ADMIN\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Admin updated"));
    }

    @Test
    void deleteAdmin_ValidId_ReturnsSuccessMessage() throws Exception {
        Mockito.when(adminService.createAdmin(any(Admin.class))).thenReturn("Admin deleted");

        mockMvc.perform(delete("/admin/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().string("Admin deleted"));
    }

    @Test
    void deleteAdmin_InvalidId_ReturnsNotFound() throws Exception {
        Mockito.doThrow(new RuntimeException("Admin not found")).when(adminService).deleteAdmin(999L);

        mockMvc.perform(delete("/admin/{id}", 999L))
                .andExpect(status().isNotFound());
    }
}
