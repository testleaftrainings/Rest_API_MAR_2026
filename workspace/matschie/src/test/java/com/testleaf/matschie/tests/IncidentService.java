package com.testleaf.matschie.tests;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import com.testleaf.matschie.general.utils.TestUtlis;
import com.testleaf.matschie.rest.assured.api.client.RestAssuredApiClient;
import com.testleaf.matschie.servicenow.deserialization.pojos.TableApiJsonArray;
import com.testleaf.matschie.servicenow.spec.builders.RequestSpecBuilders;
import com.testleaf.matschie.servicenow.spec.builders.ResponseSpecBuilders;

import io.restassured.response.Response;

public class IncidentService {
	
	private static final String TABLENAME = "incident";
	private RestAssuredApiClient apiClient = new RestAssuredApiClient();
	
	public IncidentService getRecords() {
		Response response = apiClient.get(RequestSpecBuilders.getTableApiRequestSpec(TABLENAME), "/{tableName}");
		TestUtlis.setResponse(response);
		return this;
	}
	
	public IncidentService validateSuccessJsonResponse() {
		TestUtlis.getResponse()
		         .then()
		         .spec(ResponseSpecBuilders.successJsonResponse());
		return this;
	}
	
	public IncidentService validateResponseTimeSLA(long expected) {
		MatcherAssert.assertThat(TestUtlis.getResponse().getTime(), Matchers.lessThanOrEqualTo(expected));
		return this;
	}
	
	public IncidentService validateRecordsSize(int expected) {
		TableApiJsonArray tableApiJsonArray = TestUtlis.getResponse()
		         .as(TableApiJsonArray.class);
		MatcherAssert.assertThat(tableApiJsonArray.getResultJsonArray().size(), Matchers.equalTo(expected));
		return this;
	}

}