package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Set;

//Master
@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer floor;

    @Column(nullable = false)
    private String name;

    @Column
    private Double currentTemperature;

    @Column
    private Double targetTemperature;

    @OneToMany(mappedBy = "room", cascade=CascadeType.REMOVE)
    private Set<Heater> heater;

    @OneToMany(mappedBy = "room", cascade=CascadeType.REMOVE)
    private Set<Window> window;

    @ManyToOne
    private Building building;

    public Room() {
    }

    public Room(Integer floor, String name) {
        this.floor = floor;
        this.name = name;
//        this.building = building;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Set<Heater> getHeater() {
        return heater;
    }

    public void setHeater(Set<Heater> heater) {
        this.heater = heater;
    }

    public Set<Window> getWindow() {
        return window;
    }

    public void setWindow(Set<Window> window) {
        this.window = window;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
