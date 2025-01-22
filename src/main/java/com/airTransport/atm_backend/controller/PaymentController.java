package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.CreateSessionRequestDTO;
import com.airTransport.atm_backend.dto.SessionResponseDTO;
import com.airTransport.atm_backend.service.StripeCheckoutService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class PaymentController {

    @Autowired
    private StripeCheckoutService stripeCheckoutService;

    /**
     * Endpoint to create a Stripe Checkout Session.
     *
     * @param request the session creation details
     * @return ResponseEntity containing the SessionResponseDTO with the session URL
     */
    @PostMapping("/stripe/create-checkout-session")
    public ResponseEntity<SessionResponseDTO> createCheckoutSession(@RequestBody CreateSessionRequestDTO request) {
        try {
            SessionResponseDTO response = stripeCheckoutService.createCheckoutSession(request);
            return ResponseEntity.ok(response);
        } catch (StripeException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new SessionResponseDTO("Error: " + e.getMessage()));
        }
    }
}
