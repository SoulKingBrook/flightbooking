package com.example.flightbooking.service;

import com.example.flightbooking.dto.LoginRequest;
import com.example.flightbooking.dto.RegistrationRequest;
import com.example.flightbooking.enums.Role;
import com.example.flightbooking.mapper.Mapper;
import com.example.flightbooking.model.User;
import com.example.flightbooking.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final Mapper mapper;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public void addNewUser(@RequestBody RegistrationRequest registrationRequest) throws Exception {
        User user = mapper.toUser(registrationRequest);
        Optional<User> user1 = userRepository.findById(user.getEmail());
        if(user1.isEmpty()){
            user.setRoles(List.of(Role.Passenger));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
        else{
            throw new Exception("User already exists");
        }

    }
    public boolean authenticateUser(@RequestBody LoginRequest loginRequest) throws Exception{
        Optional<User> user = userRepository.findById(loginRequest.getEmail());
        if(user.isEmpty()){
            throw new Exception("enter a valid username");
        }
        User userDetails=user.get();
        return userDetails.getPassword().equals(loginRequest.getPassword());
    }
}
