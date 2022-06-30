package com.example.hotel_admin.controller;

import com.example.hotel_admin.entity.RoomEntity;
import com.example.hotel_admin.repository.CheckInRepository;
import com.example.hotel_admin.service.CheckInService;
import com.example.hotel_admin.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {
    private final RoomService roomService;
    private final CheckInService checkInService;
    private final CheckInRepository checkInRepository;

    public RoomController(RoomService roomService, CheckInService checkInService, CheckInRepository checkInRepository) {
        this.roomService = roomService;
        this.checkInService = checkInService;
        this.checkInRepository = checkInRepository;
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
    @GetMapping("/rooms/free")
    public List<RoomEntity> getFreeRooms(){
        return checkInService.findFreeRooms();
    }

    @GetMapping("/rooms/free/{type}")
    public List<RoomEntity> getFreeRoomsOfType(@PathVariable(value = "type") String type){
        return checkInRepository.getFreeRoomsOfType(java.sql.Date.valueOf(LocalDate.now()),type);
    }
//    @GetMapping("/rooms/status/{roomNumber}")
//    public String[] getRoomStatus(@PathVariable Integer roomNumber, List<RoomEntity> freeRooms){
//        freeRooms=checkInService.findFreeRooms();
//        String[] res ;
//               if(checkInRepository.getRoomStatus(roomNumber,freeRooms).isEmpty()){
//                   res = new String[]{"Зайнята", roomService.findById(roomNumber).getType()};
//               }else{
//                    res=new String[]{"Вільна", roomService.findById(roomNumber).getType()};
//               }
//        return res;
//    }

    @DeleteMapping("/deleteRoom/{id}")
    public void deleteRoom(@PathVariable (value = "id") Integer roomId){
        roomService.deleteRoom(roomId);
    }

}
