package com.example.hotel_admin.controller;

import com.example.hotel_admin.entity.AdminEntity;
import com.example.hotel_admin.entity.CheckInEntity;
import com.example.hotel_admin.entity.GuestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class RegistrationController {
    @GetMapping()
    public String login(Model model){
        model.addAttribute("admin", new AdminEntity());
        return "login";
    }
    @PostMapping()
    public String login(@ModelAttribute("admin") AdminEntity admin,@RequestParam(value = "login",required = false) String login,@RequestParam(value = "password",required = false) String password){
        System.out.println(login + " " + password);
        //if true return "redirect:/home"
        //else return "redirect:/login"
        return "redirect:/home";

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
