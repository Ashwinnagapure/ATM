package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.Notification;
import com.airTransport.atm_backend.repository.AdminRepository;
import com.airTransport.atm_backend.repository.NotificationRepository;
import com.airTransport.atm_backend.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;



    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;

    }


    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElseThrow(()->new RuntimeException("Admin not found"));
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public String createAdmin(Admin admin) {
        adminRepository.save(admin);
        return "Admin created";
    }

    @Override
    public String updateAdmin(Admin admin) {
        adminRepository.save(admin);
        return "Admin updated";
    }

    @Override
    public String deleteAdmin(Long id) {
        adminRepository.deleteById(id);
        return "Admin deleted";
    }



}
