package com.framework.selenium.servicenow.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.BaseMethods;

public class VerifyIncidentPage extends BaseMethods {

	public VerifyIncidentPage getTheIncident() {
		switchToFrame(locateShadowElement("//iframe[@id='gsft_main']"));
		locateElement(Locators.XPATH, "//select[@class='form-control default-focus-outline']");
		selectDropDownUsingText(locateElement(Locators.XPATH, "//select[@class='form-control default-focus-outline']"),
				"Number");
		typeAndEnter(locateElement(Locators.XPATH, "(//input[@class='form-control'])[1]"), incidentNumber);
		defaultContent();
		return this;
	}

	public VerifyIncidentPage verifyIncidentNumber() {
	
		getElementText(locateElement(Locators.XPATH, "//table[@id='incident_table']/tbody/tr/td[3]/a"));
		return this;
	}
	
	

}
