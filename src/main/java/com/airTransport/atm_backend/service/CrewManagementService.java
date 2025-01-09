package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.CrewManagement;
import com.airTransport.atm_backend.model.enums.Role;

import java.util.List;

public interface CrewManagementService {
    CrewManagement addCrewMember(CrewManagement crewMember);
    CrewManagement updateCrewMember(Long id, CrewManagement updatedCrewMember);
    void deleteCrewMember(Long id);
    CrewManagement getCrewMemberById(Long id);
    List<CrewManagement> getCrewMembersByRole(Role role);
    List<CrewManagement> getAvailableCrewMembers();
    List<CrewManagement> getCrewByAdmin(Long adminId);
}
