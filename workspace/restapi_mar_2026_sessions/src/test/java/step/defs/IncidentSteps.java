package step.defs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IncidentSteps {

	private RequestSpecification request = RestAssured.given()
			                                          .filter(new RequestLoggingFilter())
			                                          .filter(new ResponseLoggingFilter())
			                                          .filter(new AllureRestAssured());
	private Response response;

	@Given("baseuri {string}")
	public void baseuri(String baseUri) {
		request.baseUri(baseUri);
	}

	@Given("basepath {string}")
	public void basepath(String basePath) {
		request.basePath(basePath);
	}

	@Given("basic auth username as {string} and password {string}")
	public void basic_auth_username_as_and_password(String username, String password) {
		request.auth().basic(username, password);
	}

	@Given("path varaiable name as {string} and value as {string}")
	public void path_varaiable_name_as_and_value_as(String variableName, String variableValue) {
		request.pathParam(variableName, variableValue);
	}

	@When("method get and endpoint {string}")
	public void method_get_and_endpoint(String endpoint) {
		response = request.get(endpoint);
	}

	@Then("status code {int}")
	public void status_code(Integer statusCode) {
		assertEquals(response.getStatusCode(), statusCode);
	}

	@Given("header key as {string} and {string}")
	public void header_key_as_and(String key, String value) {
		request.header(key, value);
	}

	@Then("response format XML")
	public void response_format_xml() {
		assertTrue(response.getContentType().contains("xml"));
	}	

	@When("request body")
	public void request_body(String requestBody) {
		request.body(requestBody);
	}
	
	@When("method post {string}")
	public void method_post(String endpoint) {
		response = request.post(endpoint);
	}

	@Then("status line Created")
	public void status_line_created() {
		assertTrue(response.getStatusLine().contains("Created"));
	}

	@Then("response format json")
	public void response_format_json() {
		assertTrue(response.getContentType().contains("json"));
	}

}