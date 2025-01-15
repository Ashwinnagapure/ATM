//package com.airTransport.atm_backend.controller;
//
//import com.airTransport.atm_backend.model.PaymentReceipt;
//import com.airTransport.atm_backend.service.PaymentReceiptService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//
//@WebMvcTest(controllers = PaymentReceiptController.class)
//public class PaymentReceiptControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PaymentReceiptService paymentReceiptService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private PaymentReceipt paymentReceipt;
//
//    @BeforeEach
//    void setUp() {
//        paymentReceipt = new PaymentReceipt();
//        paymentReceipt.setTransactionId(1L);
//        paymentReceipt.setReceiptDetails("Receipt for Payment of 500");
//    }
//
//    @Test
//    void shouldGenerateReceiptForPaymentSuccessfully() throws Exception {
//        // Mocking the service layer to return a predefined receipt
//        Mockito.when(paymentReceiptService.generateReceiptForPayment(any(Long.class), any(String.class)))
//                .thenReturn(paymentReceipt);
//
//        // Perform the POST request to generate a payment receipt
//        String response = mockMvc.perform(post("/payment-receipts/{paymentId}", 1L)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("\"Receipt for Payment of 500\""))
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        // Debugging: print the response body
//        System.out.println("Response: " + response);
//
//        // Assertion: Check if response contains the transactionId
//        assertTrue(response.contains(paymentReceipt.getTransactionId().toString()),
//                "The response should contain the transactionId. Actual response: " + response);
//
//        // Additional assertions for other properties (if needed)
//        assertTrue(response.contains(paymentReceipt.getReceiptDetails()),
//                "The response should contain the receiptDetails. Actual response: " + response);
//    }
//
//    @Test
//    void shouldGetReceiptByTransactionIdSuccessfully() throws Exception {
//        // Mocking the service layer to return the payment receipt for the given transaction ID
//        Mockito.when(paymentReceiptService.getReceiptByTransactionId(1L))
//                .thenReturn(paymentReceipt);
//
//        // Perform the GET request to fetch the receipt by transaction ID
//        String response = mockMvc.perform(get("/payment-receipts/{transactionId}", 1L))
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        // Debugging: print the response body
//        System.out.println("Response: " + response);
//
//        // Assertion: Check if response contains the transactionId
//        assertTrue(response.contains(paymentReceipt.getTransactionId().toString()),
//                "The response should contain the transactionId. Actual response: " + response);
//
//        // Additional assertions for other properties (if needed)
//        assertTrue(response.contains(paymentReceipt.getReceiptDetails()),
//                "The response should contain the receiptDetails. Actual response: " + response);
//    }
//
//    @Test
//    void shouldGetAllReceiptsSuccessfully() throws Exception {
//        // Mocking the service layer to return a list with one receipt
//        Mockito.when(paymentReceiptService.getAllReceipts())
//                .thenReturn(java.util.Arrays.asList(paymentReceipt));
//
//        // Perform the GET request to fetch all payment receipts
//        String response = mockMvc.perform(get("/payment-receipts"))
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        // Debugging: print the response body
//        System.out.println("Response: " + response);
//
//        // Assertion: Check if response contains the transactionId
//        assertTrue(response.contains(paymentReceipt.getTransactionId().toString()),
//                "The response should contain the transactionId. Actual response: " + response);
//
//        // Additional assertions for the length of the list and receipt details
//        assertTrue(response.contains(paymentReceipt.getReceiptDetails()),
//                "The response should contain the receiptDetails. Actual response: " + response);
//    }
//
//}
