package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Room;

import javax.persistence.Column;

public class RoomDto {

    private Long id;
    private Integer level;
    private String name;
    private Double currentTemperature;
    private Double targetTemperature;
//    private BuildingDto building;

    public RoomDto(){ }
    public RoomDto(Room room){
        this.id = room.getId();
        this.name = room.getName();
        this.level=room.getFloor();
        this.currentTemperature = room.getCurrentTemperature();
        this.targetTemperature = room.getTargetTemperature();
//        this.building = new BuildingDto(room.getBuilding());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

//    public Long getBuildingId() {
//        return buildingId;
//    }
//
//    public void setBuildingId(Long buildingId) {
//        this.buildingId = buildingId;
//    }



//    public BuildingDto getBuilding() {
//        return building;
//    }
//
//    public void setBuilding(BuildingDto building) {
//        this.building = building;
//    }
}
