package com.testleaf.matschie.servicenow.spec.builders;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilders {
	
	private static RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
	
	public static RequestSpecification getTableApiRequestSpec(String tableName) {
		return requestSpecBuilder
				.setBaseUri("https://dev373619.service-now.com")
				.setBasePath("/api/now/table")
				.setAuth(RestAssured.basic("admin", "7d3iJH=K$jYf"))
				.addPathParam("tableName", tableName)
				.build();
	}
	
	public static RequestSpecification getRequestSpec() {
		return requestSpecBuilder.build();
	}

}