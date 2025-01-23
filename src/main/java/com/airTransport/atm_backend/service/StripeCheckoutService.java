package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.CreateSessionRequestDTO;
import com.airTransport.atm_backend.dto.SessionResponseDTO;
import com.stripe.exception.StripeException;

public interface StripeCheckoutService {
    /**
     * Creates a Stripe Checkout session.
     *
     * @param request the session creation details
     * @return SessionResponseDTO containing the session URL
     * @throws StripeException if there is an error with Stripe API
     */
    SessionResponseDTO createCheckoutSession(CreateSessionRequestDTO request) throws StripeException;
}
