package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Charter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharterRepository extends JpaRepository<Charter, Long> {
    // Custom query methods if needed
}
