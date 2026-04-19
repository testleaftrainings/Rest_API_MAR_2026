package com.testleaf.makaia.uibank.tests;

import org.testng.annotations.Test;

import com.testleaf.makaia.general.utils.PropertiesHandler;
import com.testleaf.makaia.general.utils.TestUtils;
import com.testleaf.makaia.testng.hooks.UiBankTestNGHooks;
import com.testleaf.makaia.uibank.api.som.AccountService;
import com.testleaf.makaia.uibank.ui.pages.LoginPage;

public class UIBankE2eTest extends UiBankTestNGHooks {	
	
	@Test
	public void createAccountViaUI() {
		new LoginPage()
		    .enterUsername(PropertiesHandler.config("uibank.username"))
		    .enterPassword(PropertiesHandler.secret("uibank.password"))
		    .clicksLoginButton()
		    .clicksAgreePrivacyPolicyButton()
		    .clicksApplyForNewAccountButton()
		    .enterAccountNickName(TestUtils.getTestData("nickName"))
		    .selectSavingsAccount()
		    .clicksApplyButton()
		    .extractAccountNumber()
		    .verfiyAccountName(TestUtils.getTestData("nickName"));
	}
	
	@Test
	public void valdateAccountCreationViaAPI() {
		new AccountService()
		    .fileterAccountDetailsByNickname(TestUtils.getTestData("nickName"))
		    .validateSuccessResponse()
		    .validateAccountNumber(TestUtils.getTestData("accountNumber"))
		    .validateAccountName(TestUtils.getTestData("nickName"))
		    .validateAccountType(TestUtils.getTestData("typeOfAccount"));
	}

}