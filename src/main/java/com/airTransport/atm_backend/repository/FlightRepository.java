package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllByOrderByPriceAsc();
    List<Flight> findAllByOrderByAirlineAsc();
    List<Flight> findAllByOrderByFlightClassAsc();



    List<Flight> findBySourceAndDestination(String source, String destination);

    List<Flight> findByAirline(String airlineName);

}
