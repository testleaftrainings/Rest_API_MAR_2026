package com.testleaf.matschie.servicenow.tests;

import org.testng.annotations.Test;

import com.testleaf.matschie.general.utils.TestUtlis;
import com.testleaf.matschie.servicenow.api.services.IncidentService;

public class ServiceNowE2ETest {
	
	// IncidentService incidentService = new IncidentService();
	
	@Test
	public void createRecord() {
		/*incidentService.createNewRecord();
		incidentService.validateCreateResponse();
		incidentService.extractSysId("result.sys_id");*/
		
		new IncidentService()
		    .createNewRecord()
		    .validateCreateResponse()
		    .extractSysId();
		
		System.out.println(TestUtlis.getTestData("sys_id"));
	}
	
	@Test
	public void getARecord() {
		new IncidentService()
		     .getARecord()
		     .validateSuccessJsonResponse()
		     .validateSysIdKeyValue();
	}

}