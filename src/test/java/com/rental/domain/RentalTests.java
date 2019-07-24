package com.rental.domain;

import com.utilities.DateUtilities;
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

    @Test
    public void isUTCFormatTest()
    {
        assertTrue(DateUtilities.isUTCFormat("2014-04-28T00:00:00.000"));
    }
}
