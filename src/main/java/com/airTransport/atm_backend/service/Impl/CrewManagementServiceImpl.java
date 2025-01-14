package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.CrewManagementDTO;
import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.CrewManagement;
import com.airTransport.atm_backend.model.Admin;
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
    public CrewManagementDTO addCrewMember(CrewManagementDTO crewMemberDTO) {
        CrewManagement crewMember = new CrewManagement();
        crewMember.setName(crewMemberDTO.getName());
        crewMember.setRole(crewMemberDTO.getRole());
        crewMember.setAvailability(crewMemberDTO.isAvailability());

        Admin admin = adminService.getAdminById(crewMemberDTO.getAdminId()); // Assuming this method exists
        crewMember.setAdmin(admin);

        crewMember = crewRepository.save(crewMember);
        return convertToDTO(crewMember);
    }

    @Override
    public CrewManagementDTO updateCrewMember(Long id, CrewManagementDTO updatedCrewMemberDTO) {
        CrewManagement existingCrewMember = crewRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Crew member not found with ID: " + id));

        existingCrewMember.setName(updatedCrewMemberDTO.getName());
        existingCrewMember.setRole(updatedCrewMemberDTO.getRole());
        existingCrewMember.setAvailability(updatedCrewMemberDTO.isAvailability());

        Admin admin = adminService.getAdminById(updatedCrewMemberDTO.getAdminId());
        existingCrewMember.setAdmin(admin);

        existingCrewMember = crewRepository.save(existingCrewMember);
        return convertToDTO(existingCrewMember);
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
        return convertToDTO(crewMember);
    }

    @Override
    public List<CrewManagementDTO> getCrewMembersByRole(String role) {
        Role enumRole = Role.valueOf(role.toUpperCase());
        List<CrewManagement> crewMembers = crewRepository.findByRole(enumRole);
        return crewMembers.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<CrewManagementDTO> getAvailableCrewMembers() {
        List<CrewManagement> crewMembers = crewRepository.findByAvailability(true);
        return crewMembers.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<CrewManagementDTO> getCrewByAdmin(Long adminId) {
        List<CrewManagement> crewMembers = crewRepository.findByAdmin_Id(adminId);
        return crewMembers.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<CrewManagementDTO> getAllCrewMembers() {
        List<CrewManagement> crewMembers = crewRepository.findAll();
        return crewMembers.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Utility method to convert CrewManagement entity to CrewManagementDTO
    private CrewManagementDTO convertToDTO(CrewManagement crewMember) {
        CrewManagementDTO dto = new CrewManagementDTO();
        dto.setId(crewMember.getId());
        dto.setName(crewMember.getName());
        dto.setRole(crewMember.getRole());
        dto.setAvailability(crewMember.isAvailability());
        dto.setAdminId(crewMember.getAdmin().getId());
        return dto;
    }
}
