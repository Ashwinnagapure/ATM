//package com.airTransport.atm_backend.controller;
//
//import com.airTransport.atm_backend.controller.FlightController;
//import com.airTransport.atm_backend.dto.FlightCreateDTO;
//import com.airTransport.atm_backend.dto.FlightResponseDTO;
//import com.airTransport.atm_backend.service.FlightManagementService;
//import com.airTransport.atm_backend.service.FlightSearchService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.mockito.Mockito.*;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//public class FlightControllerTest {
//
//    private FlightController flightController;
//    private FlightManagementService flightManagementService;
//    private FlightSearchService flightSearchService;
//
//    @BeforeEach
//    void setUp() {
//        flightManagementService = mock(FlightManagementService.class);
//        flightSearchService = mock(FlightSearchService.class);
//        flightController = new FlightController();
//    }
//
//    @Test
//    void testScheduleFlight() {
//        FlightCreateDTO flightCreateDTO = new FlightCreateDTO();
//        when(flightManagementService.scheduleFlights(flightCreateDTO)).thenReturn(true);
//        ResponseEntity<String> response = flightController.scheduleFlight(flightCreateDTO);
////        assertEquals(200, response.getStatusCodeValue());
//    }
//
//    @Test
//    void testGetFlightById() {
//        FlightResponseDTO flightResponseDTO = new FlightResponseDTO();
//        when(flightManagementService.getFlightById(1L)).thenReturn(flightResponseDTO);
//        ResponseEntity<FlightResponseDTO> response = flightController.getFlightById(1L);
////        assertEquals(200, response.getStatusCodeValue());
//    }
//
//    @Test
//    void testSortByPrice() {
//        when(flightSearchService.sortByPrice()).thenReturn(List.of(new FlightResponseDTO()));
//        ResponseEntity<List<FlightResponseDTO>> response = flightController.sortByPrice();
////        assertEquals(200, response.getStatusCodeValue());
//    }
//}
