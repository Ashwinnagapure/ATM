package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Booking;
import com.airTransport.atm_backend.model.Payment;
import com.airTransport.atm_backend.model.PaymentReceipt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class PaymentReceiptRepositoryTest {

    @Autowired
    private PaymentReceiptRepository receiptRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;


    @Test
    void testSaveAndFindById() {
        // Create and save a Booking entity
        Booking booking = new Booking();
        Booking savedBooking = bookingRepository.save(booking);

        // Create and save a Payment entity
        Payment payment = new Payment();
        payment.setAmount(100.0);
        payment.setStatus("COMPLETED");
        payment.setBooking(savedBooking); // Associate with booking
        Payment savedPayment = paymentRepository.save(payment);

        // Create and save a PaymentReceipt entity
        PaymentReceipt receipt = new PaymentReceipt();
        receipt.setPayment(savedPayment);
        receipt.setReceiptDetails("Payment receipt for transaction");

        PaymentReceipt savedReceipt = receiptRepository.save(receipt);

        // Fetch the PaymentReceipt by ID
        PaymentReceipt fetchedReceipt = receiptRepository.findById(savedReceipt.getTransactionId()).orElse(null);

        // Assertions
        assertNotNull(fetchedReceipt);
        assertEquals(savedReceipt.getTransactionId(), fetchedReceipt.getTransactionId());
        assertEquals(savedPayment.getId(), fetchedReceipt.getPayment().getId());
        assertEquals("Payment receipt for transaction", fetchedReceipt.getReceiptDetails());
    }

    @Test
    void testDeleteById() {
        // Create and save a Booking entity
        Booking booking = new Booking();
        Booking savedBooking = bookingRepository.save(booking);

        // Create and save a Payment entity
        Payment payment = new Payment();
        payment.setAmount(200.0);
        payment.setStatus("PENDING");
        payment.setBooking(savedBooking); // Associate with booking
        Payment savedPayment = paymentRepository.save(payment);

        // Create and save a PaymentReceipt entity
        PaymentReceipt receipt = new PaymentReceipt();
        receipt.setPayment(savedPayment);
        receipt.setReceiptDetails("Receipt to be deleted");

        PaymentReceipt savedReceipt = receiptRepository.save(receipt);

        // Delete the PaymentReceipt by ID
        receiptRepository.deleteById(savedReceipt.getTransactionId());

        // Fetch the PaymentReceipt by ID
        PaymentReceipt fetchedReceipt = receiptRepository.findById(savedReceipt.getTransactionId()).orElse(null);

        // Assertions
        assertEquals(null, fetchedReceipt);
    }

//    @Test
//    void testFindAll() {
//        // Create and save a Booking entity
//        Booking booking = new Booking();
//        Booking savedBooking = bookingRepository.save(booking);
//
//        // Create and save multiple Payment and PaymentReceipt entities
//        Payment payment1 = new Payment();
//        payment1.setAmount(150.0);
//        payment1.setStatus("COMPLETED");
//        payment1.setBooking(savedBooking); // Associate with booking
//        Payment savedPayment1 = paymentRepository.save(payment1);
//
//        PaymentReceipt receipt1 = new PaymentReceipt();
//        receipt1.setPayment(savedPayment1);
//        receipt1.setReceiptDetails("First receipt");
//        receiptRepository.save(receipt1);
//
//        Payment payment2 = new Payment();
//        payment2.setAmount(250.0);
//        payment2.setStatus("COMPLETED");
//        payment2.setBooking(savedBooking); // Associate with booking
//        Payment savedPayment2 = paymentRepository.save(payment2);
//
//        PaymentReceipt receipt2 = new PaymentReceipt();
//        receipt2.setPayment(savedPayment2);
//        receipt2.setReceiptDetails("Second receipt");
//        receiptRepository.save(receipt2);
//
//        // Fetch all PaymentReceipts
//        long count = receiptRepository.count();
//
//        // Assertions
//        assertEquals(2, count);
//    }

}
