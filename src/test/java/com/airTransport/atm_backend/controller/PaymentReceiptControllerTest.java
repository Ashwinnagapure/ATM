package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.PaymentReceiptDTO;
import com.airTransport.atm_backend.service.PaymentReceiptService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentReceiptControllerTest {

    @Mock
    private PaymentReceiptService receiptService;

    @InjectMocks
    private PaymentReceiptController receiptController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPaymentReceipt() {
        PaymentReceiptDTO receiptDTO = new PaymentReceiptDTO();
        receiptDTO.setPaymentId(1L);

        PaymentReceiptDTO createdReceiptDTO = new PaymentReceiptDTO();
        createdReceiptDTO.setTransactionId(1L);
        createdReceiptDTO.setPaymentId(1L);

        when(receiptService.createPaymentReceipt(receiptDTO)).thenReturn(createdReceiptDTO);

        ResponseEntity<PaymentReceiptDTO> response = receiptController.createPaymentReceipt(receiptDTO);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(createdReceiptDTO.getTransactionId(), response.getBody().getTransactionId());
        verify(receiptService, times(1)).createPaymentReceipt(receiptDTO);
    }

    @Test
    void getPaymentReceipt() {
        long receiptId = 1L;

        PaymentReceiptDTO receiptDTO = new PaymentReceiptDTO();
        receiptDTO.setTransactionId(receiptId);
        receiptDTO.setPaymentId(1L);

        when(receiptService.getPaymentReceiptById(receiptId)).thenReturn(receiptDTO);

        ResponseEntity<PaymentReceiptDTO> response = receiptController.getPaymentReceipt(receiptId);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(receiptId, response.getBody().getTransactionId());
        verify(receiptService, times(1)).getPaymentReceiptById(receiptId);
    }

    @Test
    void getPaymentReceipt_NotFound() {
        long receiptId = 1L;

        when(receiptService.getPaymentReceiptById(receiptId)).thenReturn(null);

        ResponseEntity<PaymentReceiptDTO> response = receiptController.getPaymentReceipt(receiptId);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(receiptService, times(1)).getPaymentReceiptById(receiptId);
    }
}
