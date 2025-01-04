package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

}