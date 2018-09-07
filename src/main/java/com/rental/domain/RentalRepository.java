package com.rental.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Rental Repository
 */
public interface RentalRepository extends CrudRepository<Rental, Long> {

    List<Rental> findByStreetName(String streetName);

    List<Rental> findByCity(String cityName);

    Rental findByRentalId(int rentalId);

}