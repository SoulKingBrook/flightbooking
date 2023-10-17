package com.example.flightbooking.service;

import com.example.flightbooking.dto.FlightRequest;
import com.example.flightbooking.mapper.Mapper;
import com.example.flightbooking.model.Flight;
import com.example.flightbooking.repository.FlightRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FlightService {
    private final FlightRepository flightRepository;
    private final Mapper mapper;

    public void addNewFlight(@RequestBody FlightRequest flightRequest){

        Flight flight = mapper.toFlight(flightRequest);
        flightRepository.save(flight);
    }
    public void getFlightsinTimeRange(Timestamp rangeStart, Timestamp rangeEnd){

        flightRepository.findFlightsInGivenRange(rangeStart,rangeEnd).stream().map(model-> model.getFlightNumber()).forEach(log::info);
    }
}
