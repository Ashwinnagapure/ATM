package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.CrewManagement;
import com.airTransport.atm_backend.model.enums.Role;
import com.airTransport.atm_backend.service.AdminService;
import com.airTransport.atm_backend.service.CrewManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crew-management")
public class CrewManagementController {

    private CrewManagementService crewManagementService;
    private final AdminService adminService;

    public CrewManagementController(CrewManagementService crewManagementService, AdminService adminService) {
        this.crewManagementService = crewManagementService;
        this.adminService = adminService;
    }


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

    @GetMapping("/admin/{adminId}")
    public List<CrewManagement> getCrewByAdmin(@PathVariable Long adminId) {

        return crewManagementService.getCrewByAdmin(adminId);
    }
}
