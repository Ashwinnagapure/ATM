package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.CrewManagement;
import com.airTransport.atm_backend.model.Role;
import com.airTransport.atm_backend.repository.CrewManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrewManagementService {
    @Autowired
    private CrewManagementRepository crewMemberRepository;


    public CrewManagement addCrewMember(CrewManagement crewMember) {
        return crewMemberRepository.save(crewMember);
    }


    public CrewManagement updateCrewMember(Long id, CrewManagement crewMember) {
        CrewManagement existingCrew = crewMemberRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Crew Member not found"));
        existingCrew.setName(crewMember.getName());
        existingCrew.setRole(crewMember.getRole());
        existingCrew.setAvailability(crewMember.isAvailability());
        return crewMemberRepository.save(existingCrew);
    }


    public void deleteCrewMember(Long id) {
        crewMemberRepository.deleteById(id);
    }


    public CrewManagement getCrewMemberById(Long id) {
        return crewMemberRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Crew Member not found"));
    }


    public List<CrewManagement> getCrewMembersByRole(Role role) {
        return crewMemberRepository.findByRole(role);
    }


    public List<CrewManagement> getAvailableCrewMembers() {
        return crewMemberRepository.findByAvailability(true);
    }
}
