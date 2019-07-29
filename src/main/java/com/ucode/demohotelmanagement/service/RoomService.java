package com.ucode.demohotelmanagement.service;

import com.ucode.demohotelmanagement.model.OccupiedStatus;
import com.ucode.demohotelmanagement.model.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class RoomService {

    private static Logger LOGGER = LoggerFactory.getLogger(RoomService.class);

    private static final Map<Integer, Room> rooms;

    static {
        rooms = new HashMap<>();

        rooms.put(102, new Room(102, "king size", "beautiful", OccupiedStatus.FREE, 10));
        rooms.put(12, new Room(12, "queen size", "ordinary", OccupiedStatus.FREE, 10));
    }


    public Collection<Room> getRooms() {
        LOGGER.info("getRooms");

        return rooms.values();
    }

    public void addRoom(Room room) {
        LOGGER.info("addRoom");

        doAddRoom(room);
    }

    public Room getRoom(int id) {
        LOGGER.info("getRoom");

        return rooms.get(id);
    }

    public void updateRoom(int id, Room room) {
        LOGGER.info("updateRoom");

        if(rooms.containsKey(id)) {
            rooms.remove(id);
            doAddRoom(room);
        } else {
            throw new IllegalArgumentException("nu exista camera respectiva");
        }
    }

    private void doAddRoom(Room room) {
        rooms.put(room.getNumber(), room);
    }

    public void removeRoom(int id) {
        LOGGER.info("removeRoom");

        rooms.remove(id);
    }

}
