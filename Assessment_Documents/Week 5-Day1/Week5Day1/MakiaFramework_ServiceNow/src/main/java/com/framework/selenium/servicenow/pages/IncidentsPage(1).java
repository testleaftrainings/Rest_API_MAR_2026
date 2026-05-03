package com.framework.selenium.servicenow.pages;

import org.openqa.selenium.WebElement;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.BaseMethods;

public class IncidentsPage extends BaseMethods {
	
	

	public CreateIncidentPage clickNewOption() {

		switchToFrame(locateShadowElement("//iframe[@title='Main Content']"));
		click(locateElement(Locators.XPATH, "//button[text()='New']"));
		return new CreateIncidentPage();
	}
	
	public UpdatePage searchIncident(String incidentNumber){

		System.out.println(incidentNumber);
		defaultContent();
		WebElement frame = locateShadowElement("//iframe[@title='Main Content']");
		switchToFrame(frame);
        click(locateElement(Locators.XPATH, "//b[text()='All']"));
		typeAndEnter(locateElement(Locators.XPATH, "(//input[@class='form-control'])[1]"), incidentNumber);
		click(locateShadowElement("//a[text()='"+incidentNumber+"']"));
		defaultContent();
		return new UpdatePage();
	}

}
