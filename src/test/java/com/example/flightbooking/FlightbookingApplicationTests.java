package com.example.flightbooking;

import com.example.flightbooking.dto.FlightRequest;
import com.example.flightbooking.dto.RegistrationRequest;
import com.example.flightbooking.enums.Role;
import com.example.flightbooking.model.Passenger;
import com.example.flightbooking.service.FlightService;
import com.example.flightbooking.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
@Slf4j
class FlightbookingApplicationTests {

	@Autowired
	FlightService flightService;
	@Autowired
	UserService userService;

	@Test
	void createFlightTest(){
		FlightRequest flightRequest= new FlightRequest("operating airlines2", "dcity2", "acity2", new Date(), Timestamp.from(Instant.now()), new ArrayList<Passenger>());
		flightService.addNewFlight(flightRequest);
	}
	@Test
	void findFlightsTest(){
		flightService.getFlightsinTimeRange(Timestamp.valueOf("2023-10-05 15:39:26.604292"),Timestamp.valueOf("2023-10-05 21:02:01.045696"));
	}

	@Test
	void createUserTest() throws Exception {
		RegistrationRequest registrationRequest = new RegistrationRequest("Surya2","BEE","7997591290", Arrays.asList(Role.Passenger));
		userService.addNewUser(registrationRequest);
	}

}
