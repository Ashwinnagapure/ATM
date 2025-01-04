package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.Charter;
import com.airTransport.atm_backend.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharterRepository extends JpaRepository<Charter, Long> {
    List<Charter> findByPassenger(Passenger passenger);

}
