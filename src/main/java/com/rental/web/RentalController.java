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


    @ApiOperation(value = "rental", nickname = "rental")
    @RequestMapping(method = RequestMethod.GET, path="/rental/{rentalId}", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Rental.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public Rental rental(@PathVariable int rentalId) {
        return rentalRepository.findByRentalId(rentalId);
    }

}
