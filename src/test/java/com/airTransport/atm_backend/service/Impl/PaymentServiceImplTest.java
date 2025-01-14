package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.PaymentDTO;
import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.model.Payment;
import com.airTransport.atm_backend.repository.BookingRepository;
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
class PaymentServiceImplTest {

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private BookingRepository bookingRepository;

    private Payment payment;
    private Booking booking;
    private PaymentDTO paymentDTO;

    @BeforeEach
    void setUp() {
        booking = new Booking();
        booking.setId(1L);

        payment = new Payment();
        payment.setId(1L);
        payment.setAmount(100.0);
        payment.setStatus("COMPLETED");
        payment.setBooking(booking);

        paymentDTO = new PaymentDTO();
        paymentDTO.setId(1L);
        paymentDTO.setAmount(100.0);
        paymentDTO.setStatus("COMPLETED");
        paymentDTO.setBookingId(1L);
    }

    @Test
    void testCreatePayment() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        PaymentDTO result = paymentService.createPayment(paymentDTO);

        assertNotNull(result);
        assertEquals(paymentDTO.getAmount(), result.getAmount());
        assertEquals(paymentDTO.getStatus(), result.getStatus());
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    void testCreatePayment_BookingNotFound() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> paymentService.createPayment(paymentDTO));
        verify(paymentRepository, never()).save(any(Payment.class));
    }

    @Test
    void testUpdatePayment() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        PaymentDTO result = paymentService.updatePayment(1L, paymentDTO);

        assertNotNull(result);
        assertEquals(paymentDTO.getAmount(), result.getAmount());
        assertEquals(paymentDTO.getStatus(), result.getStatus());
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    void testUpdatePayment_PaymentNotFound() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> paymentService.updatePayment(1L, paymentDTO));
        verify(paymentRepository, never()).save(any(Payment.class));
    }

    @Test
    void testUpdatePayment_BookingNotFound() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));
        when(bookingRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> paymentService.updatePayment(1L, paymentDTO));
        verify(paymentRepository, never()).save(any(Payment.class));
    }

    @Test
    void testDeletePayment() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));

        paymentService.deletePayment(1L);

        verify(paymentRepository, times(1)).delete(payment);
    }

    @Test
    void testDeletePayment_PaymentNotFound() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> paymentService.deletePayment(1L));
        verify(paymentRepository, never()).delete(any(Payment.class));
    }

    @Test
    void testGetPaymentById() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));

        PaymentDTO result = paymentService.getPaymentById(1L);

        assertNotNull(result);
        assertEquals(paymentDTO.getAmount(), result.getAmount());
        assertEquals(paymentDTO.getStatus(), result.getStatus());
    }

    @Test
    void testGetPaymentById_PaymentNotFound() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> paymentService.getPaymentById(1L));
    }

    @Test
    void testGetAllPayments() {
        when(paymentRepository.findAll()).thenReturn(Arrays.asList(payment));

        List<PaymentDTO> result = paymentService.getAllPayments();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(paymentDTO.getAmount(), result.get(0).getAmount());
    }

    @Test
    void testGetAllPayments_EmptyList() {
        when(paymentRepository.findAll()).thenReturn(Arrays.asList());

        List<PaymentDTO> result = paymentService.getAllPayments();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
