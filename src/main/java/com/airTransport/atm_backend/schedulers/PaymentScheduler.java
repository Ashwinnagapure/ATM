package com.airTransport.atm_backend.schedulers;

import com.airTransport.atm_backend.repository.PaymentRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PaymentScheduler {

    private final PaymentRepository paymentRepository;

    public PaymentScheduler(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void processPendingRefunds() {
        // Logic to process pending refunds daily
    }
}
