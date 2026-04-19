package com.testleaf.matschie.servicenow.steps;

import com.testleaf.matschie.general.utils.TestUtlis;
import com.testleaf.matschie.servicenow.api.services.IncidentService;

import io.cucumber.java.en.When;

public class HttpActionSteps {
	
	IncidentService incidentService = new IncidentService();
	
	@When("method get and endpoint {string}")
	public void method_get_and_endpoint(String endpoint) {
	    incidentService.getAllRecords(TestUtlis.getRequestSpecification(), endpoint);
	}
	
	@When("method post {string}")
	public void method_post(String endpoint) {
	    incidentService.createNewRecord(TestUtlis.getRequestSpecification(), endpoint, null);
	}

}