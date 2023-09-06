package com.example.flightbooking.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="t_flight")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private String flightNumber;
        private String operatingAirlines;
        private String departureCity;
        private String arrivalCity;
        private Date dateOfDeparture;
        private Timestamp estimatedDepartureTime;
        @OneToMany(cascade = CascadeType.ALL)
        private List<Passenger> passengers;
}
