package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.PaymentReceiptDTO;

public interface PaymentReceiptService {
    PaymentReceiptDTO createPaymentReceipt(PaymentReceiptDTO receiptDTO);

    PaymentReceiptDTO createReceiptForPayment(Long paymentId);

    PaymentReceiptDTO getPaymentReceiptById(long id);
}
