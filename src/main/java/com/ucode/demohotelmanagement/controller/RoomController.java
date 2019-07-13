package com.ucode.demohotelmanagement.controller;

import com.ucode.demohotelmanagement.model.OccupiedStatus;
import com.ucode.demohotelmanagement.model.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RoomController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoomController.class);

    private static final List<Room> rooms;

    static {
        rooms = new ArrayList<>();

        rooms.add(new Room(102, "king size", "beautiful", OccupiedStatus.FREE, 10));
    }

    @GetMapping("/room/list")
    public String getAllRooms(Model model) {
        LOGGER.info("getAllRooms: return all rooms");

        model.addAttribute("rooms", rooms);

        return "room/roomList";
    }

    @GetMapping("/room/add")
    public String addRoomStart(Model model) {
        LOGGER.info("addRoomStart: ");

        model.addAttribute("roomForm", new Room());
        model.addAttribute("occupiedStatusValues", OccupiedStatus.values());

        return "room/addRoom";
    }

    @PostMapping("/room/add")
    public String addRoomForm(@ModelAttribute("roomForm") Room room) {
        LOGGER.info("addRoomForm: i am adding the room: " + room);

        rooms.add(room);

        return "redirect:/room/list";
    }

    @GetMapping("/room/edit/{id}")
    public String editRoomStart(@PathVariable int id, Model model) {
        LOGGER.info("editRoomStart: " + id);

        model.addAttribute("roomForm", rooms.get(id));
        model.addAttribute("roomId", id);
        model.addAttribute("occupiedStatusValues", OccupiedStatus.values());

        return "room/editRoom";
    }

    @PostMapping("/room/edit/{id}")
    public String editRoomForm(@PathVariable int id, @ModelAttribute("roomForm") Room room) {
        LOGGER.info("editRoomForm: " + room);

        rooms.set(id, room);

        return "redirect:/room/list";
    }

    @GetMapping("/room/delete/{id}")
    public String deleteRoom(@PathVariable int id) {
        LOGGER.info("deleteRoom: " + id);

        rooms.remove(id);

        return "redirect:/room/list";
    }

}
