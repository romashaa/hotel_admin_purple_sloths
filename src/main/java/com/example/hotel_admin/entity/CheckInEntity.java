package com.example.hotel_admin.entity;

import lombok.*;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class CheckInEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date arrivalDate;
    private Date leavingDate;

    @OneToMany
    Set <RoomEntity> rooms;

    @OneToMany
    Set<GuestEntity> guests;

}
