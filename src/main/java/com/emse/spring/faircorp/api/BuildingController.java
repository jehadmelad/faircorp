package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.BuildingDto;
import com.emse.spring.faircorp.dto.HeaterDto;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.Building;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/Buildings")
@Transactional
public class BuildingController {

    private final BuildingDao buildingDao;
    private final RoomDao roomDao;
    private final WindowDao windowDao;
    private final HeaterDao heaterDao;

    public BuildingController(BuildingDao buildingDao, RoomDao roomDao, WindowDao windowDao, HeaterDao heaterDao) {
        this.buildingDao = buildingDao;
        this.roomDao = roomDao;
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;
    }

    @GetMapping
    public List<BuildingDto> findAll() {
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());  // (6)
    }
    @GetMapping(path = "/{id}")
    public BuildingDto findById(@PathVariable Long id) {
        return buildingDao.findById(id).map(BuildingDto::new).orElse(null); // (7)
    }

    @PostMapping // (8)
    public BuildingDto create(@RequestBody BuildingDto dto) {
//        // WindowDto must always contain the window room
//        Room room = roomDao.getOne(dto.getRoomId());
//        Window window = null;
//        // On creation id is not defined
//        if (dto.getId() == null) {
//            window = windowDao.save(new Window(room, dto.getName(), dto.getWindowStatus()));
//        }
//        else {
//            window = windowDao.getOne(dto.getId());  // (9)
//            window.setWindowStatus(dto.getWindowStatus());
//        }
//        return new WindowDto(window);

        Building buildingId = new Building();
        Building building =null;
        if (buildingId.getId() == null) {
            building = buildingDao.save(new Building(dto.getId(), dto.getName()));
            return new BuildingDto(building);
        }else {
//            building = buildingDao.getOne(dto.getId());
            building = buildingDao.getOne(dto.getId());
            return new BuildingDto(building);
        }

    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        buildingDao.deleteById(id);
    }
}
