package com.example.flightbooking.mapper;

import com.example.flightbooking.dto.FlightRequest;
import com.example.flightbooking.dto.RegistrationRequest;
import com.example.flightbooking.model.Flight;
import com.example.flightbooking.model.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public FlightRequest toDto(Flight flight){
        return new FlightRequest(
                flight.getOperatingAirlines(),
                flight.getDepartureCity(),
                flight.getArrivalCity(),
                flight.getDateOfDeparture(),
                flight.getEstimatedDepartureTime(),
                flight.getPassengers());
    }
    public Flight toFlight(FlightRequest flightRequest){
        Flight flight = new Flight();
        flight.setArrivalCity(flightRequest.getArrivalCity());
        flight.setOperatingAirlines(flightRequest.getOperatingAirlines());
        flight.setDepartureCity(flightRequest.getDepartureCity());
        flight.setPassengers(flightRequest.getPassengers());
        flight.setDateOfDeparture(flightRequest.getDateOfDeparture());
        flight.setEstimatedDepartureTime(flightRequest.getEstimatedDepartureTime());
        return flight;
    }
    public User toUser(RegistrationRequest registrationRequest){
        return new User(
                registrationRequest.getEmail(),
                registrationRequest.getPassword(),
                registrationRequest.getMobile(),
                registrationRequest.getRoles()
        );
    }

}
