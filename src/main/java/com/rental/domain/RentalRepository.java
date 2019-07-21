package com.rental.domain;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Rental Repository
 */
public interface RentalRepository extends CrudRepository<Rental, Long> {

    List<Rental> findByStreetName(String streetName);

    List<Rental> findByCity(String cityName);

    Rental findByRentalId(int rentalId);

    Rental save(Rental rental);

    @Query("SELECT new com.rental.domain.RentalByStat(upper(r.city), COUNT(r)) from Rental r GROUP BY upper(r.city)")
    ArrayList<RentalByStat> findRentalsByCity();

    @Query("SELECT new com.rental.domain.RentalByStat(upper(r.recordStatus), COUNT(r)) from Rental r GROUP BY upper(r.recordStatus)")
    ArrayList<RentalByStat> getRentalsByRecordStatus();

    @Query("SELECT new com.rental.domain.RentalByStat(upper(r.expirationDate), COUNT(r)) from Rental r GROUP BY upper(r.expirationDate)")
    ArrayList<RentalByStat> getRentalsByExpirationDate();
}