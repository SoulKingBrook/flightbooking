package com.example.flightbooking.mapper;

import com.example.flightbooking.dto.FlightRequest;
import com.example.flightbooking.model.Flight;
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
        flight.setOperatingAirlines(flight.getOperatingAirlines());
        flight.setDepartureCity(flightRequest.getDepartureCity());
        flight.setPassengers(flightRequest.getPassengers());
        flight.setDateOfDeparture(flightRequest.getDateOfDeparture());
        flight.setEstimatedDepartureTime(flightRequest.getEstimatedDepartureTime());
        return flight;
    }
}
