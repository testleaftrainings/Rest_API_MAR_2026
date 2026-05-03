package com.servicenow.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.restassured.api.base.RESTAssuredBase;
import com.framework.selenium.servicenow.pages.Loginpage;
import com.framework.testng.api.base.BaseMethods;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class TC_002UpdateIncident extends BaseMethods{
	@BeforeTest
	public void setfileName() {
		excelFileName="CreateIncident";
		testcaseName="UpdateIncident";
		testDescription ="Test data with mandatory Field";
		authors="Hari";
		category="Regression";
	
	}
	
	@Test//(dataProvider = "fetchData")
	public void runUpdateIncident() throws IOException, InterruptedException {
		// Post the request
		Response response = RESTAssuredBase.post("incident",ContentType.JSON);
		RESTAssuredBase.verifyResponseCode(response, 201);
		JsonPath jsonPath = response.jsonPath();
		String incident_number = jsonPath.get("result.number"); 
		System.out.println(incident_number);
		
		new Loginpage()
		.enterCredentials()
		.clickAll()
		.clickIncident()
		.searchIncident(incident_number)
		.updateUrgency()
		.updateState()
		.enterCaller()
		.enterShortDescription()
		.clickUpdateButton()
		.verifyIncidentNumber();
		
		}
	

}
