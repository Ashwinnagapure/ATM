package com.airTransport.atm_backend.mapper;

import com.airTransport.atm_backend.dto.PaymentDTO;
import com.airTransport.atm_backend.model.Payment;

public class PaymentMapper {
    public static PaymentDTO toDTO(Payment payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.setAmount(payment.getAmount());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setPaymentStatus(payment.getPaymentStatus());
        dto.setPaymentDate(payment.getPaymentDate());
        return dto;
    }

    public static Payment toEntity(PaymentDTO dto) {
        Payment payment = new Payment();
        payment.setAmount(dto.getAmount());
        payment.setPaymentMethod(dto.getPaymentMethod());
        payment.setPaymentStatus(dto.getPaymentStatus());
        payment.setPaymentDate(dto.getPaymentDate());
        return payment;
    }
}
