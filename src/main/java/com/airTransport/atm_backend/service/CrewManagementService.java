package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.CrewManagement;
import com.airTransport.atm_backend.model.enums.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CrewManagementService {

    CrewManagement addCrewMember(CrewManagement crewMember);

    CrewManagement updateCrewMember(Long id, CrewManagement crewMember);

    void deleteCrewMember(Long id);

    CrewManagement getCrewMemberById(Long id);

    List<CrewManagement> getCrewMembersByRole(Role role);

    List<CrewManagement> getAvailableCrewMembers();


    List<CrewManagement> getCrewByAdmin(Long adminId);
}
