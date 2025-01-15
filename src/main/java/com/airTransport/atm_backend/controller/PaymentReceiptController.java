package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.PaymentReceipt;
import com.airTransport.atm_backend.service.PaymentReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-receipts")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class PaymentReceiptController {

    @Autowired
    private PaymentReceiptService receiptService;

    @PostMapping("/{paymentId}")
    public ResponseEntity<PaymentReceipt> generateReceiptForPayment(@PathVariable Long paymentId, @RequestBody String receiptDetails) {
        PaymentReceipt receipt = receiptService.generateReceiptForPayment(paymentId, receiptDetails);
        return ResponseEntity.ok(receipt);
    }

//    @GetMapping("/{transactionId}")
//    public ResponseEntity<PaymentReceipt> getReceiptByTransactionId(@PathVariable Long transactionId) {
//        PaymentReceipt receipt = receiptService.getReceiptByTransactionId(transactionId);
//        return ResponseEntity.ok(receipt);
//    }



    @GetMapping
    public ResponseEntity<List<PaymentReceipt>> getAllReceipts() {
        return ResponseEntity.ok(receiptService.getAllReceipts());
    }
}
