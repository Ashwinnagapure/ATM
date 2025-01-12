package com.airTransport.atm_backend.dto;

import com.airTransport.atm_backend.model.Flight.FlightStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FlightResponseDTOTest {

    private FlightResponseDTO flightResponseDTO;

    @BeforeEach
    void setUp() {
        flightResponseDTO = new FlightResponseDTO();
        flightResponseDTO.setFlightId(1L);
        flightResponseDTO.setFlightName("Flight 202");
        flightResponseDTO.setDeparture(LocalDateTime.of(2025, 2, 10, 8, 0));
        flightResponseDTO.setArrival(LocalDateTime.of(2025, 2, 10, 10, 0));
        flightResponseDTO.setStatus(FlightStatus.ON_TIME);
        flightResponseDTO.setSource("London");
        flightResponseDTO.setDestination("Paris");
        flightResponseDTO.setPrice(500.0);
        flightResponseDTO.setAirline("SkyAir");
        flightResponseDTO.setFlightClass("Economy");
    }

    @AfterEach
    void tearDown() {
        flightResponseDTO = null;
    }

    @Test
    void getFlightId() {
        assertEquals(1L, flightResponseDTO.getFlightId());
    }

    @Test
    void setFlightId() {
        flightResponseDTO.setFlightId(2L);
        assertEquals(2L, flightResponseDTO.getFlightId());
    }

    @Test
    void getFlightName() {
        assertEquals("Flight 202", flightResponseDTO.getFlightName());
    }

    @Test
    void setFlightName() {
        flightResponseDTO.setFlightName("Flight 303");
        assertEquals("Flight 303", flightResponseDTO.getFlightName());
    }

    @Test
    void getDeparture() {
        assertEquals(LocalDateTime.of(2025, 2, 10, 8, 0), flightResponseDTO.getDeparture());
    }

    @Test
    void setDeparture() {
        LocalDateTime newDeparture = LocalDateTime.of(2025, 2, 11, 9, 0);
        flightResponseDTO.setDeparture(newDeparture);
        assertEquals(newDeparture, flightResponseDTO.getDeparture());
    }

    @Test
    void getArrival() {
        assertEquals(LocalDateTime.of(2025, 2, 10, 10, 0), flightResponseDTO.getArrival());
    }

    @Test
    void setArrival() {
        LocalDateTime newArrival = LocalDateTime.of(2025, 2, 10, 12, 0);
        flightResponseDTO.setArrival(newArrival);
        assertEquals(newArrival, flightResponseDTO.getArrival());
    }

    @Test
    void getStatus() {
        assertEquals(FlightStatus.ON_TIME, flightResponseDTO.getStatus());
    }

    @Test
    void setStatus() {
        flightResponseDTO.setStatus(FlightStatus.CANCELLED);
        assertEquals(FlightStatus.CANCELLED, flightResponseDTO.getStatus());
    }

    @Test
    void getSource() {
        assertEquals("London", flightResponseDTO.getSource());
    }

    @Test
    void setSource() {
        flightResponseDTO.setSource("Berlin");
        assertEquals("Berlin", flightResponseDTO.getSource());
    }

    @Test
    void getDestination() {
        assertEquals("Paris", flightResponseDTO.getDestination());
    }

    @Test
    void setDestination() {
        flightResponseDTO.setDestination("Rome");
        assertEquals("Rome", flightResponseDTO.getDestination());
    }

    @Test
    void getPrice() {
        assertEquals(500.0, flightResponseDTO.getPrice());
    }

    @Test
    void setPrice() {
        flightResponseDTO.setPrice(550.0);
        assertEquals(550.0, flightResponseDTO.getPrice());
    }

    @Test
    void getAirline() {
        assertEquals("SkyAir", flightResponseDTO.getAirline());
    }

    @Test
    void setAirline() {
        flightResponseDTO.setAirline("FlyHigh");
        assertEquals("FlyHigh", flightResponseDTO.getAirline());
    }

    @Test
    void getFlightClass() {
        assertEquals("Economy", flightResponseDTO.getFlightClass());
    }

    @Test
    void setFlightClass() {
        flightResponseDTO.setFlightClass("Business");
        assertEquals("Business", flightResponseDTO.getFlightClass());
    }
}
