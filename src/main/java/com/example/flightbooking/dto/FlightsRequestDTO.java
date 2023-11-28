package com.example.flightbooking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class FlightsRequestDTO {
    String source;
    String destination;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date departureDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date arrivalDate;
    private String bookingClass;
    private String trip;
    private int noOfAdults;
    private int noOfChildren;
    private int noOfInfants;

}
