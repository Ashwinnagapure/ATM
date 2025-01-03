package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.model.Notification;

import java.util.List;

public interface AdminService {
    public Admin getAdminById(Long id);
    List<Admin> getAllAdmins();
    String createAdmin(Admin admin);
    String updateAdmin(Admin admin);
    String deleteAdmin(Long id);

    Notification sendNotification(Long adminId,Notification notification);

}
