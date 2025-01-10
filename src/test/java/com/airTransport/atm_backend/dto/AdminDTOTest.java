package com.airTransport.atm_backend.dto;

import com.airTransport.atm_backend.model.Flight.FlightStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("AdminDTO Tests")
class AdminDTOTest {

    private AdminDTO adminDTO;

    @BeforeEach
    void setUp() {
        adminDTO = new AdminDTO();
    }

    @Test
    @DisplayName("Test setting and getting basic properties")
    void testBasicProperties() {
        adminDTO.setId(1L);
        adminDTO.setUsername("admin_user");
        adminDTO.setEmail("admin@example.com");
        adminDTO.setRole("ADMIN");

        assertEquals(1L, adminDTO.getId(), "ID should be set correctly");
        assertEquals("admin_user", adminDTO.getUsername(), "Username should be set correctly");
        assertEquals("admin@example.com", adminDTO.getEmail(), "Email should be set correctly");
        assertEquals("ADMIN", adminDTO.getRole(), "Role should be set correctly");
    }

    @Test
    @DisplayName("Test setting and getting flight list with updated fields")
    void testFlights() {
        FlightDTO flight1 = new FlightDTO();
        flight1.setFlightName("Flight A");
        flight1.setDeparture(LocalDateTime.of(2025, 1, 15, 10, 0));
        flight1.setArrival(LocalDateTime.of(2025, 1, 15, 14, 0));
        flight1.setStatus(FlightStatus.ON_TIME);
        flight1.setSource("New York");
        flight1.setDestination("London");
        flight1.setPrice(1200.50);
        flight1.setAirline("Airways International");
        flight1.setFlightClass("Economy");
        flight1.setAdminId(1L);

        FlightDTO flight2 = new FlightDTO();
        flight2.setFlightName("Flight B");
        flight2.setDeparture(LocalDateTime.of(2025, 1, 20, 9, 0));
        flight2.setArrival(LocalDateTime.of(2025, 1, 20, 15, 0));
        flight2.setStatus(FlightStatus.DELAYED);
        flight2.setSource("Paris");
        flight2.setDestination("Tokyo");
        flight2.setPrice(1500.75);
        flight2.setAirline("Global Airlines");
        flight2.setFlightClass("Business");
        flight2.setAdminId(1L);

        List<FlightDTO> flights = Arrays.asList(flight1, flight2);
        adminDTO.setFlights(flights);

        assertNotNull(adminDTO.getFlights(), "Flights list should not be null");
        assertEquals(2, adminDTO.getFlights().size(), "Flights list size should be 2");

        FlightDTO flight = adminDTO.getFlights().get(0);
        assertEquals("Flight A", flight.getFlightName(), "First flight name should be 'Flight A'");
        assertEquals(LocalDateTime.of(2025, 1, 15, 10, 0), flight.getDeparture(), "First flight departure should match");
        assertEquals(LocalDateTime.of(2025, 1, 15, 14, 0), flight.getArrival(), "First flight arrival should match");
        assertEquals(FlightStatus.ON_TIME, flight.getStatus(), "First flight status should be 'SCHEDULED'");
        assertEquals("New York", flight.getSource(), "First flight source should be 'New York'");
        assertEquals("London", flight.getDestination(), "First flight destination should be 'London'");
        assertEquals(1200.50, flight.getPrice(), "First flight price should be 1200.50");
        assertEquals("Airways International", flight.getAirline(), "First flight airline should be 'Airways International'");
        assertEquals("Economy", flight.getFlightClass(), "First flight class should be 'Economy'");
        assertEquals(1L, flight.getAdminId(), "First flight admin ID should be 1");
    }

    @Test
    @DisplayName("Test edge case with empty flight list")
    void testEmptyFlightList() {
        adminDTO.setFlights(Arrays.asList());

        assertNotNull(adminDTO.getFlights(), "Flights list should not be null, even if empty");
        assertTrue(adminDTO.getFlights().isEmpty(), "Flights list should be empty");
    }

    @Test
    @DisplayName("Test edge case with null flight list")
    void testNullFlightList() {
        adminDTO.setFlights(null);

        assertNull(adminDTO.getFlights(), "Flights list should be null if explicitly set to null");
    }

    @Test
    @DisplayName("Test exception safety for flights")
    void testFlightExceptionSafety() {
        assertDoesNotThrow(() -> adminDTO.setFlights(null), "Setting null flights should not throw an exception");
    }

//    @Test
//    @DisplayName("Test toString implementation")
//    void testToString() {
//        adminDTO.setId(1L);
//        adminDTO.setUsername("admin_user");
//        adminDTO.setEmail("admin@example.com");
//        adminDTO.setRole("ADMIN");
//
//        String toStringOutput = adminDTO.toString();
//        assertTrue(toStringOutput.contains("admin_user"), "toString should include username");
//        assertTrue(toStringOutput.contains("admin@example.com"), "toString should include email");
//    }
}
