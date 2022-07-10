package com.example.hotel_admin.controller;

import com.example.hotel_admin.entity.AdminEntity;
import com.example.hotel_admin.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/login")
public class RegistrationController {
    private final AdminService adminService;

    public RegistrationController(AdminService adminService) {
        this.adminService = adminService;
    }
    @GetMapping()
    public String login(Model model){
        model.addAttribute("admin", new AdminEntity());
        return "login";
    }
    @PostMapping()
    public String login(@ModelAttribute("admin") AdminEntity admin,@RequestParam(value = "login",required = false) String login,@RequestParam(value = "password",required = false) String password){
        System.out.println(login + " " + password);
        List<AdminEntity> allAdmins = adminService.getAdmins();

        for(AdminEntity current:allAdmins) {
            if (current.getLogin().equals(login) && current.getPassword().equals(password)) {
                return "redirect:/home";
            }
        }
        return "redirect:/login";

    }
    @RequestMapping("/")
    public String start() {
        return "login";
    }
    @RequestMapping("/login")
    public String login() {
        //   model.addAttribute("name", name);
        return "login";
    }
//    @RequestMapping("/home")
//    public String home() {
//        //   model.addAttribute("name", name);
//        return "home";
//    }
}
