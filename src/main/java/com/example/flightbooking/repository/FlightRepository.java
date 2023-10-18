package com.example.flightbooking.repository;


import com.example.flightbooking.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,String> {

    @Query("select f from Flight f where f.departureCity= :source and f.arrivalCity= :dest and f.dateOfDeparture between :start and :end")
    Collection<Flight> findFlightsInGivenRange(@Param("start") Date start, @Param("end") Date end,@Param("source") String source,@Param("dest") String dest);
}
