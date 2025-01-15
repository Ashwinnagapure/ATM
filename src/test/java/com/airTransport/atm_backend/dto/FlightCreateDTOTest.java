package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightCreateDTOTest {

    @Test
    public void testFlightCreateDTOSettersAndGetters() {
        FlightCreateDTO dto = new FlightCreateDTO();
        dto.setFlightName("Test Flight");
        dto.setDeparture(LocalDateTime.now());
        dto.setArrival(LocalDateTime.now().plusHours(2));
        dto.setSource("New York");
        dto.setDestination("Los Angeles");
        dto.setPrice(300.0);
        dto.setAirline("Test Airline");
        dto.setFlightClass("Economy");
        dto.setAdminId(1L);

        assertEquals("Test Flight", dto.getFlightName());
        assertEquals("New York", dto.getSource());
        assertEquals("Los Angeles", dto.getDestination());
        assertEquals(300.0, dto.getPrice());
        assertEquals("Test Airline", dto.getAirline());
        assertEquals("Economy", dto.getFlightClass());
        assertEquals(1L, dto.getAdminId());
    }
}
