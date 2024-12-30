package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.PaymentReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentReceiptRepository extends JpaRepository<PaymentReceipt, Long> {
}
