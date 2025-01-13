package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardingPassDTOTest {

    @Test
    void testGettersAndSetters() {
        BoardingPassDTO boardingPassDTO = new BoardingPassDTO();

        // Set values
        boardingPassDTO.setId(1L);
        boardingPassDTO.setGate("A1");
        boardingPassDTO.setSeatNumber("12B");
        boardingPassDTO.setBookingId(100L);

        // Validate the values using getters
        assertEquals(1L, boardingPassDTO.getId());
        assertEquals("A1", boardingPassDTO.getGate());
        assertEquals("12B", boardingPassDTO.getSeatNumber());
        assertEquals(100L, boardingPassDTO.getBookingId());
    }
}
