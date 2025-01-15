//package com.airTransport.atm_backend.controller;
//
//import com.airTransport.atm_backend.dto.CrewManagementDTO;
//import com.airTransport.atm_backend.model.enums.Role;
//import com.airTransport.atm_backend.service.CrewManagementService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(CrewManagementController.class)
//public class CrewManagementControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CrewManagementService crewService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private CrewManagementDTO crewManagementDTO;
//
//    @BeforeEach
//    void setUp() {
//        crewManagementDTO = new CrewManagementDTO();
//        crewManagementDTO.setId(1L);
//        crewManagementDTO.setName("John Doe");
//        crewManagementDTO.setRole(Role.PILOT);
//        crewManagementDTO.setAvailability(true);
//        crewManagementDTO.setAdminId(101L);
//    }
//
//    @Test
//    void testAddCrewMember() throws Exception {
//        Mockito.when(crewService.addCrewMember(any(CrewManagementDTO.class))).thenReturn(crewManagementDTO);
//
//        mockMvc.perform(post("/crew-management")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(crewManagementDTO)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.name").value("John Doe"))
//                .andExpect(jsonPath("$.role").value("PILOT"))
//                .andExpect(jsonPath("$.availability").value(true))
//                .andExpect(jsonPath("$.adminId").value(101));
//    }
//
//    @Test
//    void testUpdateCrewMember() throws Exception {
//        Mockito.when(crewService.updateCrewMember(eq(1L), any(CrewManagementDTO.class))).thenReturn(crewManagementDTO);
//
//        mockMvc.perform(put("/crew-management/{id}", 1L)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(crewManagementDTO)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.name").value("John Doe"))
//                .andExpect(jsonPath("$.role").value("PILOT"))
//                .andExpect(jsonPath("$.availability").value(true))
//                .andExpect(jsonPath("$.adminId").value(101));
//    }
//
//    @Test
//    void testDeleteCrewMember() throws Exception {
//        Mockito.doNothing().when(crewService).deleteCrewMember(1L);
//
//        mockMvc.perform(delete("/crew-management/{id}", 1L)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    void testGetCrewMemberById() throws Exception {
//        Mockito.when(crewService.getCrewMemberById(1L)).thenReturn(crewManagementDTO);
//
//        mockMvc.perform(get("/crew-management/{id}", 1L)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.name").value("John Doe"))
//                .andExpect(jsonPath("$.role").value("PILOT"))
//                .andExpect(jsonPath("$.availability").value(true))
//                .andExpect(jsonPath("$.adminId").value(101));
//    }
//
//    @Test
//    void testGetCrewMembersByRole() throws Exception {
//        List<CrewManagementDTO> crewMembers = Arrays.asList(crewManagementDTO);
//        Mockito.when(crewService.getCrewMembersByRole("PILOT")).thenReturn(crewMembers);
//
//        mockMvc.perform(get("/crew-management/role/{role}", "PILOT")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(1))
//                .andExpect(jsonPath("$[0].name").value("John Doe"))
//                .andExpect(jsonPath("$[0].role").value("PILOT"))
//                .andExpect(jsonPath("$[0].availability").value(true))
//                .andExpect(jsonPath("$[0].adminId").value(101));
//    }
//
//    @Test
//    void testGetAvailableCrewMembers() throws Exception {
//        List<CrewManagementDTO> crewMembers = Arrays.asList(crewManagementDTO);
//        Mockito.when(crewService.getAvailableCrewMembers()).thenReturn(crewMembers);
//
//        mockMvc.perform(get("/crew-management/available")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(1))
//                .andExpect(jsonPath("$[0].name").value("John Doe"))
//                .andExpect(jsonPath("$[0].role").value("PILOT"))
//                .andExpect(jsonPath("$[0].availability").value(true))
//                .andExpect(jsonPath("$[0].adminId").value(101));
//    }
//
//    @Test
//    void testGetCrewByAdmin() throws Exception {
//        List<CrewManagementDTO> crewMembers = Arrays.asList(crewManagementDTO);
//        Mockito.when(crewService.getCrewByAdmin(101L)).thenReturn(crewMembers);
//
//        mockMvc.perform(get("/crew-management/admin/{adminId}", 101L)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(1))
//                .andExpect(jsonPath("$[0].name").value("John Doe"))
//                .andExpect(jsonPath("$[0].role").value("PILOT"))
//                .andExpect(jsonPath("$[0].availability").value(true))
//                .andExpect(jsonPath("$[0].adminId").value(101));
//    }
//
//    @Test
//    void testGetAllCrewMembers() throws Exception {
//        List<CrewManagementDTO> crewMembers = Arrays.asList(crewManagementDTO);
//        Mockito.when(crewService.getAllCrewMembers()).thenReturn(crewMembers);
//
//        mockMvc.perform(get("/crew-management/all")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(1))
//                .andExpect(jsonPath("$[0].name").value("John Doe"))
//                .andExpect(jsonPath("$[0].role").value("PILOT"))
//                .andExpect(jsonPath("$[0].availability").value(true))
//                .andExpect(jsonPath("$[0].adminId").value(101));
//    }
//}
