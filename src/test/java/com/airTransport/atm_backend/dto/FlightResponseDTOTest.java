package com.airTransport.atm_backend.dto;

import com.airTransport.atm_backend.model.Flight.FlightStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightResponseDTOTest {

    @Test
    public void testFlightResponseDTOSettersAndGetters() {
        FlightResponseDTO dto = new FlightResponseDTO();
        dto.setFlightId(1L);
        dto.setFlightName("Test Flight");
        dto.setDeparture(LocalDateTime.now());
        dto.setArrival(LocalDateTime.now().plusHours(2));
        dto.setSource("New York");
        dto.setDestination("Los Angeles");
        dto.setPrice(300.0);
        dto.setAirline("Test Airline");
        dto.setFlightClass("Economy");
        dto.setStatus(FlightStatus.ON_TIME);

        assertEquals(1L, dto.getFlightId());
        assertEquals("Test Flight", dto.getFlightName());
        assertEquals("New York", dto.getSource());
        assertEquals("Los Angeles", dto.getDestination());
        assertEquals(300.0, dto.getPrice());
        assertEquals("Test Airline", dto.getAirline());
        assertEquals("Economy", dto.getFlightClass());
        assertEquals(FlightStatus.ON_TIME, dto.getStatus());
    }
}
