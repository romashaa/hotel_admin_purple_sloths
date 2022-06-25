package com.example.hotel_admin.controller;

import com.example.hotel_admin.entity.RoomEntity;
import com.example.hotel_admin.service.RoomService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @PostMapping( "/addRoom")
    public RoomEntity addRoom(@RequestBody RoomEntity room){
        return roomService.createRoom(room);
    }

    @GetMapping("/rooms")
    public List<RoomEntity> getRooms (){
        List<RoomEntity> rooms = roomService.getRooms();
        return rooms;
    }
    @GetMapping("/rooms/{id}")
    public Optional<RoomEntity> getRoomById (@PathVariable(value = "id") Integer roomId){
        return roomService.getRoomById(roomId);
    }
    @DeleteMapping("/deleteRoom")
    public void deleteRoom(@PathVariable (value = "id") Integer roomId){
        roomService.deleteRoom(roomId);
    }

}
