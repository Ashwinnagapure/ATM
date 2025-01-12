package com.airTransport.atm_backend.service.Impl;

import com.airTransport.atm_backend.dto.AdminDTO;
import com.airTransport.atm_backend.exceptions.NotFoundException;
import com.airTransport.atm_backend.model.Admin;
import com.airTransport.atm_backend.repository.AdminRepository;
import com.airTransport.atm_backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Admin not found with ID: " + id));
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin createAdmin(AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setName(adminDTO.getName());
        admin.setEmail(adminDTO.getEmail());
        admin.setPassword(adminDTO.getPassword());
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Long id, AdminDTO updatedAdminDTO) {
        Admin existingAdmin = getAdminById(id);
        existingAdmin.setName(updatedAdminDTO.getName());
        existingAdmin.setEmail(updatedAdminDTO.getEmail());
        existingAdmin.setPassword(updatedAdminDTO.getPassword());
        return adminRepository.save(existingAdmin);
    }

    @Override
    public void deleteAdmin(Long id) {
        Admin admin = getAdminById(id);
        adminRepository.delete(admin);
    }
}