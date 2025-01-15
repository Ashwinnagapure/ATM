package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.FlightCreateDTO;
import com.airTransport.atm_backend.dto.FlightResponseDTO;
import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.Flight;
import com.airTransport.atm_backend.repository.FlightRepository;
import com.airTransport.atm_backend.service.AdminService;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FlightServiceImplTest {

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private AdminService adminService;

    @InjectMocks
    private FlightServiceImpl flightService;

    private Flight flight;
    private Admin admin;
    private FlightCreateDTO flightCreateDTO;
    private FlightResponseDTO flightResponseDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks

        admin = new Admin();
        admin.setId(1L);

        flight = new Flight();
        flight.setFlightId(1L);
        flight.setFlightName("Flight 1");
        flight.setDeparture(LocalDateTime.now());
        flight.setArrival(LocalDateTime.now().plusHours(2));
        flight.setSource("New York");
        flight.setDestination("Los Angeles");
        flight.setPrice(500.00);
        flight.setAirline("Airline A");
        flight.setFlightClass("Economy");
        flight.setAdmin(admin);

        flightCreateDTO = new FlightCreateDTO();
        flightCreateDTO.setFlightName("Flight 1");
        flightCreateDTO.setDeparture(LocalDateTime.now());
        flightCreateDTO.setArrival(LocalDateTime.now().plusHours(2));
        flightCreateDTO.setSource("New York");
        flightCreateDTO.setDestination("Los Angeles");
        flightCreateDTO.setPrice(500.00);
        flightCreateDTO.setAirline("Airline A");
        flightCreateDTO.setFlightClass("Economy");
        flightCreateDTO.setAdminId(1L);

        flightResponseDTO = new FlightResponseDTO();
        flightResponseDTO.setFlightId(1L);
        flightResponseDTO.setFlightName("Flight 1");
        flightResponseDTO.setDeparture(LocalDateTime.now());
        flightResponseDTO.setArrival(LocalDateTime.now().plusHours(2));
        flightResponseDTO.setSource("New York");
        flightResponseDTO.setDestination("Los Angeles");
        flightResponseDTO.setPrice(500.00);
        flightResponseDTO.setAirline("Airline A");
        flightResponseDTO.setFlightClass("Economy");
    }

    @AfterEach
    void tearDown() throws Exception {

    }

    //Success
    @Test
    void trackFlightStatus() {
        when(flightRepository.existsById(1L)).thenReturn(true);
        boolean result = flightService.trackFlightStatus(1L);
        assertTrue(result);
        verify(flightRepository).existsById(1L);
    }

    //Failure
    @Test
    void trackFlightStatus_FlightNotFound() {
        long nonExistentFlightId = 9999L;
        boolean result = flightService.trackFlightStatus(nonExistentFlightId);
        assertFalse(result);
    }

    //Success
    @Test
    void scheduleFlights() {
        when(adminService.getAdminById(1L)).thenReturn(admin);
        when(flightRepository.save(any(Flight.class))).thenReturn(flight);

        boolean result = flightService.scheduleFlights(flightCreateDTO);
        assertTrue(result);

        verify(flightRepository).save(any(Flight.class));
    }


    //Success
    @Test
    void cancelFlights() {
        when(flightRepository.existsById(1L)).thenReturn(true);
        doNothing().when(flightRepository).deleteById(1L);

        boolean result = flightService.cancelFlights(1L);
        assertTrue(result);

        verify(flightRepository).deleteById(1L);
    }

    //Failure
    @Test
    void cancelFlights_FlightNotFound() {
        long nonExistentFlightId = 9999L;
        boolean result = flightService.cancelFlights(nonExistentFlightId);
        assertFalse(result);
    }


    @Test
    void getFlightById() {
        when(flightRepository.findById(1L)).thenReturn(Optional.of(flight));
        FlightResponseDTO result = flightService.getFlightById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getFlightId());
        verify(flightRepository).findById(1L);
    }

//    @Test
//    void getFlightById_FlightNotFound() {
//        long nonExistentFlightId = 9999L;
//        FlightResponseDTO result = flightService.getFlightById(nonExistentFlightId);
//        assertNull(result);
//    }


    @Test
    void sortByPrice() {
        List<Flight> flights = Arrays.asList(flight);
        when(flightRepository.findAllByOrderByPriceAsc()).thenReturn(flights);

        List<FlightResponseDTO> result = flightService.sortByPrice();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(500.00, result.get(0).getPrice());

        verify(flightRepository).findAllByOrderByPriceAsc();
    }

    @Test
    void sortByPrice_NoFlights() {
        when(flightRepository.findAllByOrderByPriceAsc()).thenReturn(Collections.emptyList());
        List<FlightResponseDTO> result = flightService.sortByPrice();
        assertTrue(result.isEmpty());
    }


    @Test
    void sortByAirline() {
        List<Flight> flights = Arrays.asList(flight);
        when(flightRepository.findAllByOrderByAirlineAsc()).thenReturn(flights);
        List<FlightResponseDTO> result = flightService.sortByAirline();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Airline A", result.get(0).getAirline());
        verify(flightRepository).findAllByOrderByAirlineAsc();
    }

    @Test
    void sortByAirline_NoFlights() {
        when(flightRepository.findAllByOrderByAirlineAsc()).thenReturn(Collections.emptyList());
        List<FlightResponseDTO> result = flightService.sortByAirline();
        assertTrue(result.isEmpty());
    }

    @Test
    void sortByClass() {
        List<Flight> flights = Arrays.asList(flight);
        when(flightRepository.findAllByOrderByFlightClassAsc()).thenReturn(flights);

        List<FlightResponseDTO> result = flightService.sortByClass();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Economy", result.get(0).getFlightClass());

        verify(flightRepository).findAllByOrderByFlightClassAsc();
    }

    @Test
    void sortByClass_NoFlights() {
        when(flightRepository.findAllByOrderByFlightClassAsc()).thenReturn(Collections.emptyList());
        List<FlightResponseDTO> result = flightService.sortByClass();
        assertTrue(result.isEmpty());
    }

}