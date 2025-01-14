package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentReceiptDTOTest {

    @Test
    void testGettersAndSetters() {
        PaymentReceiptDTO dto = new PaymentReceiptDTO();

        dto.setTransactionId(1001L);
        dto.setPaymentId(2002L);

        assertEquals(1001L, dto.getTransactionId());
        assertEquals(2002L, dto.getPaymentId());
    }

    @Test
    void testDefaultConstructor() {
        PaymentReceiptDTO dto = new PaymentReceiptDTO();
        assertNotNull(dto);
    }
}
