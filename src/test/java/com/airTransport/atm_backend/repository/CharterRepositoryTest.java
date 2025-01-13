package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Charter;
import com.airTransport.atm_backend.model.Passenger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CharterRepositoryTest {

    @Autowired
    private CharterRepository charterRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    private Passenger passenger;

    @BeforeEach
    void setUp() {
        passenger = new Passenger();
        passenger.setUsername("John Doe");
        passenger.setEmail("johndoe@example.com"); // Ensure email is set
        passenger.setPassword("securepassword"); // Ensure password is set
        passenger = passengerRepository.save(passenger);

        Charter charter1 = new Charter();
        charter1.setSource("New York");
        charter1.setDestination("Los Angeles");
        charter1.setPassenger(passenger);

        Charter charter2 = new Charter();
        charter2.setSource("Chicago");
        charter2.setDestination("Miami");
        charter2.setPassenger(passenger);

        charterRepository.save(charter1);
        charterRepository.save(charter2);
    }

    @AfterEach
    void tearDown() {
        charterRepository.deleteAll();
        passengerRepository.deleteAll();
    }

    @Test
    void findByPassenger() {
        List<Charter> charters = charterRepository.findByPassenger(passenger);
        assertNotNull(charters);
        assertEquals(2, charters.size());
        assertEquals("New York", charters.get(0).getSource());
        assertEquals("Los Angeles", charters.get(0).getDestination());
        assertEquals("Chicago", charters.get(1).getSource());
        assertEquals("Miami", charters.get(1).getDestination());
    }
}