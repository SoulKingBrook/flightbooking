package com.example.flightbooking.mapper;

import com.example.flightbooking.dto.BookingDTO;
import com.example.flightbooking.dto.RegistrationRequest;
import com.example.flightbooking.model.Booking;
import com.example.flightbooking.model.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public User toUser(RegistrationRequest registrationRequest){
        return new User(
                registrationRequest.getEmail(),
                registrationRequest.getPassword(),
                registrationRequest.getMobile(),
                registrationRequest.getRoles()
        );
    }
    public Booking toBooking(BookingDTO bookingDTO){
        return new Booking(bookingDTO.getEmail(),bookingDTO.getFlightId());
    }

}
