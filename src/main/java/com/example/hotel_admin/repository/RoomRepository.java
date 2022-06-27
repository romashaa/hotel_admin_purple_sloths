package com.example.hotel_admin.repository;

import com.example.hotel_admin.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity,Integer> {

//    @Query(value ="SELECT ch.room FROM CheckInEntity ch WHERE ch.leavingDate < date", nativeQuery = true)
//    public List<RoomEntity> getFreeRooms(LocalDate date);
}
