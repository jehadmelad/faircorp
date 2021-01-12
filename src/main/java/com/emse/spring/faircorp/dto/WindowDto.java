package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;

public class WindowDto {
    private Long id;
    private String name;
    private WindowStatus status;
//    private String roomName;
//    private Long roomId;
//    private Long  buildingId;
    private RoomDto room;

    public WindowDto() { }

    public WindowDto(Window window) {
        this.id = window.getId();
        this.name = window.getName();
        this.status = window.getWindowStatus();
//        this.roomId = window.getRoom().getId();
//        this.roomName = window.getRoom().getName();
//        this.buildingId = window.getBuilding().getId();
        this.room = new RoomDto(window.getRoom());
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

    public WindowStatus getStatus() {
        return status;
    }

    public void setStatus(WindowStatus status) {
        this.status = status;
    }
//    public String getRoomName() {
//        return roomName;
//    }

//    public void setRoomName(String roomName) {
//        this.roomName = roomName;
//    }

    public RoomDto getRoom() {
        return room;
    }

    public void setRoom(RoomDto room) {
        this.room = room;
    }

//    public Long getRoomId() {
//        return roomId;
//    }

//    public Long getBuildingId() {
//        return buildingId;
//    }
//
//    public void setBuildingId(Long buildingId) {
//        this.buildingId = buildingId;
//    }

//    public void setRoomId(Long roomId) {
//        this.roomId = roomId;
//    }
}