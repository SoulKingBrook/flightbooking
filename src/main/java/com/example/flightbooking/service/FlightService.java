package com.example.flightbooking.service;

import com.example.flightbooking.dto.FlightDataDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FlightService {
    private final WebClient.Builder webClient;

    public FlightDataDTO getFlightsinTimeRange(Date departureDate,Date arrivalDate,String source,String destination,String seatClass,int noOfAdults, int noOfChildren,int noOfInfants,String trip){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String baseUrl;
        if(trip.equals("roundtrip")){
             baseUrl = "https://api.flightapi.io/"+trip+"/6567a5a87c2715dd88f941aa/"+source+"/"+destination+"/"+dateFormat.format(departureDate)+"/"+dateFormat.format(arrivalDate)+"/"+noOfAdults+"/"+noOfChildren+"/"+noOfInfants+"/"+seatClass+"/USD";
        }
        else{
             baseUrl = "https://api.flightapi.io/"+trip+"/6567a5a87c2715dd88f941aa/"+source+"/"+destination+"/"+dateFormat.format(departureDate)+"/"+noOfAdults+"/"+noOfChildren+"/"+noOfInfants+"/"+seatClass+"/USD";
        }
        FlightDataDTO json = webClient.baseUrl(baseUrl)
                .build()
                .get()
                .retrieve()
                .bodyToMono(FlightDataDTO.class)
                //.onErrorReturn(new FlightDataDTO())
                .block();
        log.info(String.valueOf(json));
        assert json != null;
        if(json.getLegs().size()>20) {
            json.setLegs(json.getLegs().subList(0, 20));
        }
        json.getLegs().stream().forEach(leg -> {
            Optional<Map<String, Object>> trips = json.getTrips().stream().filter(eachTrip -> ((List<String>) eachTrip.get("legIds")).contains(leg.get("id")) ).findFirst();
            Optional<Map<String, Object>> fares = json.getFares().stream().filter(fare -> fare.get("tripId").equals(trips.get().get("id"))).findFirst();
            Optional<Map<String, Object>> airlines = json.getAirlines().stream().filter(airline -> airline.get("code").equals(((List<String>) leg.get("airlineCodes")).get(0))).findFirst();
            leg.put("prices",fares);
            leg.put("airlines",airlines);
        });

        return json;
        //return null;
    }
}
