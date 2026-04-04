package week3.day1;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.List;

public class GetMethodWithQueryParam {
	
	@Test
	public void getAllRecordsAndFilterTheResponse() {
		given()
		.auth()
		.basic("admin", "/eESj0uC3k+O")
		.pathParam("table_name", "incident")
		.queryParam("sysparm_limit", "3")
		.log().all()
		.when()
		.get("https://dev324941.service-now.com/api/now/table/{table_name}")
		.then()
		.assertThat()
		.statusCode(200)
		.statusLine(Matchers.containsString("OK"))
		.contentType(ContentType.JSON)
		.time(Matchers.lessThanOrEqualTo(9000L))
		.body("result", Matchers.hasSize(3));
	}
	
	@Test
	public void getAllRecordsOfTheHardwareCategoryWay1() {
		List<String> categories = given()
		.auth()
		.basic("admin", "/eESj0uC3k+O")
		.pathParam("table_name", "incident")
		.queryParam("category", "hardware")
		.log().all()
		.when()
		.get("https://dev324941.service-now.com/api/now/table/{table_name}")
		.then()
		.assertThat()
		.statusCode(200)
		.statusLine(Matchers.containsString("OK"))
		.contentType(ContentType.JSON)
		.time(Matchers.lessThanOrEqualTo(9000L))
		.extract()
		.jsonPath()
		.getList("result.category");
		
		for (String category : categories) {
			assertEquals(category.toLowerCase(), "hardware");
		}
		
	}
	
	@Test
	public void getAllRecordsOfTheHardwareCategoryWay2() {
		given()
		.auth()
		.basic("admin", "/eESj0uC3k+O")
		.pathParam("table_name", "incident")
		.queryParam("category", "hardware")
		.log().all()
		.when()
		.get("https://dev324941.service-now.com/api/now/table/{table_name}")
		.then()
		.assertThat()
		.statusCode(200)
		.statusLine(Matchers.containsString("OK"))
		.contentType(ContentType.JSON)
		.time(Matchers.lessThanOrEqualTo(9000L))
		.body("result.category", Matchers.everyItem(Matchers.equalToIgnoringCase("hardware")));		
	}

}