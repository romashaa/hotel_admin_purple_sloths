package com.example.hotel_admin.controller;

import com.example.hotel_admin.entity.CheckInEntity;
import com.example.hotel_admin.service.CheckInService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CheckInController {
    private final CheckInService checkInService;

    public CheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }
    @PostMapping("/addCheckIn")
    public CheckInEntity addCheckIn(@RequestBody CheckInEntity checkIn){
        return checkInService.createCheckIn(checkIn);
    }

    @GetMapping("/checkIns")
    public List<CheckInEntity> getCheckIns (){
        List<CheckInEntity> checkIns = checkInService.getCheckIns();
        return checkIns;
    }
    @GetMapping("/checkIns/{id}")
    public Optional<CheckInEntity> getCheckInById (@PathVariable(value = "id") Integer checkInId){
        return checkInService.getCheckInById(checkInId);
    }
    @DeleteMapping("/deleteCheckIn")
    public void deleteCheckIn(@PathVariable (value = "id") Integer checkInId){
        checkInService.deleteCheckIn(checkInId);
    }
}
