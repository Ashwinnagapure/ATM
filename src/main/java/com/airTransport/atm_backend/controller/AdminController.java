package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.dto.AdminDTO;
import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody AdminDTO adminDTO) {
        return ResponseEntity.ok(adminService.createAdmin(adminDTO));
    }

    @CrossOrigin(origins = "hhttp://localhost:5173", allowCredentials = "true")
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody AdminDTO updatedAdminDTO) {
        return ResponseEntity.ok(adminService.updateAdmin(id, updatedAdminDTO));
    }

    @CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}