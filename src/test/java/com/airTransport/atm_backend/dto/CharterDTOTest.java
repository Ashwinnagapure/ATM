package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharterDTOTest {

    @Test
    void testGettersAndSetters() {
        CharterDTO charterDTO = new CharterDTO(1L, "Helicopter", 5000.0, "John Doe", "FL123");

        // Verify getters
        assertEquals(1L, charterDTO.getCharterId());
        assertEquals("Helicopter", charterDTO.getVehicleType());
        assertEquals(5000.0, charterDTO.getPrice());
        assertEquals("John Doe", charterDTO.getPassengerName());
        assertEquals("FL123", charterDTO.getFlightNumber());

        // Verify setters
        charterDTO.setCharterId(2L);
        charterDTO.setVehicleType("Private Jet");
        charterDTO.setPrice(10000.0);
        charterDTO.setPassengerName("Jane Doe");
        charterDTO.setFlightNumber("FL456");

        assertEquals(2L, charterDTO.getCharterId());
        assertEquals("Private Jet", charterDTO.getVehicleType());
        assertEquals(10000.0, charterDTO.getPrice());
        assertEquals("Jane Doe", charterDTO.getPassengerName());
        assertEquals("FL456", charterDTO.getFlightNumber());
    }
}
