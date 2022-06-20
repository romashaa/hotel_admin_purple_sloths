package com.example.hotel_admin.controller;

import com.example.hotel_admin.entity.GuestEntity;
import com.example.hotel_admin.service.GuestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }


    //    @RequestMapping("/guests")
//    public String getGuests (Model model){
//        model.addAttribute("guests", guestRepository.findAll());
//        return "guests";
//    }
    @PostMapping("/addGuest")
    public GuestEntity addGuest(@RequestBody GuestEntity guest){
        return guestService.createGuest(guest);
    }

    @GetMapping("/guests")
    public List<GuestEntity> getGuests (){
        List<GuestEntity> guests = guestService.getGuests();
        return guests;
    }
    @GetMapping("/guests/{id}")
    public Optional<GuestEntity> getGuestById (@PathVariable(value = "id") Integer guestId){
        return guestService.getGuestById(guestId);
    }
    @DeleteMapping("/deleteGuest")
    public void deleteGuest(@PathVariable (value = "id") Integer guestId){
        guestService.deleteGuest(guestId);
    }

}
