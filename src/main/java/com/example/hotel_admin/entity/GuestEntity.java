package com.example.hotel_admin.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class GuestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String fullName;
    @Column
    private String telNum;
    @OneToMany(mappedBy = "guest")
    private List<CheckInEntity> checkIns;


    public GuestEntity(int i, String guest1, String s) {
    }

    public GuestEntity(String fullName, String telNum) {
        this.fullName = fullName;
        this.telNum = telNum;
    }


}
