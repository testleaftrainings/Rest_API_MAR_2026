package com.testleaf.matschie.tests;

import org.testng.annotations.Test;

import com.testleaf.matschie.servicenow.spec.builders.RequestSpecBuilders;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ServicenowSteps {
	
	RequestSpecification spec = RequestSpecBuilders.getRequestSpec();
	
	public void set_base_uri(String baseUri) {
		spec.baseUri(baseUri);
	}
	
	public void set_base_path(String basePath) {
		spec.basePath(basePath);
	}
	
	public void set_auth(String username, String password) {
		spec.auth().basic(username, password);		
	}
	
	@Test
	public void getRecords() {
		set_base_uri("https://dev373619.service-now.com");
		set_base_path("/api/now/table");
		set_auth("admin", "7d3iJH=K$jYf");
		
		RestAssured.given()
		           .spec(spec)		          
		           .when()
		           .get("/incident")
		           .then()
		           .assertThat()
		           .statusCode(200);
	}
	
	@Test
	public void validateGetRecords() {
		new IncidentService()
		      .getRecords()
		      .validateSuccessJsonResponse()
		      .validateResponseTimeSLA(5000L)
		      .validateRecordsSize(84);
	}

}