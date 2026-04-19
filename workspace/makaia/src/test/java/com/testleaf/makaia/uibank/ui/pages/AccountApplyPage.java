package com.testleaf.makaia.uibank.ui.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.testleaf.makaia.general.utils.TestUtils;
import com.testleaf.makaia.testng.hooks.ServicenowTestNGHooks;
import com.testleaf.makaia.ui.design.Locators;

public class AccountApplyPage extends ServicenowTestNGHooks {
	
	public AccountApplyPage() {
		getWait().until(ExpectedConditions.titleIs("UiBank-Apply"));
	}
	
	public AccountApplyPage enterAccountNickName(String nickName) {
		type(locateElement(Locators.ID, "accountNickname"), nickName);
		return this;
	}
	
	public AccountApplyPage selectCheckingAccount() {
		dropdownSelectByValue(locateElement(Locators.ID, "typeOfAccount"), "checking");
		TestUtils.setTestData("typeOfAccount", "checking");
		return this;
	}
	
	public AccountApplyPage selectSavingsAccount() {
		dropdownSelectByValue(locateElement(Locators.ID, "typeOfAccount"), "savings");
		TestUtils.setTestData("typeOfAccount", "savings");
		return this;
	}
	
	public CreationResultPage clicksApplyButton() {
		click(locateElement(Locators.XPATH, "//button[text()='Apply']"));
		return new CreationResultPage();
	}
	

}