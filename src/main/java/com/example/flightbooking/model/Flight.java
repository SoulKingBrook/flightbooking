package com.example.flightbooking.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_flight")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
        @Id
        @GeneratedValue(generator = "flightNumberGenerator")
        @GenericGenerator(name = "flightNumberGenerator",strategy = "com.example.flightbooking.customGenerator.FlightNumberGenerator")
        private String flightNumber;
        private String operatingAirlines;
        private String departureCity;
        private String arrivalCity;
        private Date dateOfDeparture;
        private Timestamp estimatedDepartureTime;
        @OneToMany(cascade = CascadeType.ALL)
        private List<Passenger> passengers;
}
