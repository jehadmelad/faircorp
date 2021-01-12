package com.emse.spring.faircorp.model;

import javax.persistence.*;


//Slave
@Entity
@Table(name = "Heater")
public class Heater {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private long power;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HeaterStatus heaterStatus;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Building building;

    public Heater(){

    }

    public Heater(String name, Room room, Building building){
        this.name = name;
        this.room = room;
        this.building =building;
    }


    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }


}