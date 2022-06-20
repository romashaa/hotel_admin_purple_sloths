package com.example.hotel_admin.service;

import com.example.hotel_admin.entity.GuestEntity;
import com.example.hotel_admin.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }
    public GuestEntity createGuest(GuestEntity guest){
        return guestRepository.save(guest);
    }
    public List<GuestEntity> getGuests(){
        return guestRepository.findAll();
    }
    public Optional<GuestEntity> getGuestById(Integer guestId){
        return guestRepository.findById(guestId);
    }
    public void deleteGuest(Integer guestId){
        guestRepository.deleteById(guestId);
    }
}
