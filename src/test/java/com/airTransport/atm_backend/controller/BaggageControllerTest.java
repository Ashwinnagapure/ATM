//package com.airTransport.atm_backend.controller;
//
//import com.airTransport.atm_backend.dto.BaggageDTO;
//import com.airTransport.atm_backend.service.BaggageService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Collections;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(BaggageController.class)
//public class BaggageControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private BaggageService baggageService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetBaggageByBookingId() throws Exception {
//        BaggageDTO baggageDTO = new BaggageDTO();
//        baggageDTO.setWeight(20.0);
//        baggageDTO.setIsOverweight(false);
//
//        when(baggageService.getBaggageByBookingId(1L)).thenReturn(Collections.singletonList(baggageDTO));
//
//        mockMvc.perform(get("/baggages/booking/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].weight").value(20.0))
//                .andExpect(jsonPath("$[0].isOverweight").value(false));
//    }
//
//    @Test
//    void testAddBaggageToBooking() throws Exception {
//        BaggageDTO baggageDTO = new BaggageDTO();
//        baggageDTO.setWeight(20.0);
//        baggageDTO.setIsOverweight(false);
//
//        when(baggageService.addBaggageToBooking(eq(1L), any(BaggageDTO.class))).thenReturn(baggageDTO);
//
//        mockMvc.perform(post("/baggages/booking/1")
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(baggageDTO)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.weight").value(20.0))
//                .andExpect(jsonPath("$.isOverweight").value(false));
//    }
//
//    @Test
//    void testUpdateBaggage() throws Exception {
//        BaggageDTO baggageDTO = new BaggageDTO();
//        baggageDTO.setWeight(25.0);
//        baggageDTO.setIsOverweight(true);
//
//        when(baggageService.updateBaggage(eq(1L), any(BaggageDTO.class))).thenReturn(baggageDTO);
//
//        mockMvc.perform(put("/baggages/1")
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(baggageDTO)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.weight").value(25.0))
//                .andExpect(jsonPath("$.isOverweight").value(true));
//    }
//
////    @Test
////    void testDeleteBaggage() throws Exception {
////        doNothing().when(baggageService).deleteBaggage(1L);
////
////        mockMvc.perform(delete("/baggages/1"))
////                .andExpect(status().isOk())
////                .andExpect(content().string("Baggage deleted successfully."));
////    }
//}
