package com.rental.web;

import com.utilities.*;
import com.rental.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class  RentalController {
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private TenantRepository tenantRepository;

    @ApiOperation(value = "Get Rental Properties By ID", notes = "Get Rental Properties By ID")
    @GetMapping(path="/rental/{rentalId}", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Rental.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public Rental getRentalById(@PathVariable int rentalId) {

        Rental rental = rentalRepository.findByRentalId(rentalId);
        return rental;
    }

    @ApiOperation(value = "Get Rental Properties By Street Name", notes = "Get Rental Properties By Street Name")
    @GetMapping(path="/rentals/street/{streetName}", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Rental.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public List<Rental> getRentalByStreetName(@PathVariable String streetName) {
        return rentalRepository.findByStreetName(streetName);
    }

    @ApiOperation(value = "Get Rental Properties By City", notes = "Get Rental Properties By City")
    @GetMapping(path="/rentals/city/{cityName}", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Rental.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public List<Rental> getRentalByCity(@PathVariable String cityName) {
        return rentalRepository.findByCity(cityName);
    }

    @ApiOperation(value = "Get Rental Count By City", notes = "Get Rental Count By City")
    @GetMapping(path="/rentals/groupedby/city", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = RentalByStat.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public List<RentalByStat> getRentalsGroupedByCity() {
        return rentalRepository.findRentalsByCity();
    }

    @ApiOperation(value = "Get Rental Count By Record Status", notes = "Get Rental Count By Record Status")
    @GetMapping(path="/rentals/groupedby/recordStatus", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = RentalByStat.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public List<RentalByStat> getRentalsGroupedByRecordStatus() {
        return rentalRepository.getRentalsByRecordStatus();
    }

    @ApiOperation(value = "Get Rentals By Expiration Date", notes = "Get Rentals by Expiration Date")
    @GetMapping(path="/rentals/groupedby/expirationdate", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = RentalByStat.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public List<RentalByStat> getRentalsGroupedByExpirationDate() {
        List<RentalByStat> expirationDates = new ArrayList<>();

        for (RentalByStat rentalDate : rentalRepository.getRentalsByExpirationDate()) {
            expirationDates.add(new RentalByStat(DateUtilities.fixUTCDateToString(rentalDate.getStat()), rentalDate.getCount()));
        }
                
        return expirationDates;
    }

    @ApiOperation(value = "Create Tenant", notes = "Create Tenant")
    @PostMapping(path="/tenant/", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Tenant.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public Tenant createTenant(@Valid @RequestBody Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    @ApiOperation(value = "Update Rental", notes = "Update Rental")
    @PostMapping(path="/rental/", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Rental.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public Rental updateRental(@Valid @RequestBody Rental rental) {
        return rentalRepository.save(rental);
    }
}
