package com.example.hotel_admin.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


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
    @Column
    private String type;
    @OneToMany(mappedBy = "room")
    private List<CheckInEntity> checkIns;

    public RoomEntity(String type) {
        this.type = type;
    }
}
