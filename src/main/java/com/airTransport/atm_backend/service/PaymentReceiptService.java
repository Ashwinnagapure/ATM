package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.PaymentReceiptDTO;

public interface PaymentReceiptService {
    PaymentReceiptDTO createPaymentReceipt(PaymentReceiptDTO receiptDTO);

    PaymentReceiptDTO getPaymentReceiptById(long id);
}
