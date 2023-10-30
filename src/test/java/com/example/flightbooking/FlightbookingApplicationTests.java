package com.example.flightbooking;

import com.example.flightbooking.dto.RegistrationRequest;
import com.example.flightbooking.enums.Role;
import com.example.flightbooking.service.FlightService;
import com.example.flightbooking.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

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

	}
	@Test
	void findFlightsTest(){
	}

	@Test
	void createUserTest() throws Exception {
		RegistrationRequest registrationRequest = new RegistrationRequest("Surya2","BEE","7997591290", Arrays.asList(Role.Passenger));
		userService.addNewUser(registrationRequest);
	}

}
