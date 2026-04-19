package com.testleaf.matschie.restful.booker.spec.builders;

import static com.testleaf.matschie.general.utils.PropertiesUtlis.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilders {	
	
	public static RequestSpecification getBookerRequestSpec() {
		return getRequestSpecBuilder()
				.setBaseUri(getBaseUri())
				.setBasePath(getBasePath())								
				.build();
	}
	
	public static RequestSpecification getRequestSpec() {
		return getRequestSpecBuilder().build();
	}
	
	private static RequestSpecBuilder getRequestSpecBuilder() {
		return new RequestSpecBuilder();
	}

}