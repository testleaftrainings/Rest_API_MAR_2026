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


public class TC001_CreateAccount extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testcaseName = "UiBank Account Creation";
		testDescription = "Create Account using REST API";
		authors = "Shan";
		category = "REST";
		//dataProvider
		dataFileName = "TC001";
	    dataFileType = "JSON";
	}
 
	@Test(dataProvider = "fetchData")
	public void createAccount(File file) throws FileNotFoundException, IOException {
		
		
		Response response = postWithAuthHeaders(id, file, "accounts");
		verifyResponseCode(response, 200);
	}
  
		
		
		
	}























