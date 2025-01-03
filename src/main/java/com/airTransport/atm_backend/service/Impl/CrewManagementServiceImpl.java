package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.CrewManagement;
import com.airTransport.atm_backend.model.enums.Role;
import com.airTransport.atm_backend.repository.CrewManagementRepository;
import com.airTransport.atm_backend.service.CrewManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrewManagementServiceImpl implements CrewManagementService {
    @Autowired
    private CrewManagementRepository crewMemberRepository;

    @Autowired
    private  AdminServiceImpl adminService;

    @Override
    public CrewManagement addCrewMember(CrewManagement crewMember) {
        return crewMemberRepository.save(crewMember);
    }

    @Override
    public CrewManagement updateCrewMember(Long id, CrewManagement crewMember) {
        CrewManagement existingCrew = crewMemberRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Crew Member not found"));
        existingCrew.setName(crewMember.getName());
        existingCrew.setRole(crewMember.getRole());
        existingCrew.setAvailability(crewMember.isAvailability());
        return crewMemberRepository.save(existingCrew);
    }

    @Override
    public void deleteCrewMember(Long id) {
        crewMemberRepository.deleteById(id);
    }

    @Override
    public CrewManagement getCrewMemberById(Long id) {
        return crewMemberRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Crew Member not found"));
    }

    @Override
    public List<CrewManagement> getCrewMembersByRole(Role role) {
        return crewMemberRepository.findByRole(role);
    }

    @Override
    public List<CrewManagement> getAvailableCrewMembers() {
        return crewMemberRepository.findByAvailability(true);
    }

    @Override
    public List<CrewManagement> getCrewByAdmin(Long adminId){
        Admin admin = adminService.getAdminById(adminId);
        return crewMemberRepository.findByAdmin(admin);
    }
}
