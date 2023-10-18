package com.example.flightbooking.controller;

import com.example.flightbooking.dto.LoginRequest;
import com.example.flightbooking.dto.RegistrationRequest;
import com.example.flightbooking.dto.UserResponse;
import com.example.flightbooking.enums.Role;
import com.example.flightbooking.exceptions.InvalidCredentialsException;
import com.example.flightbooking.service.UserService;
import com.example.flightbooking.utils.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/auth")
public class UserController {

    private final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @PostMapping("/generate")
    public String login(@RequestBody LoginRequest loginRequest) throws InvalidCredentialsException {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        if(authenticate.isAuthenticated()) {
            return jwtUtil.generateToken(loginRequest.getEmail());
        }
        else{
            throw new InvalidCredentialsException("invalid username or password");
        }
    }
    @PostMapping("/register")
    public UserResponse registerUser(@RequestBody RegistrationRequest registrationRequest) throws Exception {
        UserResponse userResponse = new UserResponse();
        try {
            registrationRequest.setRoles(Arrays.asList(Role.Passenger));
            userService.addNewUser(registrationRequest);
            userResponse.setSuccessMsg("added user successfully");
        }
        catch (Exception e){
            userResponse.setErrorMsg(e.getMessage());
        }
        return userResponse;
    }
}
