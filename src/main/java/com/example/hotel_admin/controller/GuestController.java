package com.example.hotel_admin.controller;

import com.example.hotel_admin.entity.GuestEntity;
import com.example.hotel_admin.repository.GuestRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class GuestController {

    private final GuestRepository guestRepository;

    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }
//    @RequestMapping("/guests")
//    public String getGuests (Model model){
//        model.addAttribute("guests", guestRepository.findAll());
//        return "guests";
//    }
    @PostMapping("/guests")
    public void addGuest(GuestEntity guest){
        guestRepository.save(guest);
    }

    @GetMapping("/guests")
    public List<GuestEntity> getGuests (){
        List<GuestEntity> guests = guestRepository.findAll();
        return guests;
    }

}
