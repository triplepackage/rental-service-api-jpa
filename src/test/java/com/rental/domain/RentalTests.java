package com.rental.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RentalTests {

    private Rental _rental = null;

    @Before
    public void Setup(){
        _rental = new Rental();
        _rental.setCity("nottingham");
    }

    @Test
    public void RentalTest() {
        assertTrue(_rental != null);
    }

    @Test
    public void RentalCityTest() {
        assertTrue(_rental.getCity() == "nottingham");
    }
}
