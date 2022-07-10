package com.example.hotel_admin.controller;

import com.example.hotel_admin.entity.AdminEntity;
import com.example.hotel_admin.entity.GuestEntity;
import com.example.hotel_admin.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

//    @PostMapping("/addAdmin")
//    public AdminEntity addAdmin(@RequestBody AdminEntity admin){
//        return adminService.createAdmin(admin);
//    }

    @GetMapping()
    public List<AdminEntity> getAdmins (){
        List<AdminEntity> admins = adminService.getAdmins();
        return admins;
    }
    @GetMapping("/{id}")
    public Optional<AdminEntity> getAdminById (@PathVariable(value = "id") Integer adminId){
        return adminService.getAdminById(adminId);
    }
    @GetMapping("/new")
    public String newAdmin(Model model){
        model.addAttribute("admin", new AdminEntity());
        return "addadmin";
    }
    @PostMapping()
    public String createAdmin(@ModelAttribute("admin") AdminEntity admin){
        adminService.createAdmin(admin);
        return "addadmin";
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable (value = "id") Integer adminId){
        adminService.deleteAdmin(adminId);
    }
}
