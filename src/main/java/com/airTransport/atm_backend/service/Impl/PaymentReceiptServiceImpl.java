package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.Payment;
import com.airTransport.atm_backend.model.PaymentReceipt;
import com.airTransport.atm_backend.repository.PaymentReceiptRepository;
import com.airTransport.atm_backend.repository.PaymentRepository;
import com.airTransport.atm_backend.service.PaymentReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentReceiptServiceImpl implements PaymentReceiptService {

    @Autowired
    private PaymentReceiptRepository receiptRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public PaymentReceipt generateReceiptForPayment(Long paymentId, String receiptDetails) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new NotFoundException("Payment not found with ID: " + paymentId));

        PaymentReceipt receipt = new PaymentReceipt();
        receipt.setPayment(payment);
        receipt.setReceiptDetails(receiptDetails);

        return receiptRepository.save(receipt);
    }

    @Override
    public PaymentReceipt getReceiptByTransactionId(Long transactionId) {
        return receiptRepository.findById(transactionId)
                .orElseThrow(() -> new NotFoundException("Payment Receipt not found with Transaction ID: " + transactionId));
    }

    @Override
    public List<PaymentReceipt> getAllReceipts() {
        return receiptRepository.findAll();
    }
}
