package week3.day2;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.specification.RequestSpecification;
import pojos.IncidentResponse;
import pojos.UpdateIncidet;

import static io.restassured.RestAssured.*;

public class IncidentTableE2eTest {
	
	RequestSpecification requestSpecification;
	String sysId;
	
	@BeforeClass
	public void beforeClass() {
		baseURI = "https://dev373619.service-now.com";
		basePath = "/api/now/table";
		authentication = basic("admin", "7d3iJH=K$jYf");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		requestSpecification = given()
				                .pathParam("tableName", "incident")
				                .filter(new RequestLoggingFilter())
				                .filter(new ResponseLoggingFilter())
				                .filter(new AllureRestAssured());
	}
	
	@Test(priority = 1)
	public void createRecord() {
		IncidentResponse response = requestSpecification.contentType(ContentType.JSON)
		                    .when()
		                    .post("/{tableName}")
		                    .then()
		                    .assertThat()
		                    .statusCode(201)
		                    .statusLine(Matchers.containsString("Created"))
		                    .contentType(ContentType.JSON)
		                    .body("result", Matchers.hasKey("sys_id"))
		                    .body("result.sys_id", Matchers.not(Matchers.emptyOrNullString()))
		                    .extract()
		                    .as(IncidentResponse.class, ObjectMapperType.GSON);
		sysId = response.getResult().getSysId();
	}
	
	@Test(priority = 2)
	public void getExistingRecord() {
		requestSpecification.pathParam("sys_id", sysId)
		                    .when()
		                    .get("/{tableName}/{sys_id}")
		                    .then()
		                    .assertThat()
		                    .statusCode(200)
		                    .statusLine(Matchers.containsString("OK"))
		                    .contentType(ContentType.JSON)
		                    .body("result.sys_id", Matchers.equalTo(sysId));
	}
	
	@Test(priority = 3)
	public void updateExistingRecord() {
		
		UpdateIncidet updateIncidet = new UpdateIncidet();
		updateIncidet.setShort_description("RESTAPIMAR2026");
		updateIncidet.setDescription("Update the description key value using PUT method");
		updateIncidet.setCategory("Software");
		
		requestSpecification.contentType(ContentType.JSON)
		                    .pathParam("sys_id", sysId)
		                    .when()
		                    .body(updateIncidet)
		                    .put("/{tableName}/{sys_id}")
		                    .then()
		                    .assertThat()
		                    .statusCode(200)
		                    .statusLine(Matchers.containsString("OK"))
		                    .contentType(ContentType.JSON)
		                    .body("result.short_description", Matchers.equalTo(updateIncidet.getShort_description()))
		                    .body("result.description", Matchers.equalTo(updateIncidet.getDescription()))
		                    .body("result.category", Matchers.equalToIgnoringCase(updateIncidet.getCategory()));
	}
	
	@Test(priority = 4)
	public void deleteExistingRecord() {
		requestSpecification.pathParam("sys_id", sysId)
		                    .when()
		                    .delete("/{tableName}/{sys_id}")
		                    .then()
		                    .assertThat()
		                    .statusCode(204)
		                    .statusLine(Matchers.containsString("No Content"));
	}
		
	@Test(priority = 5)
	public void validateRecordGotDeletedSuccessfully() {
		requestSpecification.pathParam("sys_id", sysId)
		                    .when()
		                    .get("/{tableName}/{sys_id}")
		                    .then()
		                    .assertThat()
		                    .statusCode(404)
		                    .statusLine(Matchers.containsString("Not Found"))
		                    .contentType(ContentType.JSON);
	}

}