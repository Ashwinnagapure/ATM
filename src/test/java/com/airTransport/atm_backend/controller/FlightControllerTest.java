//package com.airTransport.atm_backend.controller;
//
//import com.airTransport.atm_backend.dto.FlightCreateDTO;
//import com.airTransport.atm_backend.dto.FlightResponseDTO;
//import com.airTransport.atm_backend.model.Flight;
//import com.airTransport.atm_backend.service.FlightManagementService;
//import com.airTransport.atm_backend.service.FlightSearchService;
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
//import java.time.LocalDateTime;
//import java.util.Collections;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(controllers = FlightController.class)
//public class FlightControllerTest {
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
//    private FlightCreateDTO flightCreateDTO;
//    private FlightResponseDTO flightResponseDTO;
//
//    @BeforeEach
//    void setUp() {
//        // Initializing DTOs for test setup
//        flightCreateDTO = new FlightCreateDTO();
//        flightCreateDTO.setFlightName("Test Flight");
//        flightCreateDTO.setSource("Delhi");
//        flightCreateDTO.setDestination("Mumbai");
//        //flightCreateDTO.setDeparture(LocalDateTime.parse("10:00 AM"));
//        //flightCreateDTO.setArrival(LocalDateTime.parse("12:00 PM"));
//        flightCreateDTO.setPrice(5000.0);
//        flightCreateDTO.setAirline("Test Airline");
//        flightCreateDTO.setFlightClass("Economy");
//        flightCreateDTO.setAdminId(1L);
//
//        flightResponseDTO = new FlightResponseDTO();
//        flightResponseDTO.setFlightId(1L);
//        flightResponseDTO.setFlightName("Test Flight");
//        flightResponseDTO.setSource("Delhi");
//        flightResponseDTO.setDestination("Mumbai");
//        flightResponseDTO.setStatus(Flight.FlightStatus.ON_TIME);
//        flightResponseDTO.setPrice(5000.0);
//    }
//
//    @Test
//    void shouldScheduleFlightSuccessfully() throws Exception {
//        Mockito.when(flightManagementService.scheduleFlights(any(FlightCreateDTO.class)))
//                .thenReturn(true);
//
//        mockMvc.perform(post("/flights/schedule")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(flightCreateDTO)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.flightId").value(flightResponseDTO.getFlightId()))
//                .andExpect(jsonPath("$.flightName").value(flightResponseDTO.getFlightName()))
//                .andExpect(jsonPath("$.source").value(flightResponseDTO.getSource()))
//                .andExpect(jsonPath("$.destination").value(flightResponseDTO.getDestination()))
//                .andExpect(jsonPath("$.status").value(flightResponseDTO.getStatus()));
//    }
//
//    @Test
//    void shouldCancelFlightSuccessfully() throws Exception {
//        Mockito.doNothing().when(flightManagementService).cancelFlights(eq(1L));
//
//        mockMvc.perform(delete("/flights/cancel/{flightId}", 1L))
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    void shouldGetAllFlightsSuccessfully() throws Exception {
//        Mockito.when(flightSearchService.getFlightsByAirline("vistara")).thenReturn(List.of(flightResponseDTO));
//
//        mockMvc.perform(get("/flights/all"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(1))
//                .andExpect(jsonPath("$[0].flightId").value(flightResponseDTO.getFlightId()))
//                .andExpect(jsonPath("$[0].flightName").value(flightResponseDTO.getFlightName()))
//                .andExpect(jsonPath("$[0].source").value(flightResponseDTO.getSource()))
//                .andExpect(jsonPath("$[0].destination").value(flightResponseDTO.getDestination()));
//    }
//
//    @Test
//    void shouldSearchFlightsBySourceAndDestination() throws Exception {
//        // Mocking the service call to return a flight
//        Mockito.when(flightSearchService.searchFlights("Delhi", "Mumbai"))
//                .thenReturn(Collections.singletonList(flightResponseDTO));
//
//        // Assuming that the endpoint requires an Authorization header with a Bearer token
//        String token = "your-jwt-token";  // Replace with a valid token if necessary
//
//        // Performing the request with the Authorization header
//        mockMvc.perform(get("/flights/search")
//                        .param("source", "Delhi")
//                        .param("destination", "Mumbai")
//                        .header("Authorization", "Bearer " + token))  // Adding Authorization header
//                .andExpect(status().isOk())  // Expecting a 200 status
//                .andExpect(jsonPath("$.length()").value(1))  // Validating the response length
//                .andExpect(jsonPath("$[0].flightId").value(flightResponseDTO.getFlightId()))  // Validating flightId
//                .andExpect(jsonPath("$[0].flightName").value(flightResponseDTO.getFlightName()));  // Validating flightName
//    }
//
//}
