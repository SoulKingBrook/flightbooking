package com.example.flightbooking.repository;

import com.example.flightbooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,String> {
    List<Booking> findByEmail(String email);
}
