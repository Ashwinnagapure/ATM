package com.airTransport.atm_backend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingDTOTest {

    @Test
    void testGettersAndSetters() {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(1L);
        bookingDTO.setFlightId(100L);
        bookingDTO.setTravellerCount(2);

        assertEquals(1L, bookingDTO.getId());
        assertEquals(100L, bookingDTO.getFlightId());
        assertEquals(2, bookingDTO.getTravellerCount());
    }

//    @Test
//    void testEqualsAndHashCode() {
//        BookingDTO bookingDTO1 = new BookingDTO();
//        bookingDTO1.setId(1L);
//        bookingDTO1.setFlightId(100L);
//        bookingDTO1.setTravellerCount(2);
//
//        BookingDTO bookingDTO2 = new BookingDTO();
//        bookingDTO2.setId(1L);
//        bookingDTO2.setFlightId(100L);
//        bookingDTO2.setTravellerCount(2);
//
//        assertEquals(bookingDTO1, bookingDTO2);
//        assertEquals(bookingDTO1.hashCode(), bookingDTO2.hashCode());
//    }
//
//    @Test
//    void testToString() {
//        BookingDTO bookingDTO = new BookingDTO();
//        bookingDTO.setId(1L);
//        bookingDTO.setFlightId(100L);
//        bookingDTO.setTravellerCount(2);
//
//        String expected = "BookingDTO{id=1, flightId=100, travellerCount=2}";
//        assertEquals(expected, bookingDTO.toString());
//    }
}
