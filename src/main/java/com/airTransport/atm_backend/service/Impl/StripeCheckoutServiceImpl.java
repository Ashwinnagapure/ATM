package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.CreateSessionRequestDTO;
import com.airTransport.atm_backend.dto.SessionResponseDTO;
import com.airTransport.atm_backend.service.StripeCheckoutService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StripeCheckoutServiceImpl implements StripeCheckoutService {

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @Override
    public SessionResponseDTO createCheckoutSession(CreateSessionRequestDTO request) throws StripeException {
        // Build the line item
        List<SessionCreateParams.LineItem> lineItems = new ArrayList<>();
        lineItems.add(
                SessionCreateParams.LineItem.builder()
                        .setQuantity(1L)
                        .setPriceData(
                                SessionCreateParams.LineItem.PriceData.builder()
                                        .setCurrency("inr")
                                        .setUnitAmount(request.getAmount()) // Use validated amount
                                        .setProductData(
                                                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                        .setName(request.getFlightName()) // Use flight name from booking
                                                        .build()
                                        )
                                        .build()
                        )
                        .build()
        );

        // Create session parameters
        SessionCreateParams params = SessionCreateParams.builder()
                .addAllLineItem(lineItems)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(request.getSuccessUrl())
                .setCancelUrl(request.getCancelUrl())
                .build();

        // Create and return the session
        Session session = Session.create(params);
        return new SessionResponseDTO(session.getUrl());
    }

}
