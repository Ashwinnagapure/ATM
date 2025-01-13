package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaggageDTOTest {

    @Test
    void testBaggageDTO() {
        BaggageDTO dto = new BaggageDTO();
        dto.setId(1L);
        dto.setWeight(20.0);
        dto.setIsOverweight(false);
        dto.setBookingId(10L);

        assertEquals(1L, dto.getId());
        assertEquals(20.0, dto.getWeight());
        assertFalse(dto.getIsOverweight());
        assertEquals(10L, dto.getBookingId());
    }
}
