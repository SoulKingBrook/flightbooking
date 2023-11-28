package com.example.flightbooking.controller;

import com.example.flightbooking.dto.BookingDTO;
import com.example.flightbooking.dto.DeleteBookingDTO;
import com.example.flightbooking.dto.findBookingsDTO;
import com.example.flightbooking.enums.Role;
import com.example.flightbooking.model.Booking;
import com.example.flightbooking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/app/booking")
public class BookingController {

    private final BookingService bookingService;
    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String addBooking(@RequestBody BookingDTO bookingDTO){
        return bookingService.addBooking(bookingDTO).getBookingID();
    }
    @PostMapping("/my-bookings")
    @ResponseStatus(HttpStatus.OK)
    public List<Booking> findBookingsByEmail(@RequestBody findBookingsDTO dto){
        return bookingService.findAllBookingsByEmail(dto);
    }
    @PostMapping("/my-bookings/{bookingID}")
    public void deleteBooking(@PathVariable String bookingID){
        bookingService.deleteBooking(bookingID);
    }
    @GetMapping("/all-bookings")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Booking> findAllBookings(){
        return bookingService.findAll();
    }
}
