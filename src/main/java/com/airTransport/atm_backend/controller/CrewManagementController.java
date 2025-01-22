package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.CrewManagementDTO;
import com.airTransport.atm_backend.service.CrewManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crew-management")
@CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
public class CrewManagementController {

    @Autowired
    private CrewManagementService crewService;

    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @PostMapping
    public ResponseEntity<CrewManagementDTO> addCrewMember(@RequestBody CrewManagementDTO crewMemberDTO) {
        CrewManagementDTO createdCrewMember = crewService.addCrewMember(crewMemberDTO);
        return ResponseEntity.ok(createdCrewMember);
    }

    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @PutMapping("/{id}")
    public ResponseEntity<CrewManagementDTO> updateCrewMember(@PathVariable Long id, @RequestBody CrewManagementDTO updatedCrewMemberDTO) {
        CrewManagementDTO crewMember = crewService.updateCrewMember(id, updatedCrewMemberDTO);
        return ResponseEntity.ok(crewMember);
    }

    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrewMember(@PathVariable Long id) {
        crewService.deleteCrewMember(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173", allowCredentials = "true")
    @GetMapping("/{id}")
    public ResponseEntity<CrewManagementDTO> getCrewMemberById(@PathVariable Long id) {
        CrewManagementDTO crewMember = crewService.getCrewMemberById(id);
        return ResponseEntity.ok(crewMember);
    }



    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173/metronic8/react/demo8/auth", allowCredentials = "true")
    @GetMapping("/role/{role}")
    public ResponseEntity<List<CrewManagementDTO>> getCrewMembersByRole(@PathVariable String role) {
        return ResponseEntity.ok(crewService.getCrewMembersByRole(role));
    }

    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173/metronic8/react/demo8/auth", allowCredentials = "true")
    @GetMapping("/available")
    public ResponseEntity<List<CrewManagementDTO>> getAvailableCrewMembers() {
        return ResponseEntity.ok(crewService.getAvailableCrewMembers());
    }

    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173/metronic8/react/demo8/auth", allowCredentials = "true")
    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<CrewManagementDTO>> getCrewByAdmin(@PathVariable Long adminId) {
        return ResponseEntity.ok(crewService.getCrewByAdmin(adminId));
    }
    @CrossOrigin(origins = "http://ec2-54-197-168-131.compute-1.amazonaws.com:5173/metronic8/react/demo8/auth", allowCredentials = "true")
    @GetMapping("/all")
    public ResponseEntity<List<CrewManagementDTO>> getAllCrewMembers() {
        return ResponseEntity.ok(crewService.getAllCrewMembers());
    }
}
