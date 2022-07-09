package com.example.hotel_admin.controller;

import com.example.hotel_admin.entity.CheckInEntity;
import com.example.hotel_admin.service.CheckInService;
import com.example.hotel_admin.service.GuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/checkIns")
public class CheckInController {
    private final CheckInService checkInService;
    private final GuestService guestService;
//
//    public CheckInController(CheckInService checkInService, GuestService guestService) {
//        this.checkInService = checkInService;
//       // this.guestService = guestService;
//    }

    public CheckInController(CheckInService checkInService, GuestService guestService) {
        this.checkInService = checkInService;
        this.guestService = guestService;
    }

    @PostMapping("/addCheckIn")
    public CheckInEntity addCheckIn(@RequestBody CheckInEntity checkIn){
        return checkInService.createCheckIn(checkIn);
    }

    @GetMapping()
    public List<CheckInEntity> getCheckIns (){
        List<CheckInEntity> checkIns = checkInService.getCheckIns();
        return checkIns;
    }
    @GetMapping("/{id}")
    public Optional<CheckInEntity> getCheckInById (@PathVariable(value = "id") Integer checkInId){
        return checkInService.getCheckInById(checkInId);
    }
    @DeleteMapping("/{id}")
    public void deleteCheckIn(@PathVariable (value = "id") Integer checkInId){
        checkInService.deleteCheckIn(checkInId);
    }
    @GetMapping("/new")
    public String newCheckIn(Model model){
        model.addAttribute("checkIn", new CheckInEntity());
        model.addAttribute("clients",guestService.getGuests());
        return "placeclient";
    }
    @PostMapping()
    public String createCheckIn(@ModelAttribute("checkIn") CheckInEntity checkIn){
        checkInService.createCheckIn(checkIn);
        return "placeclient";
    }


}
