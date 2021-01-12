package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.BuildingDto;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/windows")
@Transactional
public class WindowController {

    private final BuildingDao buildingDao;
    private final RoomDao roomDao;
    private final WindowDao windowDao;
    private final HeaterDao heaterDao;

    public WindowController(BuildingDao buildingDao, RoomDao roomDao, WindowDao windowDao, HeaterDao heaterDao) {
        this.buildingDao = buildingDao;
        this.roomDao = roomDao;
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;
    }
    @GetMapping // (5)
    public List<WindowDto> findAll() {
        return windowDao.findAll().stream().map(WindowDto::new).collect(Collectors.toList());  // (6)
    }

    @GetMapping(path = "/{id}")
    public WindowDto findById(@PathVariable Long id) {
        return windowDao.findById(id).map(WindowDto::new).orElse(null); // (7)
    }

    @PutMapping(path = "/{id}/switch")
    public WindowDto switchStatus(@PathVariable Long id) {
        Window window = windowDao.findById(id).orElseThrow(IllegalArgumentException::new);
        window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        return new WindowDto(window);
    }

//    @PostMapping // (8)
//    public void create(@RequestBody Window dto) {
//        windowDao.save(dto);
//    }

    @PostMapping // (8)
    public WindowDto create(@RequestBody WindowDto dto) {
        Room room = roomDao.getOne(dto.getRoom().getId());
        Window window = null;
        return new WindowDto(windowDao.save(new Window( dto.getName(), dto.getStatus(),room)));

// ##################################################################################################
//        // WindowDto must always contain the window room
//        Room room = roomDao.getOne(dto.getRoom().getId());
//        Window window = null;
//        // On creation id is not defined
//        if (dto.getId() == null) {
//            window = windowDao.save(new Window( dto.getName(), dto.getWindowStatus(),room));
//        }
//        else {
//            window = windowDao.getOne(dto.getId());  // (9)
//            window.setWindowStatus(dto.getWindowStatus());
//        }
//        return new WindowDto(window);
//#####################################################################################################
    }
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        windowDao.deleteById(id);
    }
}