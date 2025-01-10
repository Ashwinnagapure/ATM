package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharterDTOTest {

    private CharterDTO charterDTO;

    @BeforeEach
    void setUp() {
        charterDTO = new CharterDTO(1L, "Helicopter", 15000.0, "John Doe", "FL123");
    }

    @AfterEach
    void tearDown() {
        charterDTO = null;
    }

    @Test
    void getCharterId() {
        assertEquals(1L, charterDTO.getCharterId());
    }

    @Test
    void setCharterId() {
        charterDTO.setCharterId(2L);
        assertEquals(2L, charterDTO.getCharterId());
    }

    @Test
    void getVehicleType() {
        assertEquals("Helicopter", charterDTO.getVehicleType());
    }

    @Test
    void setVehicleType() {
        charterDTO.setVehicleType("Private Jet");
        assertEquals("Private Jet", charterDTO.getVehicleType());
    }

    @Test
    void getPrice() {
        assertEquals(15000.0, charterDTO.getPrice());
    }

    @Test
    void setPrice() {
        charterDTO.setPrice(20000.0);
        assertEquals(20000.0, charterDTO.getPrice());
    }

    @Test
    void getPassengerName() {
        assertEquals("John Doe", charterDTO.getPassengerName());
    }

    @Test
    void setPassengerName() {
        charterDTO.setPassengerName("Jane Doe");
        assertEquals("Jane Doe", charterDTO.getPassengerName());
    }

    @Test
    void getFlightNumber() {
        assertEquals("FL123", charterDTO.getFlightNumber());
    }

    @Test
    void setFlightNumber() {
        charterDTO.setFlightNumber("FL456");
        assertEquals("FL456", charterDTO.getFlightNumber());
    }
}
