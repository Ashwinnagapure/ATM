//package com.airTransport.atm_backend.repository;
//
//import com.airTransport.atm_backend.model.Flight;
//import com.airTransport.atm_backend.model.Flight.FlightStatus;
//import com.airTransport.atm_backend.repository.FlightRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//public class FlightRepositoryTest {
//
//    @Mock
//    private FlightRepository flightRepository;
//
//    @InjectMocks
//    private FlightRepository flightRepositoryMock;
//
//    private Flight flight;
//
//    @BeforeEach
//    void setUp() {
//        flight = new Flight();
//        flight.setFlightName("Flight A");
//        flight.setDeparture(LocalDateTime.of(2025, 1, 12, 10, 0));
//        flight.setArrival(LocalDateTime.of(2025, 1, 12, 12, 0));
//        flight.setSource("New York");
//        flight.setDestination("Los Angeles");
//        flight.setPrice(500.00);
//        flight.setAirline("Airline X");
//        flight.setFlightClass("Economy");
//        flight.setStatus(FlightStatus.ON_TIME);
//    }
//
//    @Test
//    void testFindFlightById() {
//        when(flightRepository.findById(1L)).thenReturn(Optional.of(flight));
//        Optional<Flight> foundFlight = flightRepository.findById(1L);
//        assertTrue(foundFlight.isPresent());
//        assertEquals("Flight A", foundFlight.get().getFlightName());
//    }
//
//    @Test
//    void testFindAllFlightsByPrice() {
//        when(flightRepository.findAllByOrderByPriceAsc()).thenReturn(List.of(flight));
//        List<Flight> flights = flightRepository.findAllByOrderByPriceAsc();
//        assertFalse(flights.isEmpty());
//        assertEquals(500.00, flights.get(0).getPrice());
//    }
//}
