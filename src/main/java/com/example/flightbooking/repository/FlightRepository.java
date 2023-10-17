package com.example.flightbooking.repository;


import com.example.flightbooking.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,String> {

    @Query("select f from Flight f where f.estimatedDepartureTime between :start and :end")
    List<Flight> findFlightsInGivenRange(@Param("start") Timestamp start,@Param("end") Timestamp end);
}
