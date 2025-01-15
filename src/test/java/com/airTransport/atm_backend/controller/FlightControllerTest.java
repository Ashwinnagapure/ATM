//package com.airTransport.atm_backend.controller;
//
//import com.airTransport.atm_backend.dto.FlightCreateDTO;
//import com.airTransport.atm_backend.dto.FlightResponseDTO;
//import com.airTransport.atm_backend.service.FlightManagementService;
//import com.airTransport.atm_backend.service.FlightSearchService;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(FlightController.class)
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
//    @Test
//    public void testScheduleFlightSuccess() throws Exception {
//        FlightCreateDTO flightCreateDTO = new FlightCreateDTO();
//        flightCreateDTO.setFlightName("Test Flight");
//        flightCreateDTO.setDeparture(LocalDateTime.now());
//        flightCreateDTO.setArrival(LocalDateTime.now().plusHours(2));
//        flightCreateDTO.setSource("New York");
//        flightCreateDTO.setDestination("Los Angeles");
//        flightCreateDTO.setPrice(300.0);
//        flightCreateDTO.setAirline("Test Airline");
//        flightCreateDTO.setFlightClass("Economy");
//        flightCreateDTO.setAdminId(1L);
//
//        when(flightManagementService.scheduleFlights(Mockito.any(FlightCreateDTO.class))).thenReturn(true);
//
//        mockMvc.perform(post("/flights/schedule")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"flightName\":\"Test Flight\",\"departure\":\"2025-01-01T10:00:00\",\"arrival\":\"2025-01-01T12:00:00\",\"source\":\"New York\",\"destination\":\"Los Angeles\",\"price\":300,\"airline\":\"Test Airline\",\"flightClass\":\"Economy\",\"adminId\":1}"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Flight scheduled successfully"));
//    }
//
//    @Test
//    public void testScheduleFlightFailure() throws Exception {
//        when(flightManagementService.scheduleFlights(Mockito.any(FlightCreateDTO.class))).thenReturn(false);
//
//        mockMvc.perform(post("/flights/schedule")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"flightName\":\"\",\"departure\":\"\",\"arrival\":\"\",\"source\":\"\",\"destination\":\"\",\"price\":0,\"airline\":\"\",\"flightClass\":\"\",\"adminId\":1}"))
//                .andExpect(status().isBadRequest())
//                .andExpect(content().string("Failed to schedule flight"));
//    }
//
//    @Test
//    public void testGetFlightsByAirline() throws Exception {
//        FlightResponseDTO flightResponseDTO = new FlightResponseDTO();
//        flightResponseDTO.setFlightId(1L);
//        flightResponseDTO.setFlightName("Test Flight");
//        flightResponseDTO.setAirline("Test Airline");
//
//        List<FlightResponseDTO> flights = Collections.singletonList(flightResponseDTO);
//        when(flightSearchService.getFlightsByAirline("Test Airline")).thenReturn(flights);
//
//        mockMvc.perform(get("/flights/airline/Test Airline"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].flightName").value("Test Flight"))
//                .andExpect(jsonPath("$[0].airline").value("Test Airline"));
//    }
//
//    @Test
//    public void testCancelFlight() throws Exception {
//        when(flightManagementService.cancelFlights(1L)).thenReturn(true);
//
//        mockMvc.perform(delete("/flights/cancel/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Flight cancelled successfully"));
//    }
//
//    @Test
//    public void testSortByPrice() throws Exception {
//        FlightResponseDTO flight1 = new FlightResponseDTO();
//        flight1.setFlightId(1L);
//        flight1.setPrice(100.0);
//
//        FlightResponseDTO flight2 = new FlightResponseDTO();
//        flight2.setFlightId(2L);
//        flight2.setPrice(200.0);
//
//        when(flightSearchService.sortByPrice()).thenReturn(Arrays.asList(flight1, flight2));
//
//        mockMvc.perform(get("/flights/sort/price"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].price").value(100.0))
//                .andExpect(jsonPath("$[1].price").value(200.0));
//    }
//}
