package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.PaymentDTO;
import com.airTransport.atm_backend.mapper.PaymentMapper;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.model.Payment;
import com.airTransport.atm_backend.model.enums.PaymentMethod;
import com.airTransport.atm_backend.model.enums.PaymentStatus;
import com.airTransport.atm_backend.repository.BookingRepository;
import com.airTransport.atm_backend.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentServiceImplTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void createPayment() {
//        Long bookingId = 1L;
//        PaymentDTO paymentDTO = new PaymentDTO();
//        paymentDTO.setAmount(100.0);
//        paymentDTO.setPaymentMethod(PaymentMethod.CREDIT_CARD);
//        paymentDTO.setPaymentStatus(PaymentStatus.PENDING);
//        paymentDTO.setPaymentDate(LocalDate.now());
//
//        Booking booking = new Booking();
//        booking.setId(bookingId);
//
//        Payment payment = new Payment();
//        payment.setPaymentId(1L);
//        payment.setAmount(paymentDTO.getAmount());
//        payment.setPaymentMethod(paymentDTO.getPaymentMethod());
//        payment.setPaymentStatus(paymentDTO.getPaymentStatus());
//        payment.setPaymentDate(paymentDTO.getPaymentDate());
//        payment.setBooking(booking);
//
//        when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(booking));
//        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);
//
//        PaymentDTO result = paymentService.createPayment(paymentDTO, bookingId);
//
//        assertNotNull(result);
//        assertEquals(payment.getPaymentId(), result.getPaymentId());
//        assertEquals(payment.getAmount(), result.getAmount());
//        assertEquals(payment.getPaymentMethod(), result.getPaymentMethod());
//        assertEquals(payment.getPaymentStatus(), result.getPaymentStatus());
//        assertEquals(payment.getPaymentDate(), result.getPaymentDate());
//        verify(bookingRepository, times(1)).findById(bookingId);
//        verify(paymentRepository, times(1)).save(any(Payment.class));
//    }

    @Test
    void createPayment_BookingNotFound() {
        Long bookingId = 1L;
        PaymentDTO paymentDTO = new PaymentDTO();

        when(bookingRepository.findById(bookingId)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            paymentService.createPayment(paymentDTO, bookingId);
        });

        assertEquals("Booking not found", exception.getMessage());
        verify(bookingRepository, times(1)).findById(bookingId);
        verify(paymentRepository, never()).save(any(Payment.class));
    }

//    @Test
//    void getPaymentById() {
//        Long paymentId = 1L;
//        Payment payment = new Payment();
//        payment.setPaymentId(paymentId);
//        payment.setAmount(100.0);
//        payment.setPaymentMethod(PaymentMethod.CREDIT_CARD);
//        payment.setPaymentStatus(PaymentStatus.SUCCESS);
//        payment.setPaymentDate(LocalDate.now());
//
//        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(payment));
//
//        PaymentDTO result = paymentService.getPaymentById(paymentId);
//
//        assertNotNull(result);
//        assertEquals(payment.getPaymentId(), result.getPaymentId());
//        assertEquals(payment.getAmount(), result.getAmount());
//        assertEquals(payment.getPaymentMethod(), result.getPaymentMethod());
//        assertEquals(payment.getPaymentStatus(), result.getPaymentStatus());
//        assertEquals(payment.getPaymentDate(), result.getPaymentDate());
//        verify(paymentRepository, times(1)).findById(paymentId);
//    }

    @Test
    void getPaymentById_NotFound() {
        Long paymentId = 1L;

        when(paymentRepository.findById(paymentId)).thenReturn(Optional.empty());

        PaymentDTO result = paymentService.getPaymentById(paymentId);

        assertNull(result);
        verify(paymentRepository, times(1)).findById(paymentId);
    }
}
