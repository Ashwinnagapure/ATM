package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.PaymentDTO;
import com.airTransport.atm_backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
public class PaymentController {



    private PaymentService paymentService;

    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @PostMapping
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO) {
        return ResponseEntity.ok(paymentService.createPayment(paymentDTO));
    }

    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getPaymentById(id));
    }

    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @GetMapping
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @PutMapping("/{id}")
    public ResponseEntity<PaymentDTO> updatePayment(@PathVariable Long id, @RequestBody PaymentDTO paymentDTO) {
        return ResponseEntity.ok(paymentService.updatePayment(id, paymentDTO));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
//        paymentService.deletePayment(id);
//        return ResponseEntity.ok("Deleted payment with id " + id);
//    }
}
