package com.testleaf.matschie.restful.booker.spec.builders;

import com.testleaf.matschie.constant.utls.Status;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecBuilders {	
	
	public static ResponseSpecification successJsonResponse() {		
		return getResponseSpecBuilder()
				.expectStatusCode(Status.OK.getCode())
				.expectStatusLine(Status.OK.getMessage())
				.expectContentType(ContentType.JSON)
				.build();
	}	
	
	public static ResponseSpecification forbiddenErrorResponse() {		
		return getResponseSpecBuilder()
				.expectStatusCode(Status.FORBIDDEN.getCode())
				.expectStatusLine(Status.FORBIDDEN.getMessage())
				.expectContentType(ContentType.JSON)
				.build();
	}
	
	public static ResponseSpecBuilder getResponseSpecBuilder() {
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		return responseSpecBuilder;
	}

}