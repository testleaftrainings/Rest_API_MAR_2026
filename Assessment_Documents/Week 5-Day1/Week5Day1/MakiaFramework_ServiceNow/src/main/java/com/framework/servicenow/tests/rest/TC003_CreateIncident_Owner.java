package com.framework.servicenow.tests.rest;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.config.ConfigurationManager;
import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.response.Response;

public class TC003_CreateIncident_Owner extends RESTAssuredBase {
	@BeforeTest
	public void setValues() {
	testcaseName="Create incident with owner";
	testDescription="Create incident with owner using RestAssured";
	authors="Shan";
	category="REST";
	//File Details
	dataFileName="TC001";
	dataFileType="JSON";
	}
	
	@Test(dataProvider="fetchData")
	public void createIncident(File file) {
		Response response = postWithBodyAsFileAndUrl(file, ConfigurationManager.configuration().incident_Path());
		//response.prettyPrint();
		verifyResponseCode(response,ConfigurationManager.configuration().post_statuscode());
		sys_id = extractResponseContent(response, "result.sys_id");
		
	}

}
