package com.testleaf.matschie.servicenow.api.services;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import com.testleaf.matschie.general.utils.TestUtlis;
import com.testleaf.matschie.rest.assured.api.client.RestAssuredApiClient;
import com.testleaf.matschie.servicenow.deserialization.pojos.TableApiJson;
import com.testleaf.matschie.servicenow.serialization.pojos.UpdateIncident;
import com.testleaf.matschie.servicenow.spec.builders.RequestSpecBuilders;
import com.testleaf.matschie.servicenow.spec.builders.ResponseSpecBuilders;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IncidentService extends RestAssuredApiClient {
	
	private static final String TABLENAME = "incident";
	
	public void getAllRecords(RequestSpecification requestSpecification, String endpoint) {
		Response get = get(requestSpecification, endpoint);
		TestUtlis.setResponse(get);
	}
	
	public IncidentService getAllRecords() {
		Response get = get(RequestSpecBuilders.getTableApiRequestSpec(TABLENAME), "/{tableName}");
		TestUtlis.setResponse(get);
		return this;
	}
	
	public IncidentService createNewRecord() {
		Response post = post(RequestSpecBuilders
				                 .getTableApiRequestSpec(TABLENAME)
				                 .contentType(ContentType.JSON)
				                 , "/{tableName}", 
				                 null);
		TestUtlis.setResponse(post);
		return this;
	}
	
	public void createNewRecord(RequestSpecification requestSpecification, String endpoint, Object requestPayload) {
		Response post = post(requestSpecification, endpoint, requestPayload);
		TestUtlis.setResponse(post);
	}
	
	/*assertEquals(TestUtlis.getResponse().getStatusCode(), Status.CREATED.getCode());	
	assertEquals(TestUtlis.getResponse().getStatusLine(), Status.CREATED.getMessage());
	assertTrue(TestUtlis.getResponse().getContentType().contains("json"));*/
	public IncidentService validateCreateResponse() {		
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
		Response get = get(RequestSpecBuilders.getTableApiRequestSpec(TABLENAME)
				               .pathParam("sys_id", TestUtlis.getTestData("sys_id"))
				               , "/{tableName}/{sys_id}");
		TestUtlis.setResponse(get);
		return this;
	}	
	
	public IncidentService updateExistingRecord(UpdateIncident updateIncident) {
		Response update = put(RequestSpecBuilders.getTableApiRequestSpec(TABLENAME)
				               .pathParam("sys_id", TestUtlis.getTestData("sys_id"))	
				               .contentType(ContentType.JSON)
				               , "/{tableName}/{sys_id}", updateIncident);
		TestUtlis.setResponse(update);
		return this;
	}
	
	public IncidentService deleteExistingRecord() {
		Response delete = delete(RequestSpecBuilders.getTableApiRequestSpec(TABLENAME)
				                  .pathParam("sys_id", TestUtlis.getTestData("sys_id"))				               
				               , "/{tableName}/{sys_id}");
		TestUtlis.setResponse(delete);
		return this;
	}
	
	/*assertEquals(TestUtlis.getResponse().getStatusCode(), Status.CREATED.getCode());	
	assertEquals(TestUtlis.getResponse().getStatusLine(), Status.CREATED.getMessage());
	assertTrue(TestUtlis.getResponse().getContentType().contains("json"));*/
	
	/*MatcherAssert.assertThat(TestUtlis.getResponse().getStatusCode(), Matchers.equalTo(Status.CREATED.getCode()));
	MatcherAssert.assertThat(TestUtlis.getResponse().getStatusLine(), Matchers.equalTo(Status.CREATED.getMessage()));
	MatcherAssert.assertThat(TestUtlis.getResponse().getContentType(), Matchers.containsString("json"));*/
	public IncidentService validateSuccessJsonResponse() {		
		TestUtlis.getResponse()
		         .then()
		         .spec(ResponseSpecBuilders.successJsonResponse());				
		return this;
	}
	
	public IncidentService validateDeleteResponse() {
		TestUtlis.getResponse()
		         .then()		        
		         .spec(ResponseSpecBuilders.successNoContentResponse());
		return this;
	}
	
	public IncidentService validateSysIdKeyValue() {
		String actual = TestUtlis.getResponse().as(TableApiJson.class).getResult().getSysId();
		MatcherAssert.assertThat(actual, Matchers.equalTo(TestUtlis.getTestData("sys_id")));
		return this;
	}
	
	public IncidentService validateResponeKeyValue(String jsonPath, String expected) {
		MatcherAssert.assertThat(TestUtlis.getResponse().jsonPath().getString(jsonPath), Matchers.equalTo(expected));
		return this;
	}

}