package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.model.Passenger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class PassengerRepositoryTest {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    void testFindByBookingId() {
        // Step 1: Create and save a booking
        Booking booking = new Booking();
        booking = bookingRepository.save(booking);

        // Step 2: Create and save passengers associated with the booking
        Passenger passenger1 = new Passenger();
        passenger1.setName("John Doe");
        passenger1.setEmail("john.doe@example.com");
        passenger1.setPhone("1234567890");
        passenger1.setBooking(booking);

        Passenger passenger2 = new Passenger();
        passenger2.setName("Jane Smith");
        passenger2.setEmail("jane.smith@example.com");
        passenger2.setPhone("0987654321");
        passenger2.setBooking(booking);

        passengerRepository.save(passenger1);
        passengerRepository.save(passenger2);

        // Step 3: Fetch passengers by booking ID
        List<Passenger> passengers = passengerRepository.findByBookingId(booking.getId());

        // Step 4: Validate the results
        assertNotNull(passengers);
        assertEquals(2, passengers.size());
        assertEquals("John Doe", passengers.get(0).getName());
        assertEquals("Jane Smith", passengers.get(1).getName());
    }

    @Test
    void testSavePassenger() {
        // Step 1: Create and save a booking
        Booking booking = new Booking();
        booking = bookingRepository.save(booking);

        // Step 2: Create and save a passenger
        Passenger passenger = new Passenger();
        passenger.setName("Alice Wonderland");
        passenger.setEmail("alice.wonderland@example.com");
        passenger.setPhone("1122334455");
        passenger.setBooking(booking);

        Passenger savedPassenger = passengerRepository.save(passenger);

        // Step 3: Validate the saved passenger
        assertNotNull(savedPassenger);
        assertNotNull(savedPassenger.getId());
        assertEquals("Alice Wonderland", savedPassenger.getName());
    }
}