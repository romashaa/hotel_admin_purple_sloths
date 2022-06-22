package com.example.hotel_admin.service;

import com.example.hotel_admin.entity.AdminEntity;
import com.example.hotel_admin.repository.AdminRepository;
import com.example.hotel_admin.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    public AdminEntity createAdmin(AdminEntity admin){
        return adminRepository.save(admin);
    }
    public List<AdminEntity> getAdmins(){
        return adminRepository.findAll();
    }
    public Optional<AdminEntity> getAdminById(Integer adminId){
        return adminRepository.findById(adminId);
    }
    public void deleteAdmin(Integer adminId){
        adminRepository.deleteById(adminId);
    }
}
