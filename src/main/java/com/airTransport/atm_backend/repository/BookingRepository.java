package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BookingRepository extends JpaRepository<Booking, Long> {
}