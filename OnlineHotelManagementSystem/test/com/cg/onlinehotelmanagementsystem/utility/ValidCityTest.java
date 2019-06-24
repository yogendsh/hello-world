package com.cg.onlinehotelmanagementsystem.utility;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cg.onlinehotelmanagementsystem.exception.AreaNameException;
import com.cg.onlinehotelmanagementsystem.exception.CityNameException;

class ValidCityTest {

	@Test
	void testValidAreaFail() throws AreaNameException {
		ValidCity validcity = new ValidCity();
		Assertions.assertThrows(AreaNameException.class, () -> {
			validcity.validAreaName("pune", 1);
		});
	}

	@Test
	void testValidAreaPass() throws AreaNameException {
		ValidCity validcity = new ValidCity();

		int testvar = validcity.validAreaName("baner", 1);
		assertEquals(4, testvar);

	}
	@Test
	void testValidCityFail() throws CityNameException {
		ValidCity validcity = new ValidCity();
		Assertions.assertThrows(CityNameException.class, () -> {
			validcity.validCityName("banglore");
		});
	}
	@Test
	void testValidCityPass() throws CityNameException {
		ValidCity validcity = new ValidCity();
		int testvar = validcity.validCityName("jaipur");
		assertEquals(2, testvar);
		}
	}


