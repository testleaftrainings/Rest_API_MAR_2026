package com.testleaf.matschie.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testleaf.matschie.general.utils.TestUtlis;
import com.testleaf.matschie.servicenow.spec.builders.RequestSpecBuilders;
import com.testleaf.matschie.servicenow.spec.builders.ResponseSpecBuilders;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestE2E {
	
	RequestSpecification requestSpecification;
	
	@BeforeClass
	public void beforeClass() {
		requestSpecification = RestAssured.given()
		           .spec(RequestSpecBuilders.getTableApiRequestSpec("incident"));
	}
	
	@Test
	public void create() {
		Response response = requestSpecification
		           .contentType(ContentType.JSON)		      
		           .when()
		           .post("/{tableName}")
		           .then()
		           .spec(ResponseSpecBuilders.successCreateResponse())
		           .extract()
		           .response();
		
		TestUtlis.setTestData("sysId", response.jsonPath().getString("result.sys_id"));
	}
	
	@Test
	public void get() {
		requestSpecification
        .pathParam("sys_id", TestUtlis.getTestData("sysId"))
        .when()
        .get("/{tableName}/{sys_id}")
        .then()
        .spec(ResponseSpecBuilders.successJsonResponse())
        .body("result.sys_id", Matchers.equalTo(TestUtlis.getTestData("sysId")));        
	}

}