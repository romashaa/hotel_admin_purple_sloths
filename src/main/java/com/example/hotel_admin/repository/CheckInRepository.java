package com.example.hotel_admin.repository;

import com.example.hotel_admin.entity.CheckInEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInRepository extends JpaRepository<CheckInEntity,Integer> {
}
