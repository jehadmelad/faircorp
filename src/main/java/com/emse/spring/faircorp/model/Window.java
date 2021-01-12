package com.emse.spring.faircorp.model;


import javax.persistence.*;

//Slave
@Entity
@Table(name="RWINDOW")
public class Window {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WindowStatus windowStatus;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Building building;

    public Window() {
    }

    public Window(String name, WindowStatus status, Room room) {
        this.windowStatus = status;
        this.name = name;
        this.room = room;
//        this.building = building;
    }

    public Long getId() {
        return this.id;
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

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}