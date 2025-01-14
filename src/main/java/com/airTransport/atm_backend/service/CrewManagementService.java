package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.CrewManagementDTO;
import com.airTransport.atm_backend.model.enums.Role;

import java.util.List;

public interface CrewManagementService {

    CrewManagementDTO addCrewMember(CrewManagementDTO crewMemberDTO);

    CrewManagementDTO updateCrewMember(Long id, CrewManagementDTO updatedCrewMemberDTO);

    void deleteCrewMember(Long id);

    CrewManagementDTO getCrewMemberById(Long id);

    List<CrewManagementDTO> getCrewMembersByRole(String role);

    List<CrewManagementDTO> getAvailableCrewMembers();

    List<CrewManagementDTO> getCrewByAdmin(Long adminId);

    // New method to fetch all crew management details
    List<CrewManagementDTO> getAllCrewMembers();
}
