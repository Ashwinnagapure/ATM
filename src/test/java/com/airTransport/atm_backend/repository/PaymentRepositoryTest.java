// PaymentRepositoryTest.java
package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.model.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    void testSaveAndFindById() {
        // Create and save a Booking entity
        Booking booking = new Booking();
        booking = bookingRepository.save(booking);

        // Create and save a Payment entity
        Payment payment = new Payment();
        payment.setAmount(200.0);
        payment.setStatus("COMPLETED");
        payment.setBooking(booking);
        payment = paymentRepository.save(payment);

        // Retrieve the Payment entity by ID
        Optional<Payment> retrievedPayment = paymentRepository.findById(payment.getId());

        // Assertions
        assertTrue(retrievedPayment.isPresent());
        assertEquals(200.0, retrievedPayment.get().getAmount());
        assertEquals("COMPLETED", retrievedPayment.get().getStatus());
        assertEquals(booking.getId(), retrievedPayment.get().getBooking().getId());
    }

    @Test
    void testDeleteById() {
        // Create and save a Booking entity
        Booking booking = new Booking();
        booking = bookingRepository.save(booking);

        // Create and save a Payment entity
        Payment payment = new Payment();
        payment.setAmount(300.0);
        payment.setStatus("PENDING");
        payment.setBooking(booking);
        payment = paymentRepository.save(payment);

        // Delete the Payment entity
        paymentRepository.deleteById(payment.getId());

        // Verify that the Payment entity no longer exists
        Optional<Payment> retrievedPayment = paymentRepository.findById(payment.getId());
        assertFalse(retrievedPayment.isPresent());
    }

    @Test
    void testUpdatePayment() {
        // Create and save a Booking entity
        Booking booking = new Booking();
        booking = bookingRepository.save(booking);

        // Create and save a Payment entity
        Payment payment = new Payment();
        payment.setAmount(400.0);
        payment.setStatus("PENDING");
        payment.setBooking(booking);
        payment = paymentRepository.save(payment);

        // Update the Payment entity
        payment.setAmount(450.0);
        payment.setStatus("COMPLETED");
        payment = paymentRepository.save(payment);

        // Retrieve the updated Payment entity
        Optional<Payment> retrievedPayment = paymentRepository.findById(payment.getId());

        // Assertions
        assertTrue(retrievedPayment.isPresent());
        assertEquals(450.0, retrievedPayment.get().getAmount());
        assertEquals("COMPLETED", retrievedPayment.get().getStatus());
    }
}