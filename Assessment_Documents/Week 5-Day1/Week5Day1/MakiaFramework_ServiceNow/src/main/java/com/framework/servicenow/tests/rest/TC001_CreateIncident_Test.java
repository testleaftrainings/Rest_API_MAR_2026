package com.framework.servicenow.tests.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class TC001_CreateIncident_Test extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testcaseName = "Create Incident";
		testDescription = "Create Incident using REST API";
		authors = "Shan";
		category = "REST";
		//dataProvider
		dataFileName = "TC001";
	    dataFileType = "JSON";
	}
 
	@Test(dataProvider = "fetchData")
	public void createIncident(File file) throws FileNotFoundException, IOException {
		
		
		Properties prop = new Properties();
		//Load property class
		prop.load(new FileInputStream(new File("./src/main/resources/config_api.properties")));
		String incident = prop.getProperty("path_incident");
		String status = prop.getProperty("statuscode_Post");
		int statusCode = Integer.parseInt(status);
		Response response = postWithBodyAsFileAndUrl(file,incident);
		response.prettyPrint();
		verifyResponseCode(response, statusCode);
		
	}
  
		
		
		
	}























