package com.airTransport.atm_backend.dto;

import com.airTransport.atm_backend.model.Flight.FlightStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FlightDTOTest {

    private FlightDTO flightDTO;

    @BeforeEach
    void setUp() {
        flightDTO = new FlightDTO();
        flightDTO.setFlightName("Flight 202");
        flightDTO.setDeparture(LocalDateTime.of(2025, 2, 10, 8, 0));
        flightDTO.setArrival(LocalDateTime.of(2025, 2, 10, 10, 0));
        flightDTO.setStatus(FlightStatus.ON_TIME);
        flightDTO.setSource("London");
        flightDTO.setDestination("Paris");
        flightDTO.setPrice(500.0);
        flightDTO.setAirline("SkyAir");
        flightDTO.setFlightClass("Economy");
        flightDTO.setAdminId(1L);
    }

    @AfterEach
    void tearDown() {
        flightDTO = null;
    }

    @Test
    void getFlightName() {
        assertEquals("Flight 202", flightDTO.getFlightName());
    }

    @Test
    void setFlightName() {
        flightDTO.setFlightName("Flight 303");
        assertEquals("Flight 303", flightDTO.getFlightName());
    }

    @Test
    void getDeparture() {
        assertEquals(LocalDateTime.of(2025, 2, 10, 8, 0), flightDTO.getDeparture());
    }

    @Test
    void setDeparture() {
        LocalDateTime newDeparture = LocalDateTime.of(2025, 2, 11, 9, 0);
        flightDTO.setDeparture(newDeparture);
        assertEquals(newDeparture, flightDTO.getDeparture());
    }

    @Test
    void getArrival() {
        assertEquals(LocalDateTime.of(2025, 2, 10, 10, 0), flightDTO.getArrival());
    }

    @Test
    void setArrival() {
        LocalDateTime newArrival = LocalDateTime.of(2025, 2, 10, 12, 0);
        flightDTO.setArrival(newArrival);
        assertEquals(newArrival, flightDTO.getArrival());
    }

    @Test
    void getStatus() {
        assertEquals(FlightStatus.ON_TIME, flightDTO.getStatus());
    }

    @Test
    void setStatus() {
        flightDTO.setStatus(FlightStatus.CANCELLED);
        assertEquals(FlightStatus.CANCELLED, flightDTO.getStatus());
    }

    @Test
    void getSource() {
        assertEquals("London", flightDTO.getSource());
    }

    @Test
    void setSource() {
        flightDTO.setSource("Berlin");
        assertEquals("Berlin", flightDTO.getSource());
    }

    @Test
    void getDestination() {
        assertEquals("Paris", flightDTO.getDestination());
    }

    @Test
    void setDestination() {
        flightDTO.setDestination("Rome");
        assertEquals("Rome", flightDTO.getDestination());
    }

    @Test
    void getPrice() {
        assertEquals(500.0, flightDTO.getPrice());
    }

    @Test
    void setPrice() {
        flightDTO.setPrice(550.0);
        assertEquals(550.0, flightDTO.getPrice());
    }

    @Test
    void getAirline() {
        assertEquals("SkyAir", flightDTO.getAirline());
    }

    @Test
    void setAirline() {
        flightDTO.setAirline("FlyHigh");
        assertEquals("FlyHigh", flightDTO.getAirline());
    }

    @Test
    void getFlightClass() {
        assertEquals("Economy", flightDTO.getFlightClass());
    }

    @Test
    void setFlightClass() {
        flightDTO.setFlightClass("Business");
        assertEquals("Business", flightDTO.getFlightClass());
    }

    @Test
    void getAdminId() {
        assertEquals(1L, flightDTO.getAdminId());
    }

    @Test
    void setAdminId() {
        flightDTO.setAdminId(2L);
        assertEquals(2L, flightDTO.getAdminId());
    }
}
