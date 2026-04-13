package com.testleaf.matschie.servicenow.api.services;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import com.testleaf.matschie.general.utils.TestUtlis;
import com.testleaf.matschie.rest.assured.api.client.RestAssuredApiClient;
import com.testleaf.matschie.servicenow.deserialization.pojos.TableApiJson;
import com.testleaf.matschie.servicenow.spec.builders.RequestSpecBuilders;
import com.testleaf.matschie.servicenow.spec.builders.ResponseSpecBuilders;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IncidentService extends RestAssuredApiClient {
	
	private static final String TABLENAME = "incident";
	
	public IncidentService createNewRecord() {
		Response response = post(RequestSpecBuilders
				                 .getTableApiRequestSpec(TABLENAME)
				                 .contentType(ContentType.JSON)
				                 , "/{tableName}", 
				                 null);
		TestUtlis.setResponse(response);
		return this;
	}
	
	public IncidentService validateCreateResponse() {
		/*assertEquals(TestUtlis.getResponse().getStatusCode(), Status.CREATED.getCode());	
		assertEquals(TestUtlis.getResponse().getStatusLine(), Status.CREATED.getMessage());
		assertTrue(TestUtlis.getResponse().getContentType().contains("json"));*/
		TestUtlis.getResponse()
        .then()
        .spec(ResponseSpecBuilders.successCreateResponse());
		return this;
	}
	
	public IncidentService extractSysId(String jsonPath) {
		String sysId = TestUtlis.getResponse().jsonPath().getString(jsonPath);
		TestUtlis.setTestData("sys_id", sysId);
		return this;
	}
	
	public IncidentService extractSysId() {
		TableApiJson tableApiJson = TestUtlis.getResponse().as(TableApiJson.class);
		TestUtlis.setTestData("sys_id", tableApiJson.getResult().getSysId());
		return this;
	}
	
	public IncidentService getARecord() {
		Response response = get(RequestSpecBuilders.getTableApiRequestSpec(TABLENAME)
				               .pathParam("sys_id", TestUtlis.getTestData("sys_id"))
				               , "/{tableName}/{sys_id}");
		TestUtlis.setResponse(response);
		return this;
	}
	
	public IncidentService validateSuccessJsonResponse() {
		/*assertEquals(TestUtlis.getResponse().getStatusCode(), Status.CREATED.getCode());	
		assertEquals(TestUtlis.getResponse().getStatusLine(), Status.CREATED.getMessage());
		assertTrue(TestUtlis.getResponse().getContentType().contains("json"));*/
		
		/*MatcherAssert.assertThat(TestUtlis.getResponse().getStatusCode(), Matchers.equalTo(Status.CREATED.getCode()));
		MatcherAssert.assertThat(TestUtlis.getResponse().getStatusLine(), Matchers.equalTo(Status.CREATED.getMessage()));
		MatcherAssert.assertThat(TestUtlis.getResponse().getContentType(), Matchers.containsString("json"));*/
		
		TestUtlis.getResponse()
		         .then()
		         .spec(ResponseSpecBuilders.successJsonResponse());
				
		return this;
	}
	
	public IncidentService validateSysIdKeyValue() {
		String actual = TestUtlis.getResponse().as(TableApiJson.class).getResult().getSysId();
		MatcherAssert.assertThat(actual, Matchers.equalTo(TestUtlis.getTestData("sys_id")));
		return this;
	}

}