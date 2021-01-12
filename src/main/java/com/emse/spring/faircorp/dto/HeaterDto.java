package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import com.emse.spring.faircorp.model.WindowStatus;

public class HeaterDto {
    private Long id;
    private String name;
    private long power;
//    private Long roomId;
    private HeaterStatus heaterStatus;
//    private Long  buildingId;
    private RoomDto room;

    public HeaterDto(){}
    public HeaterDto(Heater heater){
        this.id = heater.getId();
        this.name = heater.getName();
        this.power = heater.getPower();
//        this.roomId =heater.getRoom().getId();
        this.heaterStatus = heater.getHeaterStatus();
//        this.buildingId = heater.getBuilding().getId();
        this.room = new RoomDto(heater.getRoom());
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

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

//    public Long getRoomId() {
//        return roomId;
//    }
//
//    public void setRoomId(Long roomId) {
//        this.roomId = roomId;
//    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }

//    public Long getBuildingId() {
//        return buildingId;
//    }
//
//    public void setBuildingId(Long buildingId) {
//        this.buildingId = buildingId;
//    }

    public RoomDto getRoom() {
        return room;
    }

    public void setRoom(RoomDto room) {
        this.room = room;
    }
}
