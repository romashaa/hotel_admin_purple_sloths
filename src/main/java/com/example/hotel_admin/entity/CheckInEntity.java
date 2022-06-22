package com.example.hotel_admin.entity;

import lombok.*;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
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
    @Column(nullable = false)
    private Date arrivalDate;
    @Column(nullable = false)
    private Date leavingDate;


    @ManyToOne
    @JoinColumn(name = "room_number")
    private RoomEntity room;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private GuestEntity guest;


    public CheckInEntity(Date arrivalDate, Date leavingDate, RoomEntity room, GuestEntity guest) {
        this.arrivalDate = arrivalDate;
        this.leavingDate = leavingDate;
        this.room = room;
        this.guest = guest;
    }
}
