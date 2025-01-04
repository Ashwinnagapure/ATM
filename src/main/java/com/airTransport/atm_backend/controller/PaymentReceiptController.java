package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.PaymentReceiptDTO;
import com.airTransport.atm_backend.mapper.PaymentReceiptMapper;
import com.airTransport.atm_backend.model.Payment;
import com.airTransport.atm_backend.model.PaymentReceipt;
import com.airTransport.atm_backend.repository.PaymentReceiptRepository;
import com.airTransport.atm_backend.repository.PaymentRepository;
import com.airTransport.atm_backend.service.PaymentReceiptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment-receipts")
public class PaymentReceiptController {

    private final PaymentReceiptService receiptService;


    public PaymentReceiptController(PaymentReceiptService receiptService, PaymentRepository paymentRepository, PaymentReceiptRepository paymentReceiptRepository) {
        this.receiptService = receiptService;

    }

    @PostMapping
    public ResponseEntity<PaymentReceiptDTO> createPaymentReceipt(@RequestBody PaymentReceiptDTO receiptDTO) {
        PaymentReceiptDTO createdReceipt = receiptService.createPaymentReceipt(receiptDTO);
        return ResponseEntity.ok(createdReceipt);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PaymentReceiptDTO> getPaymentReceipt(@PathVariable long id) {
        PaymentReceiptDTO receipt = receiptService.getPaymentReceiptById(id);
        return receipt != null ? ResponseEntity.ok(receipt) : ResponseEntity.notFound().build();
    }
}
