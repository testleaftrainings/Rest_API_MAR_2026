package com.framework.servicenow.tests.rest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.config.ConfigurationManager;
import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class TC002_UpdateIncident extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testcaseName = "Update Incident";
		testDescription = "Update Incident using REST API";
		authors = "Shan";
		category = "REST";
		//dataProvider
		dataFileName = "TC001";
	    dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData",dependsOnMethods ="com.framework.servicenow.tests.rest.TC001_CreateIncident.createIncident" )
	public void updateIncident(File file) {		
		
		Response response = putWithBodyParam(file,ConfigurationManager.configuration().incident_Path()+"/"+sys_id);
		verifyResponseCode(response, ConfigurationManager.configuration().put_statuscode());

	}

		
		
		
	}























