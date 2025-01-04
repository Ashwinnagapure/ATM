package com.airTransport.atm_backend.controller;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.Notification;
import com.airTransport.atm_backend.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id){
        return adminService.getAdminById(id);
    }

    @GetMapping
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }
    @PostMapping
    public String createAdmin(@RequestBody Admin admin){
        adminService.createAdmin(admin);
        return "Admin created";
    }

    @PutMapping
    public String updateAdmin(@RequestBody Admin admin){
        adminService.updateAdmin(admin);
        return "Admin updated";
    }

    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
        return "Admin deleted";
    }

    @PostMapping("/{id}/notification")
    public Notification sendNotification(@PathVariable Long id,@RequestBody Notification notification){
        return adminService.sendNotification(id, notification);
    }

}
