package com.emse.spring.faircorp.model;


import javax.persistence.*;
import java.util.Set;

//Master
@Entity
@Table(name = "BUILDING")
public class Building {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;


    @OneToMany(mappedBy = "building", cascade=CascadeType.REMOVE)
    private Set<Heater> heaters;

    @OneToMany(mappedBy = "building", cascade=CascadeType.REMOVE)
    private Set<Window> windows;

    @OneToMany(mappedBy = "building", cascade=CascadeType.REMOVE)
    private Set<Room> room;

    public Building(){

    }

    public Building(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Room> getRoom() {
        return room;
    }

    public void setRoom(Set<Room> room) {
        this.room = room;
    }


    public Set<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(Set<Heater> heaters) {
        this.heaters = heaters;
    }

    public Set<Window> getWindows() {
        return windows;
    }

    public void setWindows(Set<Window> windows) {
        this.windows = windows;
    }
}
