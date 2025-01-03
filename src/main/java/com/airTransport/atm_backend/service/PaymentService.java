package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.PaymentDTO;

public interface PaymentService {



    PaymentDTO createPayment(PaymentDTO paymentDTO, Long bookingId);

    PaymentDTO getPaymentById(long id);
}
