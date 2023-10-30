package com.example.flightbooking.controller;

import com.example.flightbooking.dto.FlightDataDTO;
import com.example.flightbooking.dto.FlightsRequestDTO;
import com.example.flightbooking.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/app")

public class FlightController {

    private final FlightService flightService;

    @PostMapping("/flights")
    @ResponseStatus(HttpStatus.OK)
    public FlightDataDTO getFlights(@RequestBody FlightsRequestDTO flightsRequestDTO) {

        FlightDataDTO flights = flightService.getFlightsinTimeRange(flightsRequestDTO.getDepartureDate(),flightsRequestDTO.getSource(), flightsRequestDTO.getDestination(), flightsRequestDTO.getBookingClass(), flightsRequestDTO.getNoOfAdults(), flightsRequestDTO.getNoOfChildren(), flightsRequestDTO.getNoOfInfants(), flightsRequestDTO.getTrip());
        return flights;
    }
}
