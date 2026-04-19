package com.testleaf.makaia.uibank.api.som;

import static com.testleaf.makaia.general.utils.PropertiesHandler.config;

import com.google.gson.Gson;
import com.testleaf.makaia.rest.assured.api.client.RestAssuredApiClient;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UiBankApi {
	
	protected RestAssuredApiClient apiClient = new RestAssuredApiClient();	
	protected RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
	protected Response response;
	protected Gson gson = new Gson();
	
	protected RequestSpecBuilder globalRequest() {
		return new RequestSpecBuilder()
				   .setBaseUri(config("uibank.backend.base.uri"))	
				   .setBasePath(config("uibank.backend.base.path")) 
				   .setAccept(ContentType.JSON);
	}
	
	protected <T> T deSerializeResponse(String response, Class<T> classType) {
		return gson.fromJson(response, classType);
	}

}