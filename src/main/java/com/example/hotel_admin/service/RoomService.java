package com.example.hotel_admin.service;



import com.example.hotel_admin.entity.RoomEntity;
import com.example.hotel_admin.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    public RoomEntity createRoom(RoomEntity room){
        return roomRepository.save(room);
    }
    public List<RoomEntity> getRooms(){
        return roomRepository.findAll();
    }
    public Optional<RoomEntity> getRoomById(Integer roomId){
        return roomRepository.findById(roomId);
    }
    public void deleteRoom(Integer roomId){
        roomRepository.deleteById(roomId);
    }
//    public List<RoomEntity> findFreeRooms(){
//        return roomRepository.getFreeRooms(LocalDate.now());
//    }
}
