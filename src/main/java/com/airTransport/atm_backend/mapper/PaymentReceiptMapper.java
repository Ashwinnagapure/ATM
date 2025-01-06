package com.airTransport.atm_backend.mapper;

import com.airTransport.atm_backend.dto.PaymentReceiptDTO;
import com.airTransport.atm_backend.model.PaymentReceipt;

public class PaymentReceiptMapper {

    public static PaymentReceiptDTO toDTO(PaymentReceipt receipt) {
        PaymentReceiptDTO dto = new PaymentReceiptDTO();
        dto.setTransactionId(receipt.getTransactionId());
        dto.setPaymentId(receipt.getPayment().getPaymentId());
        return dto;
    }

    public static PaymentReceipt toEntity(PaymentReceiptDTO dto) {
        PaymentReceipt receipt = new PaymentReceipt();
        receipt.setTransactionId(dto.getTransactionId());
        // Payment must be fetched and set in the service layer
        return receipt;
    }
}
