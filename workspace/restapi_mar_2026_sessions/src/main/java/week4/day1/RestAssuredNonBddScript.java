package week4.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredNonBddScript {
	
	/*
	 * BDD Approach
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
    .statusLine(Matchers.equalTo("OK"));*/
	
	@Test
	public void getAllRecords() {
		RequestSpecification request = RestAssured.given()
				                                  .filter(new RequestLoggingFilter())
				                                  .filter(new ResponseLoggingFilter());
		
		request.baseUri("https://dev373619.service-now.com/");
		request.basePath("/api/now/table");
		request.auth().basic("admin", "7d3iJH=K$jYf");
		
		Response response = request.get("/incident");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
