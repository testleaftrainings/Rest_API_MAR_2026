package com.framework.servicenow.tests.rest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class LearnShadowDOM {

	@Test
	public void shadow() {
		ChromeDriver driver=new ChromeDriver();
		Shadow shad=new Shadow(driver);
		WebElement eleAll = shad.findElement("//div[text()='All']");
		
		
		
		
		
		
		
		
		
		
		
	}
}
