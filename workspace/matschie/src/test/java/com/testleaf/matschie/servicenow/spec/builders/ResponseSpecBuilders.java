package com.testleaf.matschie.servicenow.spec.builders;

import com.testleaf.matschie.constant.utls.Status;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecBuilders {
	
	private static ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
	
	public static ResponseSpecification successJsonResponse() {
		return responseSpecBuilder
				.expectStatusCode(Status.OK.getCode())
				.expectStatusLine(Status.OK.getMessage())
				.expectContentType(ContentType.JSON)
				.build();
	}
	
	public static ResponseSpecification successXmlResponse() {
		return responseSpecBuilder
				.expectStatusCode(Status.OK.getCode())
				.expectStatusLine(Status.OK.getMessage())
				.expectContentType(ContentType.XML)
				.build();
	}
	
	public static ResponseSpecification successNoContentResponse() {
		return responseSpecBuilder
				.expectStatusCode(Status.NO_CONTENT.getCode())
				.expectStatusLine(Status.NO_CONTENT.getMessage())
				.build();
	}
	
	public static ResponseSpecification successCreateResponse() {
		return responseSpecBuilder
				.expectStatusCode(Status.CREATED.getCode())
				.expectStatusLine(Status.CREATED.getMessage())
				.expectContentType(ContentType.JSON)
				.build();
	}
	
	public static ResponseSpecification notFoundErrorResponse() {
		return responseSpecBuilder
				.expectStatusCode(Status.NOT_FOUND.getCode())
				.expectStatusLine(Status.NOT_FOUND.getMessage())
				.expectContentType(ContentType.JSON)
				.build();
	}
	
	public static ResponseSpecBuilder getResponseSpecBuilder() {
		return responseSpecBuilder;
	}

}