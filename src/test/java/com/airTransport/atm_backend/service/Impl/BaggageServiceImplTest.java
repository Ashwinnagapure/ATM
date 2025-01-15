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

import java.util.Collections;
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

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetBaggageByBookingId() {
        Booking booking = new Booking();
        booking.setId(1L);

        Baggage baggage = new Baggage();
        baggage.setId(1L);
        baggage.setWeight(20.0);

        baggage.setBooking(booking);

        when(baggageRepository.findByBookingId(1L)).thenReturn(Collections.singletonList(baggage));

        List<BaggageDTO> result = baggageService.getBaggageByBookingId(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(20.0, result.get(0).getWeight());
    }

    @Test
    void testAddBaggageToBooking() {
        Booking booking = new Booking();
        booking.setId(1L);

        BaggageDTO baggageDTO = new BaggageDTO();
        baggageDTO.setWeight(20.0);


        Baggage baggage = new Baggage();
        baggage.setId(1L);
        baggage.setWeight(20.0);

        baggage.setBooking(booking);

        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));
        when(baggageRepository.save(any(Baggage.class))).thenReturn(baggage);

        BaggageDTO result = baggageService.addBaggageToBooking(1L, baggageDTO);

        assertNotNull(result);
        assertEquals(20.0, result.getWeight());
        
    }
//
//    @Test
//    void testUpdateBaggage() {
//        Baggage baggage = new Baggage();
//        baggage.setId(1L);
//        baggage.setWeight(15.0);
//        baggage.setIsOverweight(false);
//
//        BaggageDTO baggageDTO = new BaggageDTO();
//        baggageDTO.setWeight(25.0);
//        baggageDTO.setIsOverweight(true);
//
//        when(baggageRepository.findById(1L)).thenReturn(Optional.of(baggage));
//        when(baggageRepository.save(any(Baggage.class))).thenAnswer(i -> i.getArgument(0));
//
//        BaggageDTO result = baggageService.updateBaggage(1L, baggageDTO);
//
//        assertNotNull(result);
//        assertEquals(25.0, result.getWeight());
//        assertTrue(result.getIsOverweight());
//    }

    @Test
    void testDeleteBaggage() {
        when(baggageRepository.existsById(1L)).thenReturn(true);

        baggageService.deleteBaggage(1L);

        verify(baggageRepository, times(1)).deleteById(1L);
    }
}
