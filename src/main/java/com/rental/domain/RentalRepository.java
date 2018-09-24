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

    @Query("SELECT new com.rental.domain.RentalByStat(r.city, COUNT(r)) from Rental r GROUP BY r.city")
    ArrayList<RentalByStat> findRentalsByCity();

}