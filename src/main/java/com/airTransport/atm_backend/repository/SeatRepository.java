package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    // Custom query to fetch seats associated with a specific flight ID
    List<Seat> findByFlightFlightId(Long flightId);
}
