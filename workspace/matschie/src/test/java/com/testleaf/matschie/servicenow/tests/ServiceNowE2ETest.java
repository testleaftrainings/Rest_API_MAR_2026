package com.testleaf.matschie.servicenow.tests;

import org.testng.annotations.Test;

import com.testleaf.matschie.servicenow.api.services.IncidentService;
import com.testleaf.matschie.servicenow.serialization.pojos.UpdateIncident;

public class ServiceNowE2ETest {
	
	// IncidentService incidentService = new IncidentService();
	/*incidentService.createNewRecord();
	incidentService.validateCreateResponse();
	incidentService.extractSysId("result.sys_id");*/
	
	@Test
	public void createRecord() {		
		new IncidentService()
		    .createNewRecord()
		    .validateCreateResponse()
		    .extractSysId();
	}
	
	@Test
	public void getARecord() {
		new IncidentService()
		     .getARecord()
		     .validateSuccessJsonResponse()
		     .validateSysIdKeyValue();
	}
	
	@Test
	public void testGetAllRecord() {
		new IncidentService()
		     .getAllRecords()
		     .validateSuccessJsonResponse();
	}
	
	@Test
	public void requestChainingTest() {
		UpdateIncident updateIncident = new UpdateIncident();
		updateIncident.setShortDescription("RESTAPIMAR2026");
		updateIncident.setDescription("Update the value using put method");
		updateIncident.setCategory("software");
		
		new IncidentService()
		    .createNewRecord()
		    .validateCreateResponse()
		    .extractSysId()
		    .getARecord()
		    .validateSuccessJsonResponse()
		    .validateSysIdKeyValue()
		    .updateExistingRecord(updateIncident)
		    .validateSuccessJsonResponse()
		    .validateResponeKeyValue("result.short_description", updateIncident.getShortDescription())
		    .validateResponeKeyValue("result.description", updateIncident.getDescription())
		    .validateResponeKeyValue("result.category", updateIncident.getCategory())
		    .deleteExistingRecord()
		    .validateDeleteResponse();
	}

}