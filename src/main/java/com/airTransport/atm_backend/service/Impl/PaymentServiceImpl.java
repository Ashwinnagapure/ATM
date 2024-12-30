package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.PaymentDTO;
import com.airTransport.atm_backend.mapper.PaymentMapper;
import com.airTransport.atm_backend.model.Payment;
import com.airTransport.atm_backend.repository.PaymentRepository;
import com.airTransport.atm_backend.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
        Payment payment = PaymentMapper.toEntity(paymentDTO);
        paymentRepository.save(payment);
        return PaymentMapper.toDTO(payment);
    }

    @Override
    public PaymentDTO getPaymentById(long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.map(PaymentMapper::toDTO).orElse(null);
    }
}
