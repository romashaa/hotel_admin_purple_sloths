package com.example.hotel_admin;

import com.example.hotel_admin.entity.CheckInEntity;
import com.example.hotel_admin.entity.GuestEntity;
import com.example.hotel_admin.entity.RoomEntity;
import com.example.hotel_admin.repository.CheckInRepository;
import com.example.hotel_admin.repository.GuestRepository;
import com.example.hotel_admin.repository.RoomRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class HotelAdminApplication {

    public static void main(String[] args) throws ParseException {
//        ConfigurableApplicationContext configurableApplicationContext =
        SpringApplication.run(HotelAdminApplication.class, args);
//        RoomRepository roomRepository = configurableApplicationContext.getBean(RoomRepository.class);
//        CheckInRepository checkInRepository = configurableApplicationContext.getBean(CheckInRepository.class);
//        GuestRepository guestRepository = configurableApplicationContext.getBean(GuestRepository.class);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String dateInString1 = "2022-01-15";
//        Date date1 = sdf.parse(dateInString1);
//        String dateInString2 = "2022-01-23";
//        Date date2 = sdf.parse(dateInString1);
//        RoomEntity r1 = new RoomEntity("standard");
//        RoomEntity r2 = new RoomEntity("comfort");
//        roomRepository.save(r1);
//        roomRepository.save(r2);
//        GuestEntity g1 = new GuestEntity("guest1","93957375");
//        GuestEntity g2 = new GuestEntity("guest2","64257768");
//        guestRepository.save(g1);
//        guestRepository.save(g2);
//        CheckInEntity ch1 = new CheckInEntity(date1,date2,r1,g1);
//        checkInRepository.save(ch1);

    }

}
