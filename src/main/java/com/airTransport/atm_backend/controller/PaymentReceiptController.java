package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.PaymentReceipt;
import com.airTransport.atm_backend.service.PaymentReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-receipts")
public class PaymentReceiptController {

    @Value("${CORS}")
    private String corsUrl;

    @Autowired
    private PaymentReceiptService receiptService;

    /**
     * Generate receipt for payment by paymentId.
     *
     * @param paymentId The payment ID.
     * @param receiptDetails Receipt details.
     * @return The generated payment receipt.
     */
    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @PostMapping("/{paymentId}")
    public ResponseEntity<PaymentReceipt> generateReceiptForPayment(
            @PathVariable Long paymentId, @RequestBody String receiptDetails) {
        PaymentReceipt receipt = receiptService.generateReceiptForPayment(paymentId, receiptDetails);
        return ResponseEntity.ok(receipt);
    }

    /**
     * Get all payment receipts.
     *
     * @return List of all payment receipts.
     */
    @CrossOrigin(origins = "${CORS}", allowCredentials = "true")
    @GetMapping
    public ResponseEntity<List<PaymentReceipt>> getAllReceipts() {
        return ResponseEntity.ok(receiptService.getAllReceipts());
    }
}
