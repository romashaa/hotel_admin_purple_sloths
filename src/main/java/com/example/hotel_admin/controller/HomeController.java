package com.example.hotel_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home() {
        return "home";
    }
    @RequestMapping("/addclient")
    public String addClient() {
        return "addclient";
    }
    @RequestMapping("/placeclient")
    public String placeClient() {
        return "placeclient";
    }
    @RequestMapping("/findclient")
    public String findClient() {
        return "findclient";
    }
    @RequestMapping("/addadmin")
    public String addAdmin() {
        return "addadmin";
    }
    @RequestMapping("/manageRooms")
    public String manageRooms() {
        return "rooms";
    }
}
