package com.example.hotel_admin;

import com.example.hotel_admin.entity.RoomEntity;
import com.example.hotel_admin.repository.RoomRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {
    private final RoomRepository roomRepository;

    public DataInit(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        RoomEntity r1 = new RoomEntity(1,"standard");
        RoomEntity r2 = new RoomEntity(2,"comfort");
      //  r1.setType("comfort");
        roomRepository.save(r1);
        roomRepository.save(r2);
    }
}
