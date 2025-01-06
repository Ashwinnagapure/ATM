package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {

}
