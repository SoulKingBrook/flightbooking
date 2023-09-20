package com.example.flightbooking;

import com.example.flightbooking.dto.FlightRequest;
import com.example.flightbooking.model.Passenger;
import com.example.flightbooking.service.FlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
@Slf4j
class FlightbookingApplicationTests {

	@Autowired
	FlightService flightService;
	@Test
	void contextLoads() {
	}
	@Test
	void createFlightTest(){
		FlightRequest flightRequest= new FlightRequest("operating airlines", "dcity", "acity", new Date(), Timestamp.from(Instant.now()), new ArrayList<Passenger>());
		flightService.addNewFlight(flightRequest);
	}
}
