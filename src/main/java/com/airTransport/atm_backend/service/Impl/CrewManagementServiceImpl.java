package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.CrewManagementDTO;
import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.CrewManagement;
import com.airTransport.atm_backend.model.enums.Role;
import com.airTransport.atm_backend.repository.CrewManagementRepository;
import com.airTransport.atm_backend.service.AdminService;
import com.airTransport.atm_backend.service.CrewManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrewManagementServiceImpl implements CrewManagementService {

    @Autowired
    private CrewManagementRepository crewRepository;

    @Autowired
    private AdminService adminService;

    @Override
    public CrewManagementDTO addCrewMember(CrewManagement crewMember) {
        CrewManagement savedCrewMember = crewRepository.save(crewMember);
        return toDTO(savedCrewMember);
    }

    @Override
    public CrewManagementDTO updateCrewMember(Long id, CrewManagement updatedCrewMember) {
        CrewManagement existingCrewMember = crewRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Crew member not found with ID: " + id));

        existingCrewMember.setName(updatedCrewMember.getName());
        existingCrewMember.setRole(updatedCrewMember.getRole());
        existingCrewMember.setAvailability(updatedCrewMember.isAvailability());

        CrewManagement savedCrewMember = crewRepository.save(existingCrewMember);
        return toDTO(savedCrewMember);
    }

    @Override
    public void deleteCrewMember(Long id) {
        CrewManagement crewMember = crewRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Crew member not found with ID: " + id));
        crewRepository.delete(crewMember);
    }

    @Override
    public CrewManagementDTO getCrewMemberById(Long id) {
        CrewManagement crewMember = crewRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Crew member not found with ID: " + id));
        return toDTO(crewMember);
    }

    @Override
    public List<CrewManagementDTO> getCrewMembersByRole(Role role) {
        return crewRepository.findByRole(role)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CrewManagementDTO> getAvailableCrewMembers() {
        return crewRepository.findByAvailability(true)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CrewManagementDTO> getCrewByAdmin(Long adminId) {
        return crewRepository.findByAdmin_Id(adminId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CrewManagementDTO toDTO(CrewManagement crewMember) {
        CrewManagementDTO dto = new CrewManagementDTO();
        dto.setId(crewMember.getId());
        dto.setName(crewMember.getName());
        dto.setRole(crewMember.getRole().name());
        dto.setAvailability(crewMember.isAvailability());
        dto.setAdminId(crewMember.getAdmin().getId());
        return dto;
    }

    @Override
    public CrewManagement fromDTO(CrewManagementDTO crewDTO) {
        CrewManagement crewMember = new CrewManagement();
        crewMember.setId(crewDTO.getId());
        crewMember.setName(crewDTO.getName());
        crewMember.setRole(Role.valueOf(crewDTO.getRole()));
        crewMember.setAvailability(crewDTO.isAvailability());
        Admin admin = adminService.getAdminById(crewDTO.getAdminId());
        crewMember.setAdmin(admin);
        return crewMember;
    }
}
