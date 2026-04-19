package com.testleaf.makaia.uibank.api.som;

import org.hamcrest.Matchers;

import com.testleaf.makaia.general.utils.TestUtils;
import com.testleaf.makaia.uibank.serialization.pojos.UserCredentials;

import io.restassured.http.ContentType;

public class CreateTokenService extends UiBankApi {
	
	private static final String Resource_PATH = "users/login";
	
	public CreateTokenService() {
		requestBuilder = globalRequest();
	}
	
	public CreateTokenService createToken(String username, String password) {
		UserCredentials userCredentials = new UserCredentials();
		userCredentials.setUsername(username);
		userCredentials.setPassword(password); 	
		
		response = apiClient.post(requestBuilder.setContentType(ContentType.JSON), Resource_PATH, userCredentials);
		return this;
	}
	
	public CreateTokenService validateSuccessResponse() {
		response.then().assertThat()
		        .statusCode(200)
		        .statusLine(Matchers.containsString("OK"))
		        .contentType(ContentType.JSON);
		return this;		
	}
	
	public CreateTokenService extractToken() {
		String id = response.then().extract().jsonPath().getString("id");
		TestUtils.setTestData("token", id);
		return this;
	}

}