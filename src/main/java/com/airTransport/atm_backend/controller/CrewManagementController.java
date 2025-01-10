package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.CrewManagementDTO;
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
    public ResponseEntity<CrewManagementDTO> addCrewMember(@RequestBody CrewManagementDTO crewMemberDTO) {
        CrewManagementDTO createdCrewMember = crewService.addCrewMember(crewMemberDTO);
        return ResponseEntity.ok(createdCrewMember);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CrewManagementDTO> updateCrewMember(@PathVariable Long id, @RequestBody CrewManagementDTO updatedCrewMemberDTO) {
        CrewManagementDTO crewMember = crewService.updateCrewMember(id, updatedCrewMemberDTO);
        return ResponseEntity.ok(crewMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrewMember(@PathVariable Long id) {
        crewService.deleteCrewMember(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CrewManagementDTO> getCrewMemberById(@PathVariable Long id) {
        CrewManagementDTO crewMember = crewService.getCrewMemberById(id);
        return ResponseEntity.ok(crewMember);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<CrewManagementDTO>> getCrewMembersByRole(@PathVariable String role) {
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
