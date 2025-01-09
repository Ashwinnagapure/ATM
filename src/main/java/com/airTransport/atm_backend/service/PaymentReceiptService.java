package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.PaymentReceipt;

import java.util.List;

public interface PaymentReceiptService {
    PaymentReceipt generateReceiptForPayment(Long paymentId, String receiptDetails);
    PaymentReceipt getReceiptByTransactionId(Long transactionId);
    List<PaymentReceipt> getAllReceipts();
}
