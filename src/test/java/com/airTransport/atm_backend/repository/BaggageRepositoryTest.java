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
//public class BaggageRepositoryTest {
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
//        booking = bookingRepository.save(booking);
//
//        Baggage baggage = new Baggage();
//        baggage.setWeight(20.0);
//        baggage.setIsOverweight(false);
//        baggage.setBooking(booking);
//        baggageRepository.save(baggage);
//
//        List<Baggage> baggages = baggageRepository.findByBookingId(booking.getId());
//
//        assertNotNull(baggages);
//        assertEquals(1, baggages.size());
//        assertEquals(20.0, baggages.get(0).getWeight());
//    }
//}
