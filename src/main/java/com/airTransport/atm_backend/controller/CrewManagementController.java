package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.CrewManagement;
import com.airTransport.atm_backend.model.Role;
import com.airTransport.atm_backend.service.CrewManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crew-management")
public class CrewManagementController {
    @Autowired
    private CrewManagementService crewManagementService;

    @PostMapping
    public CrewManagement addCrewMember(@RequestBody CrewManagement crewMember) {
        return crewManagementService.addCrewMember(crewMember);
    }

    @PutMapping("/{id}")
    public CrewManagement updateCrewMember(@PathVariable Long id, @RequestBody CrewManagement crewMember) {
        return crewManagementService.updateCrewMember(id, crewMember);
    }

    @DeleteMapping("/{id}")
    public void deleteCrewMember(@PathVariable Long id) {
        crewManagementService.deleteCrewMember(id);
    }

    @GetMapping("/{id}")
    public CrewManagement getCrewMemberById(@PathVariable Long id) {
        return crewManagementService.getCrewMemberById(id);
    }

    @GetMapping("/role/{role}")
    public List<CrewManagement> getCrewMembersByRole(@PathVariable Role role) {
        return crewManagementService.getCrewMembersByRole(role);
    }

    @GetMapping("/available")
    public List<CrewManagement> getAvailableCrewMembers() {
        return crewManagementService.getAvailableCrewMembers();
    }
}
