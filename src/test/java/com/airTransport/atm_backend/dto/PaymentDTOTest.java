package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentDTOTest {

    @Test
    void testGettersAndSetters() {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(1L);
        dto.setAmount(100.0);
        dto.setStatus("COMPLETED");
        dto.setBookingId(1L);

        assertEquals(1L, dto.getId());
        assertEquals(100.0, dto.getAmount());
        assertEquals("COMPLETED", dto.getStatus());
        assertEquals(1L, dto.getBookingId());
    }
}
