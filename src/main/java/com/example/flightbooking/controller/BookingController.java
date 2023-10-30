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
    public void addBooking(@RequestBody BookingDTO bookingDTO){
        bookingService.addBooking(bookingDTO);
    }
    @PostMapping("/my-bookings")
    @ResponseStatus(HttpStatus.OK)
    public List<Booking> findBookingsByEmail(@RequestBody findBookingsDTO dto){
        return bookingService.findAllBookingsByEmail(dto);
    }
    @DeleteMapping("/my-bookings")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBooking(@RequestBody DeleteBookingDTO dto){
        bookingService.deleteBooking(dto.getBookingID());
    }
    @GetMapping("/all-bookings")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Booking> findAllBookings(){
        return bookingService.findAll();
    }
}
