package com.airTransport.atm_backend.service.Impl;

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

@Service
public class CrewManagementServiceImpl implements CrewManagementService {

    @Autowired
    private CrewManagementRepository crewRepository;

    @Autowired
    private AdminService adminService;

    @Override
    public CrewManagement addCrewMember(CrewManagement crewMember) {
        return crewRepository.save(crewMember);
    }

    @Override
    public CrewManagement updateCrewMember(Long id, CrewManagement updatedCrewMember) {
        CrewManagement existingCrewMember = crewRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Crew member not found with ID: " + id));

        existingCrewMember.setName(updatedCrewMember.getName());
        existingCrewMember.setRole(updatedCrewMember.getRole());
        existingCrewMember.setAvailability(updatedCrewMember.isAvailability());

        return crewRepository.save(existingCrewMember);
    }

    @Override
    public void deleteCrewMember(Long id) {
        CrewManagement crewMember = crewRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Crew member not found with ID: " + id));
        crewRepository.delete(crewMember);
    }

    @Override
    public CrewManagement getCrewMemberById(Long id) {
        return crewRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Crew member not found with ID: " + id));
    }

    @Override
    public List<CrewManagement> getCrewMembersByRole(Role role) {
        return crewRepository.findByRole(role);
    }

    @Override
    public List<CrewManagement> getAvailableCrewMembers() {
        return crewRepository.findByAvailability(true);
    }

    @Override
    public List<CrewManagement> getCrewByAdmin(Long adminId) {
        return crewRepository.findByAdmin_Id(adminId);
    }
}
