package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.model.Admin;

import java.util.List;

public interface AdminService {
    Admin getAdminById(Long id);
    List<Admin> getAllAdmins();
    Admin createAdmin(Admin admin);
    Admin updateAdmin(Long id, Admin updatedAdmin);
    void deleteAdmin(Long id);
}
