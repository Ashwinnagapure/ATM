package com.airTransport.atm_backend.dto;

import com.airTransport.atm_backend.model.enums.PaymentMethod;
import com.airTransport.atm_backend.model.enums.PaymentStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentDTOTest {

    private PaymentDTO paymentDTO;

    @BeforeEach
    void setUp() {
        paymentDTO = new PaymentDTO();
        paymentDTO.setPaymentId(1L);
        paymentDTO.setAmount(100.50);
        paymentDTO.setPaymentMethod(PaymentMethod.CREDIT_CARD);
        paymentDTO.setPaymentStatus(PaymentStatus.SUCCESS);
        paymentDTO.setPaymentDate(LocalDate.of(2025, 1, 10));
    }

    @AfterEach
    void tearDown() {
        paymentDTO = null;
    }

    @Test
    void getPaymentId() {
        assertEquals(1L, paymentDTO.getPaymentId());
    }

    @Test
    void setPaymentId() {
        paymentDTO.setPaymentId(2L);
        assertEquals(2L, paymentDTO.getPaymentId());
    }

    @Test
    void getAmount() {
        assertEquals(100.50, paymentDTO.getAmount());
    }

    @Test
    void setAmount() {
        paymentDTO.setAmount(200.75);
        assertEquals(200.75, paymentDTO.getAmount());
    }

    @Test
    void getPaymentMethod() {
        assertEquals(PaymentMethod.CREDIT_CARD, paymentDTO.getPaymentMethod());
    }

    @Test
    void setPaymentMethod() {
        paymentDTO.setPaymentMethod(PaymentMethod.DEBIT_CARD);
        assertEquals(PaymentMethod.DEBIT_CARD, paymentDTO.getPaymentMethod());
    }

    @Test
    void getPaymentStatus() {
        assertEquals(PaymentStatus.SUCCESS, paymentDTO.getPaymentStatus());
    }

    @Test
    void setPaymentStatus() {
        paymentDTO.setPaymentStatus(PaymentStatus.FAILED);
        assertEquals(PaymentStatus.FAILED, paymentDTO.getPaymentStatus());
    }

    @Test
    void getPaymentDate() {
        assertEquals(LocalDate.of(2025, 1, 10), paymentDTO.getPaymentDate());
    }

    @Test
    void setPaymentDate() {
        paymentDTO.setPaymentDate(LocalDate.of(2025, 2, 15));
        assertEquals(LocalDate.of(2025, 2, 15), paymentDTO.getPaymentDate());
    }
}
