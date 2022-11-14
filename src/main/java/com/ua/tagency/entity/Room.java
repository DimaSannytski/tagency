package com.ua.tagency.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room extends BaseEntity {
    @ManyToOne
    private Hotel hotel;
    @Column
    private String name;
    @OneToMany(mappedBy = "room", orphanRemoval = true, cascade = CascadeType.PERSIST)
    List<RoomOrder> orders;

    public Room(Hotel hotel, String name) {
        this.hotel = hotel;
        this.name = name;
    }
}
