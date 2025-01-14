package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.Payment;
import com.airTransport.atm_backend.model.PaymentReceipt;
import com.airTransport.atm_backend.repository.PaymentReceiptRepository;
import com.airTransport.atm_backend.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentReceiptServiceImplTest {

    @InjectMocks
    private PaymentReceiptServiceImpl receiptService;

    @Mock
    private PaymentReceiptRepository receiptRepository;

    @Mock
    private PaymentRepository paymentRepository;

    private Payment payment;
    private PaymentReceipt receipt;

    @BeforeEach
    void setUp() {
        payment = new Payment();
        payment.setId(1L);
        payment.setAmount(100.0);
        payment.setStatus("COMPLETED");

        receipt = new PaymentReceipt();
        receipt.setTransactionId(1L);
        receipt.setPayment(payment);
        receipt.setReceiptDetails("Receipt Details");
    }

    @Test
    void testGenerateReceiptForPayment() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));
        when(receiptRepository.save(any(PaymentReceipt.class))).thenReturn(receipt);

        PaymentReceipt result = receiptService.generateReceiptForPayment(1L, "Receipt Details");

        assertNotNull(result);
        assertEquals("Receipt Details", result.getReceiptDetails());
        assertEquals(1L, result.getPayment().getId());
        verify(receiptRepository, times(1)).save(any(PaymentReceipt.class));
    }

    @Test
    void testGenerateReceiptForPayment_PaymentNotFound() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> receiptService.generateReceiptForPayment(1L, "Receipt Details"));
        verify(receiptRepository, never()).save(any(PaymentReceipt.class));
    }

    @Test
    void testGetReceiptByTransactionId() {
        when(receiptRepository.findById(1L)).thenReturn(Optional.of(receipt));

        PaymentReceipt result = receiptService.getReceiptByTransactionId(1L);

        assertNotNull(result);
        assertEquals("Receipt Details", result.getReceiptDetails());
        assertEquals(1L, result.getTransactionId());
    }

    @Test
    void testGetReceiptByTransactionId_NotFound() {
        when(receiptRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> receiptService.getReceiptByTransactionId(1L));
    }

    @Test
    void testGetAllReceipts() {
        when(receiptRepository.findAll()).thenReturn(Arrays.asList(receipt));

        List<PaymentReceipt> result = receiptService.getAllReceipts();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Receipt Details", result.get(0).getReceiptDetails());
    }

    @Test
    void testGetAllReceipts_EmptyList() {
        when(receiptRepository.findAll()).thenReturn(Arrays.asList());

        List<PaymentReceipt> result = receiptService.getAllReceipts();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
