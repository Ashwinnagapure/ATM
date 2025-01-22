package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Custom query to fetch bookings by user ID
    List<Booking> findByUserId(Long userId);
}
