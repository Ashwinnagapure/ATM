package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.PaymentDTO;
import com.airTransport.atm_backend.mapper.PaymentMapper;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.model.Payment;
import com.airTransport.atm_backend.repository.BookingRepository;
import com.airTransport.atm_backend.repository.PaymentRepository;
import com.airTransport.atm_backend.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, BookingRepository bookingRepository) {
        this.paymentRepository = paymentRepository;
        this.bookingRepository = bookingRepository;
    }



    @Override
    public PaymentDTO createPayment(PaymentDTO paymentDTO, Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Payment payment = PaymentMapper.toEntity(paymentDTO);
        payment.setBooking(booking);
        paymentRepository.save(payment);

        return PaymentMapper.toDTO(payment);
    }
    @Override
    public PaymentDTO getPaymentById(long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.map(PaymentMapper::toDTO).orElse(null);
    }
}
