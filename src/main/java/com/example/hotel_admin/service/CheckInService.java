package com.example.hotel_admin.service;

import com.example.hotel_admin.entity.CheckInEntity;
import com.example.hotel_admin.entity.GuestEntity;
import com.example.hotel_admin.repository.CheckInRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckInService {
    private final CheckInRepository checkInRepository;

    public CheckInService(CheckInRepository checkInRepository) {
        this.checkInRepository = checkInRepository;
    }
    public CheckInEntity createCheckIn(CheckInEntity checkIn){
        return checkInRepository.save(checkIn);
    }
    public List<CheckInEntity> getCheckIns(){
        return checkInRepository.findAll();
    }
    public Optional<CheckInEntity> getCheckInById(Integer guestId){
        return checkInRepository.findById(guestId);
    }
    public void deleteCheckIn(Integer checkInId){
        checkInRepository.deleteById(checkInId);
    }
}
