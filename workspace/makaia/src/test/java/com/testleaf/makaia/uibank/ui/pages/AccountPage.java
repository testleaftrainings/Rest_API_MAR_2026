package com.testleaf.makaia.uibank.ui.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.testleaf.makaia.testng.hooks.ServicenowTestNGHooks;
import com.testleaf.makaia.ui.design.Locators;

public class AccountPage extends ServicenowTestNGHooks {
	
	public AccountPage() {
		getWait().until(ExpectedConditions.titleIs("UiBank - Accounts"));
	}
	
	public AccountApplyPage clicksApplyForNewAccountButton() {
		getWait().until(ExpectedConditions.visibilityOf(locateElement(Locators.XPATH, "//div[normalize-space()='Apply For New Account']")));
		click(locateElement(Locators.XPATH, "//div[normalize-space()='Apply For New Account']"));
		return new AccountApplyPage();
	}

}