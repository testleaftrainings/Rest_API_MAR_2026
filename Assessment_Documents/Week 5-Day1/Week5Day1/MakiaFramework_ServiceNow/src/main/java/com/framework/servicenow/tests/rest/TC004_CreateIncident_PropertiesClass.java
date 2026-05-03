package com.framework.servicenow.tests.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.config.ConfigurationManager;
import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.response.Response;

public class TC004_CreateIncident_PropertiesClass extends RESTAssuredBase {
	@BeforeTest
	public void setValues() {
	testcaseName="Create incident with Properties Class";
	testDescription="Create incident with Properties Class using RestAssured";
	authors="Shan";
	category="REST";
	//File Details
	dataFileName="TC001";
	dataFileType="JSON";
	}
	
	@Test(dataProvider="fetchData")
	public void createIncident(File file) throws FileNotFoundException, IOException {
		Properties prop=new Properties();
		prop.load(new FileInputStream(new File("./src/main/resources/config_api.properties")));
		String incident_Path = prop.getProperty("path_incident");
		Response response = postWithBodyAsFileAndUrl(file,incident_Path);
		String statusCode = prop.getProperty("statuscode_Post");
		int responseCode = Integer.parseInt(statusCode);
		
		verifyResponseCode(response,responseCode);
		sys_id = extractResponseContent(response, "result.sys_id");
		
	}

}
