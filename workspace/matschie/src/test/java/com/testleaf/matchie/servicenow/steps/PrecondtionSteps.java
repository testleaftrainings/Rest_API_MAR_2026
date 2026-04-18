package com.testleaf.matchie.servicenow.steps;

import com.testleaf.matschie.general.utils.TestUtlis;
import com.testleaf.matschie.servicenow.spec.builders.RequestSpecBuilders;

import io.cucumber.java.en.Given;
import io.restassured.specification.RequestSpecification;

public class PrecondtionSteps {
	
	private static RequestSpecification request = RequestSpecBuilders.getRequestSpec();

	@Given("baseuri {string}")
	public void baseuri(String baseUri) {
		TestUtlis.setTestContext("requestSpec", request.baseUri(baseUri));
	}

	@Given("basepath {string}")
	public void basepath(String basePath) {
		TestUtlis.setTestContext("requestSpec", request.basePath(basePath));
	}

	@Given("basic auth username as {string} and password {string}")
	public void basic_auth_username_as_and_password(String username, String password) {
		TestUtlis.setTestContext("requestSpec", request.auth().basic(username, password));		
	}

	@Given("path varaiable name as {string} and value as {string}")
	public void path_varaiable_name_as_and_value_as(String variableName, String variableValue) {
		TestUtlis.setTestContext("requestSpec", request.pathParam(variableName, variableValue));
	}
	
	@Given("header key as {string} and {string}")
	public void header_key_as_and(String key, String value) {
	    TestUtlis.setTestContext("requestSpec", request.header(key, value));
	}

}