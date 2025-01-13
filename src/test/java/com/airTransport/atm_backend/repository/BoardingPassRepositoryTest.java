//package com.airTransport.atm_backend.repository;
//
//import com.airTransport.atm_backend.model.BoardingPass;
//import com.airTransport.atm_backend.model.Booking;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@DataJpaTest
//class BoardingPassRepositoryTest {
//
//    @Autowired
//    private BoardingPassRepository boardingPassRepository;
//
//    @Test
//    void testSaveBoardingPass() {
//        Booking booking = new Booking();
//        booking.setId(1L);
//
//        BoardingPass boardingPass = new BoardingPass();
//        boardingPass.setGate("C1");
//        boardingPass.setSeatNumber("14D");
//        boardingPass.setBooking(booking);
//
//        BoardingPass savedBoardingPass = boardingPassRepository.save(boardingPass);
//
//        assertNotNull(savedBoardingPass);
//        assertNotNull(savedBoardingPass.getId());
//    }
//}
