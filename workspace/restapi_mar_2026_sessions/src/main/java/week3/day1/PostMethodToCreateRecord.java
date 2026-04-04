package week3.day1;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;

public class PostMethodToCreateRecord {
	
	RequestSpecification requestSpecification;
	
	@BeforeClass
	public void beforeClass() {
		baseURI = "https://dev324941.service-now.com";
		basePath = "/api/now/table";
		authentication = basic("admin", "/eESj0uC3k+O");		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		requestSpecification = given()		
		                       .pathParam("tableName", "incident")
		                       // Request Body is in JSON format
		                       .contentType(ContentType.JSON)
		                       .log().all();
	}
	
	@Test
	public void createNewIncidentRecordRequestBodyAsString() {
		
		String requestBody = """
				{
                  "short_description": "RESTAPIAPR2026"
                }
				""";
		
		requestSpecification
		.when()
		.body(requestBody)
		.post("/{tableName}")
		.then()
		.log().all()
		.assertThat()
		.statusCode(201)
		.statusLine(Matchers.containsString("Created"))
		// Validate the response format is JSON or NOT
		.contentType(ContentType.JSON)
		.body("result.short_description", Matchers.equalTo("RESTAPIAPR2026"));
	}
	
	@Test
	public void createNewIncidentRecordRequestBodyAsFile() {
		
		File requestBody = new File("src/main/resources/request_payload/create-incident.json");
		
		requestSpecification
		.when()		
		.body(requestBody)
		.post("/{tableName}")
		.then()
		.log().all()
		.assertThat()
		.statusCode(201)
		.statusLine(Matchers.containsString("Created"))
		// Validate the response format is JSON or NOT
		.contentType(ContentType.JSON)
		.body("result.short_description", Matchers.equalTo("RESTAPIAPR2026"))
		.body("result", Matchers.hasKey("sys_id"))
		.body("result.sys_id", Matchers.not(Matchers.emptyOrNullString()));
	}

}