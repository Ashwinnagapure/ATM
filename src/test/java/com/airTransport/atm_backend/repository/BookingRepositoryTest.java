package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class BookingRepositoryTest {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    private Flight flight;

    @BeforeEach
    public void setUp() {
        // Set up a Flight for the Booking to be related
        flight = new Flight();
        flight.setDeparture(LocalDateTime.parse("2025-01-15T10:00"));
        flight.setArrival(LocalDateTime.parse("2025-01-15T12:00"));
        flightRepository.save(flight);
    }

//    @Test
//    void testSaveBooking() {
//        Booking booking = new Booking();
//        booking.setTravellerCount(2);
//        booking.setFlight(flight);
//
//        Booking savedBooking = bookingRepository.save(booking);
//
//        assertNotNull(savedBooking.getId(), "Booking ID should not be null after saving.");
//    }
}