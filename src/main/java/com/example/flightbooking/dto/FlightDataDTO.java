package com.example.flightbooking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FlightDataDTO {
    @JsonProperty("legs")
    private List<Map<String,Object>> legs;
    @JsonProperty("trips")
    private List<Map<String,Object>> trips;
    @JsonProperty("fares")
    private List<Map<String,Object>> fares;
    @JsonProperty("airlines")
    private List<Map<String,Object>> airlines;
}
