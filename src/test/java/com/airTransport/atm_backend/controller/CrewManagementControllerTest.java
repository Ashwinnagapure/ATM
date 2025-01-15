package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.config.TestSecurityConfig;
import com.airTransport.atm_backend.dto.CrewManagementDTO;
import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.enums.Role;
import com.airTransport.atm_backend.service.CrewManagementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@Import(TestSecurityConfig.class)
@WebMvcTest(controllers = CrewManagementController.class, excludeAutoConfiguration = TestSecurityConfig.class)
public class CrewManagementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CrewManagementService crewManagementService;

    @Autowired
    private ObjectMapper objectMapper;

    private CrewManagementDTO crewManagementDTO;

    @BeforeEach
    void setUp() {
        Admin admin = new Admin();
        admin.setId(1L);
        admin.setName("Admin Test");

        crewManagementDTO = new CrewManagementDTO();
        crewManagementDTO.setName("John Doe");
        crewManagementDTO.setRole(Role.PILOT);
        crewManagementDTO.setAvailability(true);
        crewManagementDTO.setAdminId(admin.getId());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldAddCrewMemberSuccessfully() throws Exception {
        Mockito.when(crewManagementService.addCrewMember(any(CrewManagementDTO.class)))
                .thenReturn(crewManagementDTO);

        MvcResult result = mockMvc.perform(post("/crew-management")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(crewManagementDTO)))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains("John Doe"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldUpdateCrewMemberSuccessfully() throws Exception {
        Mockito.when(crewManagementService.updateCrewMember(any(Long.class), any(CrewManagementDTO.class)))
                .thenReturn(crewManagementDTO);

        MvcResult result = mockMvc.perform(put("/crew-management/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(crewManagementDTO)))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains("John Doe"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldGetCrewMemberByIdSuccessfully() throws Exception {
        Mockito.when(crewManagementService.getCrewMemberById(1L))
                .thenReturn(crewManagementDTO);

        MvcResult result = mockMvc.perform(get("/crew-management/{id}", 1L))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains("John Doe"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldGetAllCrewMembersSuccessfully() throws Exception {
        Mockito.when(crewManagementService.getAllCrewMembers())
                .thenReturn(Collections.singletonList(crewManagementDTO));

        MvcResult result = mockMvc.perform(get("/crew-management/all"))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains("John Doe"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldDeleteCrewMemberSuccessfully() throws Exception {
        Mockito.doNothing().when(crewManagementService).deleteCrewMember(1L);

        MvcResult result = mockMvc.perform(delete("/crew-management/{id}", 1L))
                .andReturn();

        assertEquals(204, result.getResponse().getStatus());
    }
}