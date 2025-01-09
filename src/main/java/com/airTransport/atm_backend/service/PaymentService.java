package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment processPayment(Payment payment);
    Payment getPaymentById(Long id);
    List<Payment> getAllPayments();
    Payment updatePayment(Long id, Payment updatedPayment);
    void deletePayment(Long id);
}
