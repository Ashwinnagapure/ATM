//package com.airTransport.atm_backend.repository;
//
//import com.airTransport.atm_backend.model.Baggage;
//import com.airTransport.atm_backend.model.Booking;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//class BaggageRepositoryTest {
//
//    @Autowired
//    private BaggageRepository baggageRepository;
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    @Test
//    void testFindByBookingId() {
//        Booking booking = new Booking();
//        booking.setId(1L);
//        bookingRepository.save(booking);
//
//        Baggage baggage = new Baggage();
//        baggage.setWeight(23.5);
//        baggage.setBagCount(2);
//        baggage.setBooking(booking);
//        baggageRepository.save(baggage);
//
//        List<Baggage> result = baggageRepository.findByBookingId(1L);
//
//        assertEquals(1, result.size());
//        assertEquals(23.5, result.get(0).getWeight());
//        assertEquals(2, result.get(0).getBagCount());
//        assertEquals(1L, result.get(0).getBooking().getId());
//    }
//}