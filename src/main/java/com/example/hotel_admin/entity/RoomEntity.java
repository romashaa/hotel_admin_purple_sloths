package com.example.hotel_admin.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "rooms")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    private String type;
    @ManyToOne
    CheckInEntity checkIn;

    public RoomEntity(int n, String type) {
    }
}
