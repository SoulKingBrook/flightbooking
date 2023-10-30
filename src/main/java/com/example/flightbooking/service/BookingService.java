package com.example.flightbooking.service;

import com.example.flightbooking.dto.BookingDTO;
import com.example.flightbooking.dto.findBookingsDTO;
import com.example.flightbooking.mapper.Mapper;
import com.example.flightbooking.model.Booking;
import com.example.flightbooking.repository.BookingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BookingService {
    private final BookingRepository bookingRepository;
    private final Mapper mapper;
    public List<Booking> findAllBookingsByEmail(findBookingsDTO dto){
        return bookingRepository.findByEmail(dto.getEmail());
    }
    public void addBooking(BookingDTO bookingDTO){
        Booking booking = mapper.toBooking(bookingDTO);
        bookingRepository.save(booking);
    }
    public void deleteBooking(String bookingID){
        bookingRepository.deleteById(bookingID);
    }
    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }
}
