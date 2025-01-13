package com.airTransport.atm_backend.dto;

import com.airTransport.atm_backend.dto.FlightDTO;
import com.airTransport.atm_backend.model.Flight.FlightStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class FlightDTOTest {

    private FlightDTO flightDTO;

    @BeforeEach
    void setUp() {
        flightDTO = new FlightDTO();
        flightDTO.setFlightName("Flight A");
        flightDTO.setDeparture(LocalDateTime.of(2025, 1, 12, 10, 0));
        flightDTO.setArrival(LocalDateTime.of(2025, 1, 12, 12, 0));
        flightDTO.setSource("New York");
        flightDTO.setDestination("Los Angeles");
        flightDTO.setPrice(500.00);
        flightDTO.setAirline("Airline X");
        flightDTO.setFlightClass("Economy");
        flightDTO.setStatus(FlightStatus.ON_TIME);
    }

    @Test
    void testFlightDTOGettersSetters() {
        assertEquals("Flight A", flightDTO.getFlightName());
        assertEquals(LocalDateTime.of(2025, 1, 12, 10, 0), flightDTO.getDeparture());
        assertEquals(LocalDateTime.of(2025, 1, 12, 12, 0), flightDTO.getArrival());
        assertEquals("New York", flightDTO.getSource());
        assertEquals("Los Angeles", flightDTO.getDestination());
        assertEquals(500.00, flightDTO.getPrice());
        assertEquals("Airline X", flightDTO.getAirline());
        assertEquals("Economy", flightDTO.getFlightClass());
        assertEquals(FlightStatus.ON_TIME, flightDTO.getStatus());
    }
}
