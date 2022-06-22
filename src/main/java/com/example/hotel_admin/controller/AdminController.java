package com.example.hotel_admin.controller;

import com.example.hotel_admin.entity.AdminEntity;
import com.example.hotel_admin.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @PostMapping("/addAdmin")
    public AdminEntity addAdmin(@RequestBody AdminEntity admin){
        return adminService.createAdmin(admin);
    }

    @GetMapping("/admins")
    public List<AdminEntity> getAdmins (){
        List<AdminEntity> admins = adminService.getAdmins();
        return admins;
    }
    @GetMapping("/admins/{id}")
    public Optional<AdminEntity> getAdminById (@PathVariable(value = "id") Integer adminId){
        return adminService.getAdminById(adminId);
    }
    @DeleteMapping("/deleteAdmin")
    public void deleteAdmin(@PathVariable (value = "id") Integer adminId){
        adminService.deleteAdmin(adminId);
    }
}
