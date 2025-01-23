package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.CreateSessionRequestDTO;
import com.airTransport.atm_backend.dto.SessionResponseDTO;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.model.Flight;
import com.airTransport.atm_backend.service.BookingService;
import com.airTransport.atm_backend.service.StripeCheckoutService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
public class PaymentController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private StripeCheckoutService stripeCheckoutService;

    /**
     * Proceed to payment for a specific booking.
     *
     * @param bookingId The ID of the booking to be paid for.
     * @return Stripe Checkout session URL.
     */
    @GetMapping("/proceed/{bookingId}")
    public ResponseEntity<SessionResponseDTO> proceedToPayment(@PathVariable Long bookingId) {
        try {
            // Fetch booking details
            Booking booking = bookingService.getBookingById(bookingId);

            if (booking == null || booking.getFlight() == null) {
                return ResponseEntity.badRequest().body(new SessionResponseDTO("Invalid booking or flight not linked."));
            }

            // Get flight details and calculate total amount
            Flight flight = booking.getFlight();
            double totalAmount = flight.getPrice() * booking.getTravellerCount()*100 ;

            // Create Stripe Checkout session
            CreateSessionRequestDTO sessionRequest = new CreateSessionRequestDTO();
            sessionRequest.setFlightName(flight.getFlightName());
            sessionRequest.setAmount((long) totalAmount);
            sessionRequest.setSuccessUrl("http://localhost:5173/success");
            sessionRequest.setCancelUrl("http://localhost:5173/cancel");

            SessionResponseDTO sessionResponse = stripeCheckoutService.createCheckoutSession(sessionRequest);
            return ResponseEntity.ok(sessionResponse);

        } catch (StripeException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new SessionResponseDTO("Error: " + e.getMessage()));
        }
    }
}
