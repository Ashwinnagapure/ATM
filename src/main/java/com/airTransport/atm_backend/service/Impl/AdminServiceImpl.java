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
    private final NotificationRepository notificationRepository;


    public AdminServiceImpl(AdminRepository adminRepository, NotificationRepository notificationRepository) {
        this.adminRepository = adminRepository;
        this.notificationRepository = notificationRepository;
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

    @Override
    public Notification sendNotification(Long id ,Notification notification) {
        Admin admin=getAdminById(id);
        notification.setAdmin(admin);
        return notificationRepository.save(notification);
    }
}
