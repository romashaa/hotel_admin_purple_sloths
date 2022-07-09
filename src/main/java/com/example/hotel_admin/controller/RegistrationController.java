package com.example.hotel_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping("/")
public class RegistrationController {
    @RequestMapping("/")
    public String start() {
     //   model.addAttribute("name", name);
        return "login";
    }
    @RequestMapping("/login")
    public String login() {
        //   model.addAttribute("name", name);
        return "login";
    }
    @RequestMapping("/home")
    public String home() {
        //   model.addAttribute("name", name);
        return "home";
    }
}
