package com.ucode.demohotelmanagement.controller;

import com.ucode.demohotelmanagement.controller.dto.CheckBooking;
import com.ucode.demohotelmanagement.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class BookingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/booking/list")
    public String listBookings(Model model) {
        LOGGER.info("listBookings");

        model.addAttribute("bookings", bookingService.getBookings());

        return "booking/bookingList";
    }

    @GetMapping("/booking/check")
    public String checkBookingStart(Model model) {

        model.addAttribute("checkBookForm", new CheckBooking());
        model.addAttribute("availableRooms", Collections.emptyList());

        return "booking/checkBooking";
    }

    @PostMapping("/booking/check")
    public String checkBooking(@ModelAttribute("checkBookForm") CheckBooking checkBooking, Model model) {

        List<Integer> emptyRoomsInDateInterval =
                bookingService.getEmptyRoomsInDateInterval(checkBooking.getStart(),
                        checkBooking.getEnd());

        LOGGER.info("the list is: " + emptyRoomsInDateInterval);

        model.addAttribute("availableRooms", emptyRoomsInDateInterval);

        return "booking/checkBooking";
    }

}
