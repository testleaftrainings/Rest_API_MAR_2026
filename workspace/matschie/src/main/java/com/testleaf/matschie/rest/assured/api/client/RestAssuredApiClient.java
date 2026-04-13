package com.testleaf.matschie.rest.assured.api.client;

import java.io.File;

import com.testleaf.matschie.design.ApiClient;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredApiClient implements ApiClient {
	
	private RequestSpecification given(RequestSpecification requestSpecBuilder) {
		return RestAssured.given()
				          .spec(requestSpecBuilder)
				          .filters(new RequestLoggingFilter(), 
				        		       new ErrorResponseLoggingFilter(),
				        		       new AllureRestAssured());
	}	

	@Override
	public Response get(RequestSpecification requestSpecBuilder, String endPoint) {		
		return given(requestSpecBuilder).get(endPoint);
	}

	@Override
	public Response post(RequestSpecification requestSpecBuilder, String endPoint, Object requestPayload) {
		if(requestPayload instanceof String) {
			 return given(requestSpecBuilder).body((String) requestPayload).post(endPoint);
		 } else if(requestPayload instanceof File) {
			 return given(requestSpecBuilder).body((File) requestPayload).post(endPoint);
		 } else if(requestPayload == null) {
			 return given(requestSpecBuilder).post(endPoint);
		 } else {
			 return given(requestSpecBuilder).body(requestPayload).post(endPoint);
		 }
	}

	@Override
	public Response put(RequestSpecification requestSpecBuilder, String endPoint, Object requestPayload) {
		if(requestPayload instanceof String) {
			 return given(requestSpecBuilder).body((String) requestPayload).put(endPoint);
		 } else if(requestPayload instanceof File) {
			 return given(requestSpecBuilder).body((File) requestPayload).put(endPoint);
		 } else if(requestPayload == null) {
			 return given(requestSpecBuilder).put(endPoint);
		 } else {
			 return given(requestSpecBuilder).body(requestPayload).put(endPoint);
		 }
	}

	@Override
	public Response patch(RequestSpecification requestSpecBuilder, String endPoint, Object requestPayload) {
		if(requestPayload instanceof String) {
			 return given(requestSpecBuilder).body((String) requestPayload).patch(endPoint);
		 } else if(requestPayload instanceof File) {
			 return given(requestSpecBuilder).body((File) requestPayload).patch(endPoint);
		 } else if(requestPayload == null) {
			 return given(requestSpecBuilder).patch(endPoint);
		 } else {
			 return given(requestSpecBuilder).body(requestPayload).patch(endPoint);
		 }
	}

	@Override
	public Response delete(RequestSpecification requestSpecBuilder, String endPoint) {
		return given(requestSpecBuilder).delete(endPoint);
	}

}