package com.example.hotel_admin.controller;

import com.example.hotel_admin.entity.GuestEntity;
import com.example.hotel_admin.repository.CheckInRepository;
import com.example.hotel_admin.service.GuestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GuestController {

    private final GuestService guestService;
    private final CheckInRepository checkInRepository;

    public GuestController(GuestService guestService, CheckInRepository checkInRepository) {
        this.guestService = guestService;
        this.checkInRepository = checkInRepository;
    }


    //    @RequestMapping("/guests")
//    public String getGuests (Model model){
//        model.addAttribute("guests", guestRepository.findAll());
//        return "guests";
//    }
    @PostMapping(value = "/addGuest", consumes = {"*/*"})
    public ResponseEntity<GuestEntity> addGuest(@RequestBody GuestEntity guest){
        return new ResponseEntity<GuestEntity>(guestService.createGuest(guest), HttpStatus.CREATED);
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
    @GetMapping("/guests/name")
    public GuestEntity getGuestByFullName (@RequestParam(value = "n1") String n1, @RequestParam(value = "n2") String n2, @RequestParam(value = "n3") String n3){
        return guestService.findGuestByFullName(n1,n2,n3);
    }
    @GetMapping("/guests/room/{roomNumber}")
    public List<GuestEntity> getGuestsFromRoom (@PathVariable(value = "roomNumber") Integer roomNumber){
        List<GuestEntity> guests = checkInRepository.getGuestsFromRoom(roomNumber);
        return guests;
    }

    @DeleteMapping("/deleteGuest/{id}")
    public void deleteGuest(@PathVariable (value = "id") Integer guestId){
        guestService.deleteGuest(guestId);
    }

}
