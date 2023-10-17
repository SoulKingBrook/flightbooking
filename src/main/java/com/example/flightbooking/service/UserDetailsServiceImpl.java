package com.example.flightbooking.service;

import com.example.flightbooking.dto.UserDetailsDto;
import com.example.flightbooking.model.User;
import com.example.flightbooking.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional= userRepository.findById(username);
        User data = userOptional.get();
        data.getRoles().forEach(role->log.info(role.name()));
        return userOptional.map(UserDetailsDto::new).orElseThrow(()->new UsernameNotFoundException("user not found"+username));
    }
}
