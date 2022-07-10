package com.example.hotel_admin.repository;

import com.example.hotel_admin.entity.CheckInEntity;
import com.example.hotel_admin.entity.GuestEntity;
import com.example.hotel_admin.entity.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CheckInRepository extends JpaRepository<CheckInEntity,Integer> {

    public List<CheckInEntity> findByGuest(GuestEntity guest);

    //вільні кімнати
    @Query(value = "Select r FROM  RoomEntity r LEFT JOIN r.checkIns ch WHERE ch.leavingDate < :date OR ch.room IS NULL")
    public List<RoomEntity> getFreeRooms(@Param("date") Date date);

    //вільні кімнати певного типу
    @Query(value = "Select r FROM  RoomEntity r LEFT JOIN r.checkIns ch WHERE (ch.leavingDate < :date OR ch.room IS NULL) AND r.type= :type ")
    public List<RoomEntity> getFreeRoomsOfType(@Param("date") Date date, @Param("type") String type);


    //Вивести всіх гостей які жили в заданій кімнаті

    @Query(value = "Select ch.guest.name, ch.guest.secondName, ch.guest.surname, ch.arrivalDate, ch.leavingDate FROM  CheckInEntity ch WHERE ch.room.room_number = :roomNumber  ")
    public List<GuestEntity> getGuestsFromRoom(@Param("roomNumber") Integer roomNumber);

    //Перегляд активного статусу кімнати
//    @Query("SELECT r.type FROM RoomEntity r WHERE r.room_number= :roomNumber AND r IN :freeRooms")
//    public List<RoomEntity> getRoomStatus(@Param("roomNumber") Integer roomNumber, @Param("freeRooms") List<RoomEntity> freeRooms);

}
