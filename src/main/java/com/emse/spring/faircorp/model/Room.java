package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Set;

//Master
@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    private Long id;

    @Column(nullable = false)
    private Integer floor;

    @Column(nullable = false)
    private String name;

    @Column
    private Double currentTemperature;

    @Column
    private Double targetTemperature;

    @OneToMany(mappedBy = "room")
    private Set<Heater> heater;

    @OneToMany(mappedBy = "room")
    private Set<Window> window;

    public Room() {
    }

    public Room(Integer floor, String name) {
        this.floor = floor;
        this.name = name;
    }
}
