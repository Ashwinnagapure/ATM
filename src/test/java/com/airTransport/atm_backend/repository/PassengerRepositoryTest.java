//package com.airTransport.atm_backend.repository;
//
//import com.airTransport.atm_backend.model.Booking;
//import com.airTransport.atm_backend.model.Passenger;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//public class PassengerRepositoryTest {
//
//    @Autowired
//    private PassengerRepository passengerRepository;
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    @Test
//    void testFindByBookingId() {
//        Booking booking = new Booking();
//        booking = bookingRepository.save(booking);
//
//        Passenger passenger = new Passenger();
//        passenger.setName("John Doe");
//        passenger.setEmail("john@example.com");
//        passenger.setPhone("1234567890");
//        passenger.setBooking(booking);
//        passengerRepository.save(passenger);
//
//        List<Passenger> passengers = passengerRepository.findByBookingId(booking.getId());
//
//        assertNotNull(passengers);
//        assertEquals(1, passengers.size());
//        assertEquals("John Doe", passengers.get(0).getName());
//    }
//}
