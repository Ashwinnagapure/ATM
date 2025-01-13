package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.PaymentDTO;
import com.airTransport.atm_backend.model.enums.PaymentMethod;
import com.airTransport.atm_backend.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentControllerTest {

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private PaymentController paymentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPayment() {
        Long bookingId = 1L;

        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setAmount(1000.0);
        paymentDTO.setPaymentMethod(PaymentMethod.CREDIT_CARD);

        PaymentDTO createdPaymentDTO = new PaymentDTO();
        createdPaymentDTO.setPaymentId(1L);
        createdPaymentDTO.setAmount(1000.0);
        createdPaymentDTO.setPaymentMethod(PaymentMethod.CREDIT_CARD);

        when(paymentService.createPayment(paymentDTO, bookingId)).thenReturn(createdPaymentDTO);

        ResponseEntity<PaymentDTO> response = paymentController.createPayment(paymentDTO, bookingId);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(createdPaymentDTO.getPaymentId(), response.getBody().getPaymentId());
        verify(paymentService, times(1)).createPayment(paymentDTO, bookingId);
    }

    @Test
    void getPayment() {
        long paymentId = 1L;

        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setPaymentId(paymentId);
        paymentDTO.setAmount(1000.0);
        paymentDTO.setPaymentMethod(PaymentMethod.DEBIT_CARD);

        when(paymentService.getPaymentById(paymentId)).thenReturn(paymentDTO);

        ResponseEntity<PaymentDTO> response = paymentController.getPayment(paymentId);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(paymentId, response.getBody().getPaymentId());
        verify(paymentService, times(1)).getPaymentById(paymentId);
    }

    @Test
    void getPayment_NotFound() {
        long paymentId = 1L;

        when(paymentService.getPaymentById(paymentId)).thenReturn(null);

        ResponseEntity<PaymentDTO> response = paymentController.getPayment(paymentId);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(paymentService, times(1)).getPaymentById(paymentId);
    }
}
