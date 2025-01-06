package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    // Add methods for sorting
    List<Flight> findAllByOrderByPriceAsc();  // Sorting by price
    List<Flight> findAllByOrderByAirlineAsc(); // Sorting by airline
    List<Flight> findAllByOrderByFlightClassAsc(); // Sorting by flight class
}
