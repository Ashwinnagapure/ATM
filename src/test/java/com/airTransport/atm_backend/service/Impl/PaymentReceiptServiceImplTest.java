package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.PaymentReceiptDTO;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.model.Payment;
import com.airTransport.atm_backend.model.PaymentReceipt;
import com.airTransport.atm_backend.repository.PaymentReceiptRepository;
import com.airTransport.atm_backend.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentReceiptServiceImplTest {

    @Mock
    private PaymentReceiptRepository receiptRepository;

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentReceiptServiceImpl receiptService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPaymentReceipt() {
        PaymentReceiptDTO receiptDTO = new PaymentReceiptDTO();
        receiptDTO.setPaymentId(1L);

        Payment payment = new Payment();
        payment.setPaymentId(1L);

        PaymentReceipt receipt = new PaymentReceipt();
        receipt.setTransactionId(1L);
        receipt.setPayment(payment);

        when(paymentRepository.findById(receiptDTO.getPaymentId())).thenReturn(Optional.of(payment));
        when(receiptRepository.save(any(PaymentReceipt.class))).thenReturn(receipt);

        PaymentReceiptDTO result = receiptService.createPaymentReceipt(receiptDTO);

        assertNotNull(result);
        assertEquals(receipt.getTransactionId(), result.getTransactionId());
        verify(paymentRepository, times(1)).findById(receiptDTO.getPaymentId());
        verify(receiptRepository, times(1)).save(any(PaymentReceipt.class));
    }

    @Test
    void createReceiptForPayment() {
        Long paymentId = 1L;

        Payment payment = new Payment();
        payment.setPaymentId(paymentId);

        Booking booking = new Booking();
        booking.setId(10L);
        payment.setBooking(booking);

        PaymentReceipt receipt = new PaymentReceipt();
        receipt.setTransactionId(1L);
        receipt.setPayment(payment);
        receipt.setBooking(booking);

        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(payment));
        when(receiptRepository.save(any(PaymentReceipt.class))).thenReturn(receipt);

        PaymentReceiptDTO result = receiptService.createReceiptForPayment(paymentId);

        assertNotNull(result);
        assertEquals(receipt.getTransactionId(), result.getTransactionId());
        verify(paymentRepository, times(1)).findById(paymentId);
        verify(receiptRepository, times(1)).save(any(PaymentReceipt.class));
    }

    @Test
    void createReceiptForPayment_PaymentNotFound() {
        Long paymentId = 1L;

        when(paymentRepository.findById(paymentId)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            receiptService.createReceiptForPayment(paymentId);
        });

        assertEquals("Payment not found", exception.getMessage());
        verify(paymentRepository, times(1)).findById(paymentId);
        verify(receiptRepository, never()).save(any(PaymentReceipt.class));
    }

    @Test
    void getPaymentReceiptById() {
        Long receiptId = 1L;

        Payment payment = new Payment();
        payment.setPaymentId(1L);

        PaymentReceipt receipt = new PaymentReceipt();
        receipt.setTransactionId(receiptId);
        receipt.setPayment(payment);

        when(receiptRepository.findById(receiptId)).thenReturn(Optional.of(receipt));

        PaymentReceiptDTO result = receiptService.getPaymentReceiptById(receiptId);

        assertNotNull(result);
        assertEquals(receipt.getTransactionId(), result.getTransactionId());
        assertEquals(receipt.getPayment().getPaymentId(), result.getPaymentId());
        verify(receiptRepository, times(1)).findById(receiptId);
    }

    @Test
    void getPaymentReceiptById_NotFound() {
        Long receiptId = 1L;

        when(receiptRepository.findById(receiptId)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            receiptService.getPaymentReceiptById(receiptId);
        });

        assertEquals("Payment not found", exception.getMessage());
        verify(receiptRepository, times(1)).findById(receiptId);
    }
}
