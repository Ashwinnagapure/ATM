package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FlightCreateDTOTest {

    private FlightCreateDTO flightCreateDTO;

    @BeforeEach
    void setUp() {
        flightCreateDTO = new FlightCreateDTO();
        flightCreateDTO.setFlightName("Flight 101");
        flightCreateDTO.setDeparture(LocalDateTime.of(2025, 1, 20, 10, 0));
        flightCreateDTO.setArrival(LocalDateTime.of(2025, 1, 20, 12, 0));
        flightCreateDTO.setSource("New York");
        flightCreateDTO.setDestination("Los Angeles");
        flightCreateDTO.setPrice(300.0);
        flightCreateDTO.setAirline("AirXYZ");
        flightCreateDTO.setFlightClass("Economy");
        flightCreateDTO.setAdminId(1L);
    }

    @AfterEach
    void tearDown() {
        flightCreateDTO = null;
    }

    @Test
    void getFlightName() {
        assertEquals("Flight 101", flightCreateDTO.getFlightName());
    }

    @Test
    void setFlightName() {
        flightCreateDTO.setFlightName("Flight 202");
        assertEquals("Flight 202", flightCreateDTO.getFlightName());
    }

    @Test
    void getDeparture() {
        assertEquals(LocalDateTime.of(2025, 1, 20, 10, 0), flightCreateDTO.getDeparture());
    }

    @Test
    void setDeparture() {
        LocalDateTime newDeparture = LocalDateTime.of(2025, 1, 21, 15, 0);
        flightCreateDTO.setDeparture(newDeparture);
        assertEquals(newDeparture, flightCreateDTO.getDeparture());
    }

    @Test
    void getArrival() {
        assertEquals(LocalDateTime.of(2025, 1, 20, 12, 0), flightCreateDTO.getArrival());
    }

    @Test
    void setArrival() {
        LocalDateTime newArrival = LocalDateTime.of(2025, 1, 20, 14, 0);
        flightCreateDTO.setArrival(newArrival);
        assertEquals(newArrival, flightCreateDTO.getArrival());
    }

    @Test
    void getSource() {
        assertEquals("New York", flightCreateDTO.getSource());
    }

    @Test
    void setSource() {
        flightCreateDTO.setSource("Chicago");
        assertEquals("Chicago", flightCreateDTO.getSource());
    }

    @Test
    void getDestination() {
        assertEquals("Los Angeles", flightCreateDTO.getDestination());
    }

    @Test
    void setDestination() {
        flightCreateDTO.setDestination("San Francisco");
        assertEquals("San Francisco", flightCreateDTO.getDestination());
    }

    @Test
    void getPrice() {
        assertEquals(300.0, flightCreateDTO.getPrice());
    }

    @Test
    void setPrice() {
        flightCreateDTO.setPrice(350.0);
        assertEquals(350.0, flightCreateDTO.getPrice());
    }

    @Test
    void getAirline() {
        assertEquals("AirXYZ", flightCreateDTO.getAirline());
    }

    @Test
    void setAirline() {
        flightCreateDTO.setAirline("SkyAir");
        assertEquals("SkyAir", flightCreateDTO.getAirline());
    }

    @Test
    void getFlightClass() {
        assertEquals("Economy", flightCreateDTO.getFlightClass());
    }

    @Test
    void setFlightClass() {
        flightCreateDTO.setFlightClass("Business");
        assertEquals("Business", flightCreateDTO.getFlightClass());
    }

    @Test
    void getAdminId() {
        assertEquals(1L, flightCreateDTO.getAdminId());
    }

    @Test
    void setAdminId() {
        flightCreateDTO.setAdminId(2L);
        assertEquals(2L, flightCreateDTO.getAdminId());
    }
}
