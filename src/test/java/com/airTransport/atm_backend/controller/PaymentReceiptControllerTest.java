//package com.airTransport.atm_backend.controller;
//
//import com.airTransport.atm_backend.model.PaymentReceipt;
//import com.airTransport.atm_backend.service.PaymentReceiptService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//
//import static org.hamcrest.Matchers.*;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(PaymentReceiptController.class)
//class PaymentReceiptControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private PaymentReceiptService receiptService;
//
//    private PaymentReceipt receipt;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//        receipt = new PaymentReceipt();
//        receipt.setTransactionId(1L);
//        receipt.setReceiptDetails("Receipt Details");
//    }
//
//    @Test
//    void testGenerateReceiptForPayment() throws Exception {
//        when(receiptService.generateReceiptForPayment(1L, "Receipt Details")).thenReturn(receipt);
//
//        mockMvc.perform(post("/payment-receipts/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("\"Receipt Details\""))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.transactionId", is(1)))
//                .andExpect(jsonPath("$.receiptDetails", is("Receipt Details")));
//
//        verify(receiptService, times(1)).generateReceiptForPayment(1L, "Receipt Details");
//    }
//
//    @Test
//    void testGetReceiptByTransactionId() throws Exception {
//        when(receiptService.getReceiptByTransactionId(1L)).thenReturn(receipt);
//
//        mockMvc.perform(get("/payment-receipts/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.transactionId", is(1)))
//                .andExpect(jsonPath("$.receiptDetails", is("Receipt Details")));
//
//        verify(receiptService, times(1)).getReceiptByTransactionId(1L);
//    }
//
//    @Test
//    void testGetAllReceipts() throws Exception {
//        PaymentReceipt receipt2 = new PaymentReceipt();
//        receipt2.setTransactionId(2L);
//        receipt2.setReceiptDetails("Another Receipt");
//
//        when(receiptService.getAllReceipts()).thenReturn(Arrays.asList(receipt, receipt2));
//
//        mockMvc.perform(get("/payment-receipts")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].transactionId", is(1)))
//                .andExpect(jsonPath("$[1].transactionId", is(2)))
//                .andExpect(jsonPath("$[0].receiptDetails", is("Receipt Details")))
//                .andExpect(jsonPath("$[1].receiptDetails", is("Another Receipt")));
//
//        verify(receiptService, times(1)).getAllReceipts();
//    }
//
//    @Test
//    void testGenerateReceiptForPayment_InvalidPaymentId() throws Exception {
//        when(receiptService.generateReceiptForPayment(1L, "Receipt Details"))
//                .thenThrow(new RuntimeException("Payment not found"));
//
//        mockMvc.perform(post("/payment-receipts/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("\"Receipt Details\""))
//                .andExpect(status().isInternalServerError());
//
//        verify(receiptService, times(1)).generateReceiptForPayment(1L, "Receipt Details");
//    }
//
//    @Test
//    void testGetReceiptByTransactionId_NotFound() throws Exception {
//        when(receiptService.getReceiptByTransactionId(1L))
//                .thenThrow(new RuntimeException("Receipt not found"));
//
//        mockMvc.perform(get("/payment-receipts/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isInternalServerError());
//
//        verify(receiptService, times(1)).getReceiptByTransactionId(1L);
//    }
//}
