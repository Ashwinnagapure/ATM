package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaggageRepository extends JpaRepository<Baggage, Long> {
    // Custom query to find all baggage associated with a specific booking

    List<Baggage> findByBookingId(Long bookingId);

    // You can use the default findById method provided by JpaRepository
}
