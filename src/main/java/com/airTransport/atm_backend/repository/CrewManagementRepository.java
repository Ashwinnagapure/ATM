package com.airTransport.atm_backend.repository;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.CrewManagement;
import com.airTransport.atm_backend.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrewManagementRepository extends JpaRepository<CrewManagement, Long> {
    List<CrewManagement> findByRole(Role role);
    List<CrewManagement> findByAvailability(boolean availability);
    List<CrewManagement> findByAdmin(Admin admin);
}
