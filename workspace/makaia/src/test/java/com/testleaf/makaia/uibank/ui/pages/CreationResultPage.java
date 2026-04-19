package com.testleaf.makaia.uibank.ui.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.testleaf.makaia.general.utils.TestUtils;
import com.testleaf.makaia.testng.hooks.ServicenowTestNGHooks;
import com.testleaf.makaia.ui.design.Locators;

public class CreationResultPage extends ServicenowTestNGHooks {
	
	public CreationResultPage() {
		getWait().until(ExpectedConditions.titleIs("UiBank-Creation Result"));
	}
	
	public CreationResultPage extractAccountNumber() {
		TestUtils.setTestData("accountNumber", getElementText(locateElement(Locators.ID, "accountId")).trim());
		return this;
	}
	
	public CreationResultPage verfiyAccountName(String expected) {
		assertEquals(getElementText(locateElement(Locators.ID, "accountName")), expected);
		return this;
	}

}