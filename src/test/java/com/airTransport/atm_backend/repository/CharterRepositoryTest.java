//package com.airTransport.atm_backend.repository;
//
//import com.airTransport.atm_backend.model.Charter;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@DataJpaTest
//class CharterRepositoryTest {
//
//    @Autowired
//    private CharterRepository charterRepository;
//
//    @Test
//    void testSaveAndFindById() {
//        Charter charter = new Charter();
//        charter.setVehicleType("Private Jet");
//        charter.setPrice(5000.0);
//
//        Charter savedCharter = charterRepository.save(charter);
//
//        Optional<Charter> fetchedCharter = charterRepository.findById(savedCharter.getId());
//
//        assertTrue(fetchedCharter.isPresent());
//    }
//}
