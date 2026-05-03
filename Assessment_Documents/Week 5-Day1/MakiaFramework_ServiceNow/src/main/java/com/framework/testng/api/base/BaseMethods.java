package com.framework.testng.api.base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.framework.config.ConfigurationManager;
import com.framework.selenium.api.base.SeleniumBase;
import com.framework.utils.DataLibrary;

import io.restassured.RestAssured;

public class BaseMethods extends SeleniumBase {


	
	@DataProvider(name = "fetchData",indices=0)
	public Object[][] fetchData() throws IOException {
		return DataLibrary.getSheet(excelFileName);
	}
	
	@BeforeMethod
	public void  preCondition() {
		startApp("chrome", false, ConfigurationManager.configuration().getUrl());
		setNode();
		setDom();
		
		RestAssured.authentication = RestAssured.basic(ConfigurationManager.configuration().getUsername(),
				ConfigurationManager.configuration().getPassword());

		RestAssured.baseURI = "https://" + ConfigurationManager.configuration().getBaseURI() + "/"
				+ ConfigurationManager.configuration().getResources() + "/";
	}
	
	@AfterMethod
	public void postCondition() {
		//quit();
	}

	

	
	  

	
	
}
