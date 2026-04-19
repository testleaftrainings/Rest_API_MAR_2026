package com.testleaf.matschie.restful.booker.api.services;

import com.testleaf.matschie.general.utils.TestUtlis;
import com.testleaf.matschie.rest.assured.api.client.RestAssuredApiClient;
import com.testleaf.matschie.restful.booker.serialization.pojos.BookingDates;
import com.testleaf.matschie.restful.booker.serialization.pojos.CreateBooking;
import com.testleaf.matschie.restful.booker.spec.builders.RequestSpecBuilders;
import com.testleaf.matschie.restful.booker.spec.builders.ResponseSpecBuilders;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BookingService extends RestAssuredApiClient {
	
	public BookingService createNewBooking(String firstName, String lastname, int totalprice, boolean isDepositpaid, String checkin, String checkout, String additonalneeds) {
		
		CreateBooking createBooking = new CreateBooking();
		BookingDates bookingDates = new BookingDates();
		bookingDates.setCheckin(checkin);
		bookingDates.setCheckout(checkout);
		
		createBooking.setFirstname(firstName);
		createBooking.setLastname(lastname);
		createBooking.setTotalprice(totalprice);
		createBooking.setDepositpaid(isDepositpaid);
		createBooking.setBookingdates(bookingDates);
		createBooking.setAdditionalneeds(additonalneeds);
		
		
		Response post = post(RequestSpecBuilders.getBookerRequestSpec()
				                .contentType(ContentType.JSON)
				                , "", createBooking);
		TestUtlis.setResponse(post);
		return this;
	}
	
	public BookingService validateBookingGotCreatedSuccessfully() {
		TestUtlis.getResponse()
		         .then()
		         .spec(ResponseSpecBuilders.successJsonResponse());
		return this;
	}
	
	public BookingService extractBookingId() {
		String id = TestUtlis.getResponse()
		         .then()
		         .extract()
		         .jsonPath()
		         .getString("bookingid");
		TestUtlis.setTestData("bookingId", id);
		return this;
	}

}
