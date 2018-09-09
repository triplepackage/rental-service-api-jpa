package com.rental.web;

import com.rental.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.*;

@RestController
@RequestMapping("/api")
public class  RentalController {
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private TenantRepository tenantRepository;

    @ApiOperation(value = "Get Rental Properties By ID", notes = "Get Rental Properties By ID")
    @RequestMapping(method = RequestMethod.GET, path="/rental/{rentalId}", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Rental.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public Rental rental(@PathVariable int rentalId) {
        return rentalRepository.findByRentalId(rentalId);
    }

    @ApiOperation(value = "Get Rental Properties By Street Name", notes = "Get Rental Properties By Street Name")
    @RequestMapping(method = RequestMethod.GET, path="/rentals/street/{streetName}", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Rental.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public List<Rental> getRentalByStreetName(@PathVariable String streetName) {
        return rentalRepository.findByStreetName(streetName);
    }

    @ApiOperation(value = "Get Rental Properties By City", notes = "Get Rental Properties By City")
    @RequestMapping(method = RequestMethod.GET, path="/rentals/city/{cityName}", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Rental.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public List<Rental> getRentalByCity(@PathVariable String cityName) {
        return rentalRepository.findByCity(cityName);
    }

    @ApiOperation(value = "Create Tenant", notes = "Create Tenant")
    @RequestMapping(method = RequestMethod.POST, path="/tenant/", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Tenant.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public Tenant createTenant(@RequestBody Tenant tenant) {
        return tenantRepository.save(tenant);
    }
}
