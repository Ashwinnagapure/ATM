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
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CrewManagementControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CrewManagementService crewService;
//
//    private CrewManagementDTO crewMemberDTO;
//
//    @BeforeEach
//    void setUp() {
//        crewMemberDTO = new CrewManagementDTO();
//        crewMemberDTO.setId(1L);
//        crewMemberDTO.setName("John Doe");
//        crewMemberDTO.setRole(Role.PILOT);
//        crewMemberDTO.setAvailability(true);
//        crewMemberDTO.setAdminId(1L);
//    }
//
//    @Test
//    void testAddCrewMember() throws Exception {
//        Mockito.when(crewService.addCrewMember(Mockito.any())).thenReturn(crewMemberDTO);
//
//        mockMvc.perform(post("/crew-management")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(crewMemberDTO)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("John Doe"))
//                .andExpect(jsonPath("$.role").value("PILOT"));
//    }
//
//    @Test
//    void testGetCrewMemberById() throws Exception {
//        Mockito.when(crewService.getCrewMemberById(1L)).thenReturn(crewMemberDTO);
//
//        mockMvc.perform(get("/crew-management/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("John Doe"));
//    }
//
//    @Test
//    void testDeleteCrewMember() throws Exception {
//        mockMvc.perform(delete("/crew-management/1"))
//                .andExpect(status().isNoContent());
//        Mockito.verify(crewService, Mockito.times(1)).deleteCrewMember(1L);
//    }
//}
