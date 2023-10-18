package com.example.flightbooking.controller;

import com.example.flightbooking.dto.FlightTimeRangeDTO;
import com.example.flightbooking.model.Flight;
import com.example.flightbooking.repository.FlightRepository;
import com.example.flightbooking.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/app/booking")

public class FlightController {

    private final FlightService flightService;

    @PostMapping("/flights")
    @ResponseStatus(HttpStatus.OK)
    public List<Flight> getFlights(@RequestBody FlightTimeRangeDTO flightTimeRangeDTO) {

        List<Flight> flights = flightService.getFlightsinTimeRange(flightTimeRangeDTO.getRangeStart(),flightTimeRangeDTO.getRangeEnd(),flightTimeRangeDTO.getSource(),flightTimeRangeDTO.getDestination());
        return flights;
    }
}
