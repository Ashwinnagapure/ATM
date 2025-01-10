package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.CrewManagementDTO;
import com.airTransport.atm_backend.model.CrewManagement;
import com.airTransport.atm_backend.model.enums.Role;

import java.util.List;

public interface CrewManagementService {
    CrewManagementDTO addCrewMember(CrewManagement crewMember);
    CrewManagementDTO updateCrewMember(Long id, CrewManagement updatedCrewMember);
    void deleteCrewMember(Long id);
    CrewManagementDTO getCrewMemberById(Long id);
    List<CrewManagementDTO> getCrewMembersByRole(Role role);
    List<CrewManagementDTO> getAvailableCrewMembers();
    List<CrewManagementDTO> getCrewByAdmin(Long adminId);

    // Conversion methods
    CrewManagementDTO toDTO(CrewManagement crewMember);
    CrewManagement fromDTO(CrewManagementDTO crewDTO);
}
