package com.example.flightbooking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String BookingID;
    private String email;
    private String flightId;

    public Booking(String email, String flightId) {
        setEmail(email);
        setFlightId(flightId);
    }
}
