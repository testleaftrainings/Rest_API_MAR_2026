package week3.day1;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ResponseAssertionInRestAssured {
	
	@Test
	public void validateStatusCode() {
		given()
        .auth()
        .basic("admin", "/eESj0uC3k+O")
        .pathParam("tableName", "incident")
        .log().all()
        .when()
        .get("https://dev324941.service-now.com/api/now/table/{tableName}")
        .then()
        .assertThat()
        .statusCode(200); // Validate the HTTP status code
	}
	
	@Test
	public void validateStatusLine() {
		given()
		.auth()
		.basic("admin", "/eESj0uC3k+O")
		.pathParam("tableName", "incident")
        .log().all()
        .when()
        .get("https://dev324941.service-now.com/api/now/table/{tableName}")
        .then()
        .assertThat()
        .statusLine(Matchers.containsString("OK"));
	}
	
	@Test
	public void validateResponseFormat() {
		given()
		.auth()
		.basic("admin", "/eESj0uC3k+O")
		.pathParam("tableName", "incident")
        .log().all()
        .when()
        .get("https://dev324941.service-now.com/api/now/table/{tableName}")
        .then()
        .assertThat()
        .contentType(ContentType.JSON);
	}
	
	@Test
	public void validateResponseTime() {
		given()
		.auth()
		.basic("admin", "/eESj0uC3k+O")
		.pathParam("tableName", "incident")
        .log().all()
        .when()
        .get("https://dev324941.service-now.com/api/now/table/{tableName}")
        .then()
        .assertThat()
        .time(Matchers.lessThanOrEqualTo(9000L));
	}

}