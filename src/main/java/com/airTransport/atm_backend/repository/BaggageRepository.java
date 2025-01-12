package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaggageRepository extends JpaRepository<Baggage, Long> {

    // Find all baggage by a specific booking ID
    List<Baggage> findByBookingId(Long bookingId);
}
