//package com.airTransport.atm_backend.controller;
//
//import com.airTransport.atm_backend.dto.BaggageDTO;
//import com.airTransport.atm_backend.service.BaggageService;
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
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(BaggageController.class)
//class BaggageControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private BaggageService baggageService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private BaggageDTO baggageDTO;
//
//    @BeforeEach
//    void setUp() {
//        baggageDTO = new BaggageDTO();
//        baggageDTO.setId(1L);
//        baggageDTO.setWeight(15.0);
//        baggageDTO.setBagCount(2);
//        baggageDTO.setBookingId(1L);
//    }
//
//    @Test
//    void testGetBaggageByBookingId() throws Exception {
//        List<BaggageDTO> baggageList = Arrays.asList(baggageDTO);
//
//        Mockito.when(baggageService.getBaggageByBookingId(1L)).thenReturn(baggageList);
//
//        mockMvc.perform(get("/baggages/booking/{bookingId}", 1L)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].id").value(1))
//                .andExpect(jsonPath("$[0].weight").value(15.0))
//                .andExpect(jsonPath("$[0].bagCount").value(2))
//                .andExpect(jsonPath("$[0].bookingId").value(1));
//    }
//
//    @Test
//    void testAddBaggageToBooking() throws Exception {
//        Mockito.when(baggageService.addBaggageToBooking(eq(1L), any(BaggageDTO.class))).thenReturn(baggageDTO);
//
//        mockMvc.perform(post("/baggages/booking/{bookingId}", 1L)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(baggageDTO)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.weight").value(15.0))
//                .andExpect(jsonPath("$.bagCount").value(2))
//                .andExpect(jsonPath("$.bookingId").value(1));
//    }
//
//    @Test
//    void testUpdateBaggage() throws Exception {
//        BaggageDTO updatedBaggage = new BaggageDTO();
//        updatedBaggage.setId(1L);
//        updatedBaggage.setWeight(20.0);
//        updatedBaggage.setBagCount(3);
//        updatedBaggage.setBookingId(1L);
//
//        Mockito.when(baggageService.updateBaggage(eq(1L), any(BaggageDTO.class))).thenReturn(updatedBaggage);
//
//        mockMvc.perform(put("/baggages/{baggageId}", 1L)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(updatedBaggage)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.weight").value(20.0))
//                .andExpect(jsonPath("$.bagCount").value(3))
//                .andExpect(jsonPath("$.bookingId").value(1));
//    }
//
//    @Test
//    void testDeleteBaggage() throws Exception {
//        Mockito.doNothing().when(baggageService).deleteBaggage(1L);
//
//        mockMvc.perform(delete("/baggages/{baggageId}", 1L)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Baggage deleted successfully."));
//    }
//}
