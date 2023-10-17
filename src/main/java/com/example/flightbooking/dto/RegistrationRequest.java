package com.example.flightbooking.dto;

import com.example.flightbooking.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    String email;
    String password;
    String mobile;
    List<Role> roles;
}
