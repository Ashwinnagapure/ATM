package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.PaymentDTO;
import com.airTransport.atm_backend.mapper.PaymentMapper;
import com.airTransport.atm_backend.model.Payment;
import com.airTransport.atm_backend.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
        Payment payment = PaymentMapper.toEntity(paymentDTO);
        paymentRepository.save(payment);
        return PaymentMapper.toDTO(payment);
    }

    public PaymentDTO getPaymentById(long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.map(PaymentMapper::toDTO).orElse(null);
    }
}
