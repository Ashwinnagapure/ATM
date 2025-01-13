package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.BaggageDTO;
import com.airTransport.atm_backend.model.Baggage;
import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.repository.BaggageRepository;
import com.airTransport.atm_backend.repository.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BaggageServiceImplTest {

    @InjectMocks
    private BaggageServiceImpl baggageService;

    @Mock
    private BaggageRepository baggageRepository;

    @Mock
    private BookingRepository bookingRepository;

    private Baggage baggage;
    private Booking booking;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Setup mock objects
        booking = new Booking();
        booking.setId(1L);

        baggage = new Baggage();
        baggage.setBaggageId(1L);
        baggage.setBaggageLimit(true);
        baggage.setWeight(15.5);
        baggage.setLuggageCount(2);
        baggage.setFeedback("Good condition");
        baggage.setBooking(booking);
    }

    @Test
    void testGetBaggageLimit_ValidId() {
        when(baggageRepository.findById(1L)).thenReturn(Optional.of(baggage));

        boolean result = baggageService.getBaggageLimit(1L);

        assertTrue(result, "Baggage limit should be true");
        verify(baggageRepository, times(1)).findById(1L);
    }

    @Test
    void testGetBaggageLimit_InvalidId() {
        when(baggageRepository.findById(2L)).thenReturn(Optional.empty());

        boolean result = baggageService.getBaggageLimit(2L);

        assertFalse(result, "Baggage limit should be false for invalid ID");
        verify(baggageRepository, times(1)).findById(2L);
    }

    @Test
    void testReportLostBaggage_ValidId() {
        when(baggageRepository.findById(1L)).thenReturn(Optional.of(baggage));
        when(baggageRepository.save(any(Baggage.class))).thenReturn(baggage);

        boolean result = baggageService.reportLostBaggage(1L, "Lost at terminal");

        assertTrue(result, "Should successfully report lost baggage");
        assertEquals("Lost at terminal", baggage.getFeedback(), "Feedback should be updated");
        verify(baggageRepository, times(1)).findById(1L);
        verify(baggageRepository, times(1)).save(baggage);
    }

    @Test
    void testReportLostBaggage_InvalidId() {
        when(baggageRepository.findById(2L)).thenReturn(Optional.empty());

        boolean result = baggageService.reportLostBaggage(2L, "Lost at terminal");

        assertFalse(result, "Should return false for invalid baggage ID");
        verify(baggageRepository, times(1)).findById(2L);
        verify(baggageRepository, never()).save(any(Baggage.class));
    }

    @Test
    void testGetBaggageById_ValidId() {
        when(baggageRepository.findById(1L)).thenReturn(Optional.of(baggage));

        BaggageDTO baggageDTO = baggageService.getBaggageById(1L);

        assertNotNull(baggageDTO, "BaggageDTO should not be null");
        assertEquals(1L, baggageDTO.getBaggageId(), "Baggage ID should match");
        verify(baggageRepository, times(1)).findById(1L);
    }

    @Test
    void testGetBaggageById_InvalidId() {
        when(baggageRepository.findById(2L)).thenReturn(Optional.empty());

        BaggageDTO baggageDTO = baggageService.getBaggageById(2L);

        assertNull(baggageDTO, "BaggageDTO should be null for invalid ID");
        verify(baggageRepository, times(1)).findById(2L);
    }

    @Test
    void testGetBaggageByBookingId_ValidBookingId() {
        when(baggageRepository.findByBookingId(1L)).thenReturn(List.of(baggage));

        List<BaggageDTO> baggageList = baggageService.getBaggageByBookingId(1L);

        assertNotNull(baggageList, "Baggage list should not be null");
        assertEquals(1, baggageList.size(), "Baggage list size should be 1");
        verify(baggageRepository, times(1)).findByBookingId(1L);
    }

    @Test
    void testGetBaggageByBookingId_InvalidBookingId() {
        when(baggageRepository.findByBookingId(2L)).thenReturn(List.of());

        List<BaggageDTO> baggageList = baggageService.getBaggageByBookingId(2L);

        assertNotNull(baggageList, "Baggage list should not be null");
        assertTrue(baggageList.isEmpty(), "Baggage list should be empty");
        verify(baggageRepository, times(1)).findByBookingId(2L);
    }

    @Test
    void testCreateBaggageFromParams_ValidParams() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));
        when(baggageRepository.save(any(Baggage.class))).thenAnswer(invocation -> {
            Baggage savedBaggage = invocation.getArgument(0);
            savedBaggage.setBaggageId(1L);
            return savedBaggage;
        });

        BaggageDTO baggageDTO = baggageService.createBaggageFromParams(1L, true, 20.0, 3);

        assertNotNull(baggageDTO, "BaggageDTO should not be null");
        assertEquals(1L, baggageDTO.getBaggageId(), "Baggage ID should be set");
        assertEquals(3, baggageDTO.getLuggageCount(), "Luggage count should match");
        verify(bookingRepository, times(1)).findById(1L);
        verify(baggageRepository, times(1)).save(any(Baggage.class));
    }

    @Test
    void testCreateBaggageFromParams_InvalidBookingId() {
        when(bookingRepository.findById(2L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                baggageService.createBaggageFromParams(2L, true, 20.0, 3)
        );

        assertEquals("Booking not found", exception.getMessage(), "Exception message should match");
        verify(bookingRepository, times(1)).findById(2L);
        verify(baggageRepository, never()).save(any(Baggage.class));
    }
}
