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
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(PaymentReceiptController.class)
//public class PaymentReceiptControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PaymentReceiptService receiptService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private PaymentReceipt receipt;
//
//    @BeforeEach
//    void setUp() {
//        receipt = new PaymentReceipt();
//        receipt.setTransactionId(1L);
//        receipt.setReceiptDetails("Sample Receipt Details");
//    }
//
//    @Test
//    void testGenerateReceiptForPayment() throws Exception {
//        Mockito.when(receiptService.generateReceiptForPayment(anyLong(), any(String.class)))
//                .thenReturn(receipt);
//
//        mockMvc.perform(post("/payment-receipts/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("Sample Receipt Details"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.transactionId").value(receipt.getTransactionId()))
//                .andExpect(jsonPath("$.receiptDetails").value(receipt.getReceiptDetails()));
//    }
//
//    @Test
//    void testGetReceiptByTransactionId() throws Exception {
//        Mockito.when(receiptService.getReceiptByTransactionId(anyLong()))
//                .thenReturn(receipt);
//
//        mockMvc.perform(get("/payment-receipts/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.transactionId").value(receipt.getTransactionId()))
//                .andExpect(jsonPath("$.receiptDetails").value(receipt.getReceiptDetails()));
//    }
//
//    @Test
//    void testGetAllReceipts() throws Exception {
//        List<PaymentReceipt> receipts = Arrays.asList(receipt, receipt);
//        Mockito.when(receiptService.getAllReceipts()).thenReturn(receipts);
//
//        mockMvc.perform(get("/payment-receipts"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.size()").value(receipts.size()));
//    }
//}
