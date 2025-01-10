package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentReceiptDTOTest {

    private PaymentReceiptDTO paymentReceiptDTO;

    @BeforeEach
    void setUp() {
        paymentReceiptDTO = new PaymentReceiptDTO();
        paymentReceiptDTO.setTransactionId(1001L);
        paymentReceiptDTO.setPaymentId(5001L);
    }

    @AfterEach
    void tearDown() {
        paymentReceiptDTO = null;
    }

    @Test
    void getTransactionId() {
        assertEquals(1001L, paymentReceiptDTO.getTransactionId());
    }

    @Test
    void setTransactionId() {
        paymentReceiptDTO.setTransactionId(1002L);
        assertEquals(1002L, paymentReceiptDTO.getTransactionId());
    }

    @Test
    void getPaymentId() {
        assertEquals(5001L, paymentReceiptDTO.getPaymentId());
    }

    @Test
    void setPaymentId() {
        paymentReceiptDTO.setPaymentId(5002L);
        assertEquals(5002L, paymentReceiptDTO.getPaymentId());
    }
}
