package com.rental;

import com.rental.domain.Rental;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest

public class SampleApplicationTests {

	@Test
	public void contextLoads() {
		assertTrue(true);
	}

	@Test
	public void dummyTest()
	{
		Rental rental = new Rental();
		rental.setCity("NOTTINGHAM");

		assertTrue(rental.getCity() == "NOTTINGHAM");
	}
}


