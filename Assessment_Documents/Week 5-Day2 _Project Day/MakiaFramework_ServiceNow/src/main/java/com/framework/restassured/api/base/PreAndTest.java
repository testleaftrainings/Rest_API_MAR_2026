package com.framework.restassured.api.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.framework.config.ConfigurationManager;
import com.framework.data.dynamic.FakerDataFactory;
import com.framework.selenium.api.base.SeleniumBase;
import com.framework.utils.DataLibrary;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PreAndTest extends SeleniumBase {
	public static String id;

	@BeforeMethod
	public void beforeMethod() throws FileNotFoundException, IOException {

		setNode();
		
		RestAssured.baseURI = "https://" + ConfigurationManager.configuration().getBaseURI() + "/"
				+ ConfigurationManager.configuration().getResources() + "/";
		RequestSpecification inputRequest = RestAssured.given().contentType("application/json")
		.when().body("{\n"
				+ "    \"username\": \"FebApiuser\",\n"
				+ "    \"password\": \"Eagle@123\"\n"
				+ "}");
		Response response = inputRequest.post("/users/login");
		id  = response.jsonPath().getString("id");

	}

	@DataProvider(name = "fetchData")
	public Object[][] getData() {
		if (dataFileType.equalsIgnoreCase("Excel"))
			return DataLibrary.getSheet(dataFileName);
		else if (dataFileType.equalsIgnoreCase("JSON")) {
			Object[][] data = new Object[1][1];
			data[0][0] = new File("./data/" + dataFileName + "." + dataFileType);
			System.out.println(data[0][0]);
			return data;
		} else {
			return null;
		}

	}

}
