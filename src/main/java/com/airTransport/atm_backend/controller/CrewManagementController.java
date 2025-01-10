package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.CrewManagementDTO;
import com.airTransport.atm_backend.model.CrewManagement;
import com.airTransport.atm_backend.model.enums.Role;
import com.airTransport.atm_backend.service.CrewManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crew-management")
public class CrewManagementController {

    @Autowired
    private CrewManagementService crewService;

    @PostMapping
    public ResponseEntity<CrewManagementDTO> addCrewMember(@RequestBody CrewManagement crewMember) {
        CrewManagementDTO createdCrewMember = crewService.addCrewMember(crewMember);
        return ResponseEntity.ok(createdCrewMember);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CrewManagementDTO> updateCrewMember(@PathVariable Long id, @RequestBody CrewManagement updatedCrewMember) {
        CrewManagementDTO crewMember = crewService.updateCrewMember(id, updatedCrewMember);
        return ResponseEntity.ok(crewMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCrewMember(@PathVariable Long id) {
        crewService.deleteCrewMember(id);
        return ResponseEntity.ok("Crew member deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<CrewManagementDTO> getCrewMemberById(@PathVariable Long id) {
        CrewManagementDTO crewMember = crewService.getCrewMemberById(id);
        return ResponseEntity.ok(crewMember);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<CrewManagementDTO>> getCrewMembersByRole(@PathVariable Role role) {
        return ResponseEntity.ok(crewService.getCrewMembersByRole(role));
    }

    @GetMapping("/available")
    public ResponseEntity<List<CrewManagementDTO>> getAvailableCrewMembers() {
        return ResponseEntity.ok(crewService.getAvailableCrewMembers());
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<CrewManagementDTO>> getCrewByAdmin(@PathVariable Long adminId) {
        return ResponseEntity.ok(crewService.getCrewByAdmin(adminId));
    }
}
