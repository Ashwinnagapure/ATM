package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Baggage;
import com.airTransport.atm_backend.model.Booking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BaggageRepositoryTest {

    @Autowired
    private BaggageRepository baggageRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    void testFindByBookingId() {
        // Create and save a valid Booking entity
        Booking booking = new Booking();
        bookingRepository.save(booking);

        // Create and save a Baggage entity linked to the Booking
        Baggage baggage = new Baggage();
        baggage.setWeight(23.5);
        baggage.setBagCount(2);
        baggage.setBooking(booking);
        baggageRepository.save(baggage);

        // Fetch the Baggage entities by Booking ID
        List<Baggage> result = baggageRepository.findByBookingId(booking.getId());

        // Assertions
        assertEquals(1, result.size());
        assertEquals(23.5, result.get(0).getWeight());
        assertEquals(2, result.get(0).getBagCount());
        assertEquals(booking.getId(), result.get(0).getBooking().getId());
    }

}
