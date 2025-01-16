//package com.airTransport.atm_backend.controller;
//
//import com.airTransport.atm_backend.dto.FlightCreateDTO;
//import com.airTransport.atm_backend.dto.FlightResponseDTO;
//import com.airTransport.atm_backend.service.FlightManagementService;
//import com.airTransport.atm_backend.service.FlightSearchService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Collections;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(FlightController.class)
//class FlightControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private FlightManagementService flightManagementService;
//
//    @MockBean
//    private FlightSearchService flightSearchService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    void testScheduleFlight() throws Exception {
//        FlightCreateDTO flightCreateDTO = new FlightCreateDTO();
//        flightCreateDTO.setFlightName("Test Flight");
//        Mockito.when(flightManagementService.scheduleFlights(any())).thenReturn(true);
//
//        mockMvc.perform(post("/flights/schedule")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(flightCreateDTO)))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Flight scheduled successfully"));
//    }
//
//    @Test
//    void testGetAllFlights() throws Exception {
//        FlightResponseDTO responseDTO = new FlightResponseDTO();
//        responseDTO.setFlightId(1L);
//        responseDTO.setFlightName("Test Flight");
//
//        Mockito.when(flightManagementService.getAllFlights())
//                .thenReturn(Collections.singletonList(responseDTO));
//
//        mockMvc.perform(get("/flights/all"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].flightId").value(1L))
//                .andExpect(jsonPath("$[0].flightName").value("Test Flight"));
//    }
//}
