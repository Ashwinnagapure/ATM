package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.User;
import com.airTransport.atm_backend.model.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.id = :userId")
    User searchUser(@Param("userId") Long userId);
    List<User> findByUserType(@Param("userType") UserType userType);
}