package com.testleaf.makaia.uibank.ui.pages;

import com.testleaf.makaia.general.utils.PropertiesHandler;
import com.testleaf.makaia.testng.hooks.ServicenowTestNGHooks;
import com.testleaf.makaia.ui.design.Locators;

public class LoginPage extends ServicenowTestNGHooks {
	
	public LoginPage() {
		loadUrl(PropertiesHandler.config("uibank.frontend.url"));
	}
	
	public LoginPage enterUsername(String username) {
		type(locateElement(Locators.ID, "username"), username);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		type(locateElement(Locators.ID, "password"), password);
		return this;
	}
	
	public LoginPage clicksLoginButton() {
		click(locateElement(Locators.XPATH, "//button[text()='Sign In']"));
		return this;
	}
	
	public AccountPage clicksAgreePrivacyPolicyButton() {
		click(locateElement(Locators.XPATH, "//button[starts-with(text(), 'I agree to the Privacy Policy')]"));
		return new AccountPage();
	}

}