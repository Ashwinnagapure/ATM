package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllByOrderByFlightClassAsc();
}
