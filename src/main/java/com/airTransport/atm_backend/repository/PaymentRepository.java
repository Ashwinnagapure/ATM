package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
