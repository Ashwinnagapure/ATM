package com.airTransport.atm_backend.service;

import com.airTransport.atm_backend.dto.AdminDTO;
import com.airTransport.atm_backend.model.Admin;

import java.util.List;

public interface AdminService {
    Admin getAdminById(Long id);
    List<Admin> getAllAdmins();
    Admin createAdmin(AdminDTO adminDTO);
    Admin updateAdmin(Long id, AdminDTO updatedAdminDTO);
    void deleteAdmin(Long id);
}