package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.CreateSessionRequestDTO;
import com.airTransport.atm_backend.dto.SessionResponseDTO;
import com.airTransport.atm_backend.service.StripeCheckoutService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StripeCheckoutServiceImpl implements StripeCheckoutService {

    @Override
    public SessionResponseDTO createCheckoutSession(CreateSessionRequestDTO request) throws StripeException {
        // Build line items for the session
        List<SessionCreateParams.LineItem> lineItems = new ArrayList<>();
        request.getItems().forEach(item -> {
            SessionCreateParams.LineItem.PriceData.ProductData productData =
                    SessionCreateParams.LineItem.PriceData.ProductData.builder()
                            .setName(item.getName())
                            .build();

            SessionCreateParams.LineItem.PriceData priceData =
                    SessionCreateParams.LineItem.PriceData.builder()
                            .setCurrency(item.getCurrency())
                            .setUnitAmount((long) item.getAmount())
                            .setProductData(productData)
                            .build();

            SessionCreateParams.LineItem lineItem =
                    SessionCreateParams.LineItem.builder()
                            .setQuantity((long) item.getQuantity())
                            .setPriceData(priceData)
                            .build();

            lineItems.add(lineItem);
        });

        // Create the session parameters
        SessionCreateParams params = SessionCreateParams.builder()
                .addAllLineItem(lineItems)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(request.getSuccessUrl())
                .setCancelUrl(request.getCancelUrl())
                .build();

        // Create the Checkout Session
        Session session = Session.create(params);

        // Return the session URL
        return new SessionResponseDTO(session.getUrl());
    }
}
