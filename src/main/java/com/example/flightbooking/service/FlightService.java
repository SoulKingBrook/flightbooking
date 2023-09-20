package com.example.flightbooking.service;

import com.example.flightbooking.dto.FlightRequest;
import com.example.flightbooking.mapper.Mapper;
import com.example.flightbooking.model.Flight;
import com.example.flightbooking.repository.FlightRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class FlightService {
    private final FlightRepository flightRepository;
    private final Mapper mapper;

    public void addNewFlight(FlightRequest flightRequest){

        Flight flight = mapper.toFlight(flightRequest);
        flightRepository.save(flight);
    }
}
