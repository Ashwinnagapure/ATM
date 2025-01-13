package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.BaggageDTO;
import com.airTransport.atm_backend.service.BaggageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class BaggageControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BaggageService baggageService;

    @InjectMocks
    private BaggageController baggageController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(baggageController).build();
    }

    @Test
    void testGetBaggageById() throws Exception {
        Long baggageId = 1L;
        BaggageDTO baggageDTO = new BaggageDTO(baggageId, 100L, true, 23.5, 2, "Feedback");

        when(baggageService.getBaggageById(baggageId)).thenReturn(baggageDTO);

        mockMvc.perform(get("/baggage/{baggageId}", baggageId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.baggageId").value(baggageId))
                .andExpect(jsonPath("$.bookingId").value(100L))
                .andExpect(jsonPath("$.baggageLimit").value(true))
                .andExpect(jsonPath("$.weight").value(23.5))
                .andExpect(jsonPath("$.luggageCount").value(2))
                .andExpect(jsonPath("$.feedback").value("Feedback"));

        verify(baggageService, times(1)).getBaggageById(baggageId);
    }

    @Test
    void testGetBaggageByBookingId() throws Exception {
        Long bookingId = 100L;
        List<BaggageDTO> baggageList = Arrays.asList(
                new BaggageDTO(1L, bookingId, true, 23.5, 2, "Feedback 1"),
                new BaggageDTO(2L, bookingId, false, 15.0, 1, "Feedback 2")
        );

        when(baggageService.getBaggageByBookingId(bookingId)).thenReturn(baggageList);

        mockMvc.perform(get("/baggage/byBooking/{bookingId}", bookingId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].baggageId").value(1L))
                .andExpect(jsonPath("$[0].feedback").value("Feedback 1"))
                .andExpect(jsonPath("$[1].baggageId").value(2L))
                .andExpect(jsonPath("$[1].feedback").value("Feedback 2"));

        verify(baggageService, times(1)).getBaggageByBookingId(bookingId);
    }

//    @Test
//    void testCreateBaggage() throws Exception {
//        BaggageDTO baggageDTO = new BaggageDTO(null, 100L, true, 23.5, 2, "Feedback");
//        BaggageDTO createdBaggageDTO = new BaggageDTO(1L, 100L, true, 23.5, 2, "Feedback");
//
//        when(baggageService.createBaggageFromParams(100L, true, 23.5, 2)).thenReturn(createdBaggageDTO);
//
//        mockMvc.perform(post("/baggage/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{" +
//                                "\"bookingId\": 100," +
//                                "\"baggageLimit\": true," +
//                                "\"weight\": 23.5," +
//                                "\"luggageCount\": 2," +
//                                "\"feedback\": \"Feedback\"}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.baggageId").value(1L))
//                .andExpect(jsonPath("$.feedback").value("Feedback"));
//
//        verify(baggageService, times(1)).createBaggageFromParams(100L, true, 23.5, 2);
//    }

    @Test
    void testGetBaggageLimit() throws Exception {
        Long baggageId = 1L;
        when(baggageService.getBaggageLimit(baggageId)).thenReturn(true);

        mockMvc.perform(get("/baggage/limit/{baggageId}", baggageId))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        verify(baggageService, times(1)).getBaggageLimit(baggageId);
    }

//    @Test
//    void testReportLostBaggage() throws Exception {
//        Long baggageId = 1L;
//        String feedback = "Lost baggage reported";
//
//        when(baggageService.reportLostBaggage(baggageId, feedback)).thenReturn(true);
//
//        mockMvc.perform(post("/baggage/lost/{baggageId}", baggageId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("\"Lost baggage reported\""))
//                .andExpect(status().isOk())
//                .andExpect(content().string("true"));
//
//        verify(baggageService, times(1)).reportLostBaggage(baggageId, feedback);
//    }
}
