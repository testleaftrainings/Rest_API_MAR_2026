package com.framework.selenium.servicenow.pages;

import com.framework.config.ConfigurationManager;
import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.BaseMethods;

public class Loginpage extends BaseMethods {
	
	public WelcomePage enterCredentials() {
		String uName = ConfigurationManager.configuration().getUsername();
		String pWord = ConfigurationManager.configuration().getPassword();
		typeAndTab(locateElement(Locators.ID, "user_name"),uName );
		typeAndTab(locateElement(Locators.ID, "user_password"), pWord);
		click(locateElement(Locators.ID, "sysverb_login"));
		return new WelcomePage();
		
	}

}
