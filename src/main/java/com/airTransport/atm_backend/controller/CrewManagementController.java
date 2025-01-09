package com.airTransport.atm_backend.controller;

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
    public ResponseEntity<CrewManagement> addCrewMember(@RequestBody CrewManagement crewMember) {
        CrewManagement createdCrewMember = crewService.addCrewMember(crewMember);
        return ResponseEntity.ok(createdCrewMember);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CrewManagement> updateCrewMember(@PathVariable Long id, @RequestBody CrewManagement updatedCrewMember) {
        CrewManagement crewMember = crewService.updateCrewMember(id, updatedCrewMember);
        return ResponseEntity.ok(crewMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrewMember(@PathVariable Long id) {
        crewService.deleteCrewMember(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CrewManagement> getCrewMemberById(@PathVariable Long id) {
        CrewManagement crewMember = crewService.getCrewMemberById(id);
        return ResponseEntity.ok(crewMember);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<CrewManagement>> getCrewMembersByRole(@PathVariable Role role) {
        return ResponseEntity.ok(crewService.getCrewMembersByRole(role));
    }

    @GetMapping("/available")
    public ResponseEntity<List<CrewManagement>> getAvailableCrewMembers() {
        return ResponseEntity.ok(crewService.getAvailableCrewMembers());
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<CrewManagement>> getCrewByAdmin(@PathVariable Long adminId) {
        return ResponseEntity.ok(crewService.getCrewByAdmin(adminId));
    }
}
