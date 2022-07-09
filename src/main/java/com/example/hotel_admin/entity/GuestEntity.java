package com.example.hotel_admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Component
@Table(name = "guests")
public class GuestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer guest_id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String secondName;
    @Column
    private String telNum;
    //@JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "guest",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CheckInEntity> checkIns;




    public GuestEntity(String name, String surname, String secondName, String telNum) {
        this.name = name;
        this.surname = surname;
        this.secondName = secondName;
        this.telNum = telNum;
    }
}
