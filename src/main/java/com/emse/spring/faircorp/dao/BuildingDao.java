package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BuildingDao extends JpaRepository<Building, Long> {

    @Query("select b from Building b where b.name=:name")
    Building findByName(@Param("name") String name);
}