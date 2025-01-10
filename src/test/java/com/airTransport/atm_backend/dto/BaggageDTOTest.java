package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaggageDTOTest {

    private BaggageDTO baggageDTO;

    @BeforeEach
    void setUp() {
        baggageDTO = new BaggageDTO(1L, 101L, true, 23.5, 2, "Good service");
    }

    @AfterEach
    void tearDown() {
        baggageDTO = null;
    }

    @Test
    void getBaggageId() {
        assertEquals(1L, baggageDTO.getBaggageId());
    }

    @Test
    void setBaggageId() {
        baggageDTO.setBaggageId(2L);
        assertEquals(2L, baggageDTO.getBaggageId());
    }

    @Test
    void getBookingId() {
        assertEquals(101L, baggageDTO.getBookingId());
    }

    @Test
    void setBookingId() {
        baggageDTO.setBookingId(102L);
        assertEquals(102L, baggageDTO.getBookingId());
    }

    @Test
    void isBaggageLimit() {
        assertTrue(baggageDTO.isBaggageLimit());
    }

    @Test
    void setBaggageLimit() {
        baggageDTO.setBaggageLimit(false);
        assertFalse(baggageDTO.isBaggageLimit());
    }

    @Test
    void getWeight() {
        assertEquals(23.5, baggageDTO.getWeight());
    }

    @Test
    void setWeight() {
        baggageDTO.setWeight(25.0);
        assertEquals(25.0, baggageDTO.getWeight());
    }

    @Test
    void getLuggageCount() {
        assertEquals(2, baggageDTO.getLuggageCount());
    }

    @Test
    void setLuggageCount() {
        baggageDTO.setLuggageCount(3);
        assertEquals(3, baggageDTO.getLuggageCount());
    }

    @Test
    void getFeedback() {
        assertEquals("Good service", baggageDTO.getFeedback());
    }

    @Test
    void setFeedback() {
        baggageDTO.setFeedback("Excellent service");
        assertEquals("Excellent service", baggageDTO.getFeedback());
    }
}
