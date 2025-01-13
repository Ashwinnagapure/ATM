package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerDTOTest {

    @Test
    void testPassengerDTO() {
        PassengerDTO dto = new PassengerDTO();
        dto.setId(1L);
        dto.setName("John Doe");
        dto.setEmail("john@example.com");
        dto.setPhone("1234567890");
        dto.setBookingId(10L);

        assertEquals(1L, dto.getId());
        assertEquals("John Doe", dto.getName());
        assertEquals("john@example.com", dto.getEmail());
        assertEquals("1234567890", dto.getPhone());
        assertEquals(10L, dto.getBookingId());
    }
}
