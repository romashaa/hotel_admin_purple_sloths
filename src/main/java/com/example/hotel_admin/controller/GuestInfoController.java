package com.example.hotel_admin.controller;

import com.example.hotel_admin.entity.CheckInEntity;
import com.example.hotel_admin.entity.GuestEntity;
import com.example.hotel_admin.repository.CheckInRepository;
import com.example.hotel_admin.service.GuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/info")
public class GuestInfoController {

    private final GuestService guestService;
    private final CheckInRepository checkInRepository;

    public GuestInfoController(GuestService guestService, CheckInRepository checkInRepository) {
        this.guestService = guestService;
        this.checkInRepository = checkInRepository;
    }

    @GetMapping()
    public String info(Model model){
        model.addAttribute("clients",guestService.getGuests());
        List<CheckInEntity> checkIns = new ArrayList<>();
            model.addAttribute("checkIns", checkIns);
        return "findclient";

    }
    @PostMapping()
    public String showInfo(Model model, @RequestParam(value = "guestName",required = false) GuestEntity guest){
        model.addAttribute("checkIns",checkInRepository.findByGuest(guest));
        return "findclient";
    }
    // guestInfo(guest.getName(),guest.getSurname(),guest.getSecondName())
//    @PostMapping()
//    public String showInfo(@ModelAttribute("checkIn") CheckInEntity checkIn, @RequestParam(value = "guestName") GuestEntity guest){
//
//        return "findclient";
//    }
    private List<String[]> guestInfo (String name, String surname, String lastname){
        List<CheckInEntity> checkIns = checkInRepository.findByGuest(guestService.findGuestByFullName(name,surname,lastname));
        List<String[]> res = new ArrayList<>();
        for(CheckInEntity ch : checkIns){
            String[] info = new String[]{String.valueOf(ch.getRoom().getRoom_number()), ch.getRoom().getType(), String.valueOf(ch.getArrivalDate()), String.valueOf(ch.getLeavingDate())};
            res.add(info);
        }
        return res;
    }
}
