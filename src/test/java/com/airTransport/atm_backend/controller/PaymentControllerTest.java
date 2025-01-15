package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.PaymentDTO;
import com.airTransport.atm_backend.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PaymentControllerTest {

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private PaymentController paymentController;

    public PaymentControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPayment_Success() {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setAmount(100.0);
        paymentDTO.setStatus("COMPLETED");

        when(paymentService.createPayment(any(PaymentDTO.class))).thenReturn(paymentDTO);

        ResponseEntity<PaymentDTO> response = paymentController.createPayment(paymentDTO);

        assertEquals(200, response.getStatusCodeValue());
        verify(paymentService, times(1)).createPayment(paymentDTO);
    }

    @Test
    void getAllPayments_Success() {
        List<PaymentDTO> payments = new ArrayList<>();
        payments.add(new PaymentDTO());
        payments.add(new PaymentDTO());

        when(paymentService.getAllPayments()).thenReturn(payments);

        ResponseEntity<List<PaymentDTO>> response = paymentController.getAllPayments();

        assertEquals(2, response.getBody().size());
        verify(paymentService, times(1)).getAllPayments();
    }
}
