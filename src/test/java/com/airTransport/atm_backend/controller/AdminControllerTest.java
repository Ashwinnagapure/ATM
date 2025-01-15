package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AdminController.class)
@WithMockUser(username = "admin", roles = {"ADMIN"}) // Mock authenticated user
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService adminService;

//    @Test
//    void testGetAdminById() throws Exception {
//        Admin admin = new Admin();
//        admin.setId(1L);
//        admin.setName("John Doe");
//        admin.setEmail("john.doe@example.com");
//        admin.setPassword("password123");
//
//        when(adminService.getAdminById(1L)).thenReturn(admin);
//
//        mockMvc.perform(get("/admins/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L))
//                .andExpect(jsonPath("$.name").value("John Doe"))
//                .andExpect(jsonPath("$.email").value("john.doe@example.com"));
//    }

    @Test
    void testGetAllAdmins() throws Exception {
        Admin admin1 = new Admin();
        admin1.setId(1L);
        admin1.setName("John Doe");
        admin1.setEmail("john.doe@example.com");

        Admin admin2 = new Admin();
        admin2.setId(2L);
        admin2.setName("Jane Smith");
        admin2.setEmail("jane.smith@example.com");

        List<Admin> admins = Arrays.asList(admin1, admin2);
        when(adminService.getAllAdmins()).thenReturn(admins);

        mockMvc.perform(get("/admins/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[0].email").value("john.doe@example.com"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("Jane Smith"))
                .andExpect(jsonPath("$[1].email").value("jane.smith@example.com"));
    }

//    @Test
//    void testCreateAdmin() throws Exception {
//        AdminDTO adminDTO = new AdminDTO();
//        adminDTO.setName("John Doe");
//        adminDTO.setEmail("john.doe@example.com");
//        adminDTO.setPassword("password123");
//
//        Admin admin = new Admin();
//        admin.setId(1L);
//        admin.setName("John Doe");
//        admin.setEmail("john.doe@example.com");
//        admin.setPassword("password123");
//
//        when(adminService.createAdmin(any(AdminDTO.class))).thenReturn(admin);
//
//        mockMvc.perform(post("/admins")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"name\":\"John Doe\",\"email\":\"john.doe@example.com\",\"password\":\"password123\"}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L))
//                .andExpect(jsonPath("$.name").value("John Doe"))
//                .andExpect(jsonPath("$.email").value("john.doe@example.com"));
//    }
}