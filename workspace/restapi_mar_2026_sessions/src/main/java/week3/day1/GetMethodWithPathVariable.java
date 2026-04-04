package week3.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetMethodWithPathVariable {
	
	@Test
	public void getAllRecordsFromIncidentTable() {
		RestAssured.given()
		           .auth()
		           .basic("admin", "/eESj0uC3k+O")
		           .pathParam("tableName", "incident")
		           .log().all()
		           .when()
		           .get("https://dev324941.service-now.com/api/now/table/{tableName}")
		           .then()		          
		           .assertThat()
		           .statusCode(200);
	}

}