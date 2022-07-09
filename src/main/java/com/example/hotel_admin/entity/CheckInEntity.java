package com.example.hotel_admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

//@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "check_in")
public class CheckInEntity {
    public Integer getId() {
        return id;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }
    //@JsonBackReference
    public RoomEntity getRoom() {
        return room;
    }
    //@JsonBackReference
    public GuestEntity getGuest() {
        return guest;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivalDate;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date leavingDate;
//
//    @JsonBackReference
//    public GuestEntity getGuest() {
//        return guest;
//    }
//    @JsonBackReference
//    public RoomEntity getRoom() {
//        return room;
//    }

    //@JsonBackReference
   // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "room_number")
    private RoomEntity room;

   // @JsonBackReference
    @ManyToOne
  //  @JsonIgnore
    @JoinColumn(name = "guest_id")
    private GuestEntity guest;


    public CheckInEntity(Date arrivalDate, Date leavingDate, RoomEntity room, GuestEntity guest) {
        this.arrivalDate = arrivalDate;
        this.leavingDate = leavingDate;
        this.room = room;
        this.guest = guest;
    }
}
