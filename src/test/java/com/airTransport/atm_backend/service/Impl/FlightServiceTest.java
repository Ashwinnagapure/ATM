//package com.airTransport.atm_backend.service.Impl;
//
//import com.airTransport.atm_backend.dto.FlightCreateDTO;
//import com.airTransport.atm_backend.dto.FlightResponseDTO;
//import com.airTransport.atm_backend.model.Flight;
//import com.airTransport.atm_backend.repository.FlightRepository;
//import com.airTransport.atm_backend.service.AdminService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import java.util.List;
//
//public class FlightServiceTest {
//
//    private FlightServiceImpl flightService;
//    private FlightRepository flightRepositoryMock;
//    private AdminService adminServiceMock;
//
//    @BeforeEach
//    void setUp() {
//        flightRepositoryMock = mock(FlightRepository.class);
//        adminServiceMock = mock(AdminService.class);
//        flightService = new FlightServiceImpl();
//    }
//
//    @Test
//    void testScheduleFlight() {
//        FlightCreateDTO flightCreateDTO = new FlightCreateDTO();
//        flightCreateDTO.setFlightName("Flight B");
//        when(flightRepositoryMock.save(any(Flight.class))).thenReturn(new Flight());
//        assertTrue(flightService.scheduleFlights(flightCreateDTO));
//    }
//
//    @Test
//    void testGetFlightById() {
//        Flight flight = new Flight();
//        flight.setFlightName("Flight B");
//        when(flightRepositoryMock.findById(1L)).thenReturn(java.util.Optional.of(flight));
//        FlightResponseDTO flightDTO = flightService.getFlightById(1L);
//        assertEquals("Flight B", flightDTO.getFlightName());
//    }
//
//    @Test
//    void testSortByPrice() {
//        List<Flight> flights = List.of(new Flight());
//        when(flightRepositoryMock.findAllByOrderByPriceAsc()).thenReturn(flights);
//        List<FlightResponseDTO> sortedFlights = flightService.sortByPrice();
//        assertNotNull(sortedFlights);
//    }
//}
