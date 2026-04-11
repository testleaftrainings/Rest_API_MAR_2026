package week3.day1;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class MyFirstRestAssuredScript {
	
	@Test
	public void getAllRecrodsFromIncidentTable() {
		// Sending GET Request what are the pre-condition needed, we can give under the given() method
		RestAssured.given()
		           .auth()
		           .basic("admin", "7d3iJH=K$jYf")
		           // when() method is used to send various HTTP methods like, (GET, POST, PUT, DELETE etc.)
		           .when()
		           .get("https://dev373619.service-now.com/api/now/table/incident")
		           // then() method is used to validate or extract values from the response
		           .then()
		           .assertThat()
		           .statusCode(200)
		           .statusLine(Matchers.equalTo("OK"));
		
	}	
	
	@Test
	public void getAllRecrodsFromIncidentTableWithLog() {
		RestAssured.given()
		           .auth()
		           .basic("admin", "/eESj0uC3k+O")
		           // Request Log
		           .log().all()
		           .when()
		           .get("https://dev324941.service-now.com/api/now/table/incident")
		           .then()
		           // Response Log
		           .log().all()
		           .assertThat()
		           .statusCode(200);
	}

}