package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.FlightCreateDTO;
import com.airTransport.atm_backend.dto.FlightResponseDTO;
import com.airTransport.atm_backend.service.FlightManagementService;
import com.airTransport.atm_backend.service.FlightSearchService;
import com.airTransport.atm_backend.service.PassengerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class FlightControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FlightManagementService flightManagement;

    @Mock
    private FlightSearchService flightSearch;

    @Mock
    private PassengerService passengerService;

    @InjectMocks
    private FlightController flightController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks
        mockMvc = MockMvcBuilders.standaloneSetup(flightController).build();
    }

    @Test
    void testFlightControllerTest() throws Exception {
        mockMvc.perform(get("/flights/test"))
                .andExpect(status().isOk())
                .andExpect(content().string("Testing Flight Controller"));
    }

    @Test
    void testGetAllFlights() throws Exception {
        // Setup
        FlightResponseDTO flight1 = new FlightResponseDTO();  // Example flight
        FlightResponseDTO flight2 = new FlightResponseDTO();  // Example flight
        List<FlightResponseDTO> flights = Arrays.asList(flight1, flight2);

        when(flightSearch.sortByPrice()).thenReturn(flights);

        mockMvc.perform(get("/flights/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[1]").exists());
    }

//    @Test
//    void testScheduleFlight() throws Exception {
//        FlightCreateDTO flightCreateDTO = new FlightCreateDTO(); // Populate with appropriate data
//        when(flightManagement.scheduleFlights(flightCreateDTO)).thenReturn(true);
//
//        mockMvc.perform(post("/flights/schedule")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{ \"flightData\": \"example\" }"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Flight scheduled successfully"));
//
//        verify(flightManagement, times(1)).scheduleFlights(flightCreateDTO);
//    }

    @Test
    void testCancelFlight() throws Exception {
        // Setup
        long flightId = 1L;
        when(flightManagement.cancelFlights(flightId)).thenReturn(true);

        mockMvc.perform(delete("/flights/cancel/{flightId}", flightId))
                .andExpect(status().isOk())
                .andExpect(content().string("Flight cancelled successfully"));

        verify(flightManagement, times(1)).cancelFlights(flightId);
    }

//    @Test
//    void testGetFlightById_Valid() throws Exception {
//        long flightId = 1L;
//        FlightResponseDTO flight = new FlightResponseDTO();  // Populate with flight data
//        when(flightManagement.getFlightById(flightId)).thenReturn(flight);
//
//        mockMvc.perform(get("/flights/{flightId}", flightId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.flightId").value(flightId));
//
//        verify(flightManagement, times(1)).getFlightById(flightId);
//    }

    @Test
    void testGetFlightById_NotFound() throws Exception {
        long flightId = 999L;
        when(flightManagement.getFlightById(flightId)).thenReturn(null);

        mockMvc.perform(get("/flights/{flightId}", flightId))
                .andExpect(status().isNotFound());
    }

    @Test
    void testSortByPrice() throws Exception {
        // Setup
        FlightResponseDTO flight1 = new FlightResponseDTO();  // Example flight
        FlightResponseDTO flight2 = new FlightResponseDTO();  // Example flight
        List<FlightResponseDTO> flights = Arrays.asList(flight1, flight2);

        when(flightSearch.sortByPrice()).thenReturn(flights);

        mockMvc.perform(get("/flights/sort/price"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0]").exists());
    }

//    @Test
//    void testGetFlightById_ExceptionHandling() throws Exception {
//        long flightId = 999L;  // Assuming this ID does not exist
//        when(flightManagement.getFlightById(flightId)).thenThrow(new RuntimeException("Flight not found"));
//
//        mockMvc.perform(get("/flights/{flightId}", flightId))
//                .andExpect(status().isInternalServerError())
//                .andExpect(content().string("Flight not found"));
//    }
//
//    @Test
//    void testScheduleFlight_BadRequest() throws Exception {
//        FlightCreateDTO flightCreateDTO = new FlightCreateDTO(); // Populate with invalid data
//        when(flightManagement.scheduleFlights(flightCreateDTO)).thenReturn(false);
//
//        mockMvc.perform(post("/flights/schedule")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{ \"flightData\": \"example\" }"))
//                .andExpect(status().isBadRequest())
//                .andExpect(content().string("Failed to schedule the flight"));
//
//        verify(flightManagement, times(1)).scheduleFlights(flightCreateDTO);
//    }

    @Test
    void testGetAllFlights_EmptyList() throws Exception {
        when(flightSearch.sortByPrice()).thenReturn(Arrays.asList());

        mockMvc.perform(get("/flights/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
