package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.PaymentReceiptDTO;
import com.airTransport.atm_backend.mapper.PaymentReceiptMapper;
import com.airTransport.atm_backend.model.Payment;
import com.airTransport.atm_backend.model.PaymentReceipt;
import com.airTransport.atm_backend.repository.PaymentReceiptRepository;
import com.airTransport.atm_backend.repository.PaymentRepository;
import com.airTransport.atm_backend.service.PaymentReceiptService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentReceiptServiceImpl implements PaymentReceiptService {

    private final PaymentReceiptRepository receiptRepository;
    private final PaymentRepository paymentRepository;

    public PaymentReceiptServiceImpl(PaymentReceiptRepository receiptRepository, PaymentRepository paymentRepository) {
        this.receiptRepository = receiptRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentReceiptDTO createPaymentReceipt(PaymentReceiptDTO receiptDTO) {
        PaymentReceipt receipt = PaymentReceiptMapper.toEntity(receiptDTO);
        Optional<Payment> payment = paymentRepository.findById(receiptDTO.getPaymentId());
        payment.ifPresent(receipt::setPayment);
        receiptRepository.save(receipt);
        return PaymentReceiptMapper.toDTO(receipt);
    }

    @Override
    public PaymentReceiptDTO getPaymentReceiptById(long id) {
        Optional<PaymentReceipt> receipt = receiptRepository.findById(id);
        return receipt.map(PaymentReceiptMapper::toDTO).orElseThrow(() -> new RuntimeException("Payment not found"));
    }
}
