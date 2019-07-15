package com.ucode.demohotelmanagement.service;

import com.ucode.demohotelmanagement.model.Booking;
import com.ucode.demohotelmanagement.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;

@Service
public class BookingService {

    private static List<Booking> bookings = new ArrayList<>();

    @Autowired
    private RoomService roomService;

    @PostConstruct
    public void populateBooking() {
        bookings.addAll(Arrays.asList(
                new Booking(roomService.getRoom(102),
                        LocalDate.of(2019, 7, 5),
                        LocalDate.of(2019, 7, 7)),
                new Booking(roomService.getRoom(12),
                        LocalDate.of(2019, 7, 5),
                        LocalDate.of(2019, 7, 7)),
                new Booking(roomService.getRoom(102),
                        LocalDate.of(2019, 7, 10),
                        LocalDate.of(2019, 7, 15)),
                new Booking(roomService.getRoom(12),
                        LocalDate.of(2019, 7, 9),
                        LocalDate.of(2019, 7, 17))
        ));
    }

    public List<Integer> getEmptyRoomsInDateInterval(LocalDate start, LocalDate end) {

        List<Booking> searchedBookings = new ArrayList<>();

        for (Booking aBooking : bookings) {
            if (!(aBooking.getStart().isAfter(end) || aBooking.getEnd().isBefore(start))) {
                searchedBookings.add(aBooking);
            }
        }

        List<Room> occupiedRooms = new ArrayList<>();

        for (Booking aBooking : searchedBookings) {
            occupiedRooms.add(aBooking.getRoom());
        }

        Collection<Room> allRooms = new ArrayList<>(roomService.getRooms());

        for (Room aRoom : occupiedRooms) {
            allRooms.remove(aRoom);
        }

        List<Integer> availableRoomNumbers = new ArrayList<>();

        for (Room aRoom : allRooms) {
            availableRoomNumbers.add(aRoom.getNumber());
        }
        return availableRoomNumbers;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

}
