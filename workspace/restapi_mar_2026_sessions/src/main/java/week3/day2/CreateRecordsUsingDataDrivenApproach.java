package week3.day2;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojos.CreateIncident;

public class CreateRecordsUsingDataDrivenApproach {
	
	RequestSpecification requestSpecification;
	
	@DataProvider
	public String[][] getDatas() {		
	
		return new String[][] {
			{"RESTAPIJAN2026"},
			{"RESTAPIFEB2026"},
			{"RESTAPIMAR2026"},
			{"RESTAPIAPR2026"},
			{"RESTAPIMAY2026"}
		};
	}
	
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
	
	@Test(dataProvider = "getDatas")
	public void createRecords(String shortDescription) {
		
		CreateIncident createIncident = new CreateIncident();
		createIncident.setShort_description(shortDescription);
		
		requestSpecification
		.when()		
		.body(createIncident)
		.post("/{tableName}")
		.then()
		.log().all()
		.assertThat()
		.statusCode(201)
		.statusLine(Matchers.containsString("Created"))
		// Validate the response format is JSON or NOT
		.contentType(ContentType.JSON)
		.body("result.short_description", Matchers.equalTo(createIncident.getShort_description()))
		.body("result", Matchers.hasKey("sys_id"))
		.body("result.sys_id", Matchers.not(Matchers.emptyOrNullString()));
		
	}

}