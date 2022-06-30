package com.example.hotel_admin.repository;


import com.example.hotel_admin.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity,Integer> {
    // GuestEntity findByGuest_id(Integer id);
    // Вивести всіх гостей які жили в заданій кімнаті
    //public List<GuestEntity>

    //Вивести гостя за ПІБ
    public GuestEntity findByNameAndSecondNameAndSurname(String name, String surname, String lastname);

}
