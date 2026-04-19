package com.testleaf.matschie.restful.booker.api.tests;

import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testleaf.matschie.data.utils.CSVHandler;
import com.testleaf.matschie.restful.booker.api.services.BookingService;

public class RestfulBookerE2eTest {
	
	@DataProvider
	public Iterator<Map<String, String>> getTestData() {
		return CSVHandler.getData("restful-booker-data");
	}
	
	@Test(dataProvider = "getTestData")
	public void testCreateNewBooking(Map<String, String> map) {
		new BookingService()
		    .createNewBooking(map.get("firstname"), map.get("lastname"), Integer.parseInt(map.get("totalprice")), Boolean.parseBoolean(map.get("despositpaid")), map.get("checkin"), map.get("checkout"), map.get("addtionalneeds"))
		    .validateBookingGotCreatedSuccessfully()
		    .extractBookingId();
	}

}