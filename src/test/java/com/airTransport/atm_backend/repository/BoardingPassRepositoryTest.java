package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.BoardingPass;
import com.airTransport.atm_backend.model.Booking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@Transactional
public class BoardingPassRepositoryTest {

    @Autowired
    private BoardingPassRepository boardingPassRepository;

    @Autowired
    private BookingRepository bookingRepository; // Add BookingRepository for related entity

    @Test
    void testSaveAndFindById() {
        // Save a Booking entity first
        Booking booking = new Booking();
        booking = bookingRepository.saveAndFlush(booking); // Persist and flush to ensure ID is generated

        // Create a BoardingPass entity linked to the Booking
        BoardingPass pass = new BoardingPass();
        pass.setGate("A12");
        pass.setSeatNumber("12B");
        pass.setBooking(booking); // Link with the persisted Booking

        // Save the BoardingPass entity
        pass = boardingPassRepository.saveAndFlush(pass); // Save and flush to ensure persistence

        // Retrieve and validate the BoardingPass entity
        Optional<BoardingPass> found = boardingPassRepository.findById(pass.getId());
        assertTrue(found.isPresent());
    }
}
