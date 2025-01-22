package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.CreateSessionRequestDTO;
import com.airTransport.atm_backend.dto.SessionResponseDTO;
import com.stripe.exception.StripeException;

public interface StripeCheckoutService {
    SessionResponseDTO createCheckoutSession(CreateSessionRequestDTO request) throws StripeException;
}
