package com.emse.spring.faircorp.api;


import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/Rooms")
@Transactional
public class RoomController {

    private final RoomDao roomDao;
    private final WindowDao windowDao;
    private final HeaterDao heaterDao;
    private final BuildingDao buildingDao;

    public RoomController(RoomDao roomDao, WindowDao windowDao, HeaterDao heaterDao, BuildingDao buildingDao) { // (4)
        this.roomDao = roomDao;
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;
        this.buildingDao = buildingDao;

    }
    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());  // (6)
    }
    @GetMapping(path = "/{room_id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null); // (7)
    }

    @PostMapping // (8)
    public RoomDto create(@RequestBody RoomDto dto) {
//        Building building = buildingDao.getOne(dto.getBuilding().getId());
        return new RoomDto(roomDao.save(new Room(dto.getLevel(), dto.getName())));
    }

    @DeleteMapping(path = "/{room_id}")
    public void delete(@PathVariable Long room_id) {
            roomDao.deleteById(room_id);
    }


    @PutMapping(path = "/{room_id}/switchWinndows")
    public RoomDto switchWindowStatus(@PathVariable Long room_id) {
//        long idw = -10;
        Room room = roomDao.findById(room_id).orElseThrow(IllegalArgumentException::new);
        Window window = windowDao.findById(room_id).orElseThrow(IllegalArgumentException::new);
        window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        return new RoomDto(room);
    }
    @PutMapping(path = "/{room_id}/switchHeater")

    public RoomDto switchHeatersStatus(@PathVariable Long room_id) {
//        long ids = -10;

        Room room = roomDao.findById(room_id).orElseThrow(IllegalArgumentException::new);
        Heater heater = heaterDao.findById(room_id).orElseThrow(IllegalArgumentException::new);
        heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        return new RoomDto(room);
    }
}
