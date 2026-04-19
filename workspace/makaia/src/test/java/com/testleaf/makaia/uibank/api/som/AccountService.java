package com.testleaf.makaia.uibank.api.som;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import com.testleaf.makaia.general.utils.TestUtils;
import com.testleaf.makaia.uibank.deserialization.pojos.AccountDetails;

import io.restassured.http.ContentType;

public class AccountService extends UiBankApi {
	
private static final String Resource_PATH = "accounts";
	
	public AccountService() {
		requestBuilder = globalRequest();
	}
	
	public AccountService fileterAccountDetailsByNickname(String name) {
		response = apiClient.get(requestBuilder
				      .addHeader("Authorization", "Bearer "+TestUtils.getTestData("token"))
				      .addQueryParam("filter[where][friendlyName]", name)
				      , Resource_PATH);
		return this;
	}
	
	public AccountService validateSuccessResponse() {
		response.then().assertThat()
		        .statusCode(200)
		        .statusLine(Matchers.containsString("OK"))
		        .contentType(ContentType.JSON);
		return this;		
	}
	
	public AccountService validateAccountNumber(String expected) {
		AccountDetails[] accountDetails = deSerializeResponse(response.asPrettyString(), AccountDetails[].class);
		MatcherAssert.assertThat(accountDetails[0].getAccountNumber(), Matchers.equalTo(Integer.parseInt(expected)));
		return this;
	}
	
	public AccountService validateAccountName(String expected) {
		AccountDetails[] accountDetails = deSerializeResponse(response.asPrettyString(), AccountDetails[].class);
		MatcherAssert.assertThat(accountDetails[0].getFriendlyName(), Matchers.equalTo(expected));
		return this;
	}
	
	public AccountService validateAccountType(String expected) {
		AccountDetails[] accountDetails = deSerializeResponse(response.asPrettyString(), AccountDetails[].class);
		MatcherAssert.assertThat(accountDetails[0].getType(), Matchers.equalTo(expected));
		return this;
	}

}