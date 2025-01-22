package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    List<Passenger> findByBookingId(Long bookingId);

    // New method to fetch passengers by userId
    List<Passenger> findByUserId(Long userId);
}
