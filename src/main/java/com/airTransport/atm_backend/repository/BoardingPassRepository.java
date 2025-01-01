package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.BoardingPass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardingPassRepository extends JpaRepository<BoardingPass, Long> {
}
