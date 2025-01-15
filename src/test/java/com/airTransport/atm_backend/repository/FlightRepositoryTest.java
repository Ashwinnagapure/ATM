package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AdminRepository adminRepository; // Inject AdminRepository

    @Test
    void testFindBySourceAndDestination() {
        // Save an Admin object
        Admin admin = new Admin();
        admin.setName("Admin Test");
        admin.setEmail("admin@test.com");
        admin.setPassword("password123");
        adminRepository.save(admin); // Use AdminRepository to save the Admin

        // Create a Flight object and associate it with the Admin
        Flight flight = new Flight();
        flight.setFlightName("Test Flight");
        flight.setSource("NYC");
        flight.setDestination("LAX");
        flight.setAdmin(admin); // Associate the Flight with the Admin
        flightRepository.save(flight); // Save the Flight

        // Test the repository method
        List<Flight> flights = flightRepository.findBySourceAndDestination("NYC", "LAX");
        assertEquals(1, flights.size());
        assertEquals("Test Flight", flights.get(0).getFlightName());
    }
}