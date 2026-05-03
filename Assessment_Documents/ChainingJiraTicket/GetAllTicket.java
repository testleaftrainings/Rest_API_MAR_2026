package ChainingJiraTicket;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllTicket extends BaseClass {

	
	@Test(dependsOnMethods = "ChainingJiraTicket.CreateTicket.create")
	public void getTicket() {
		
		
		
		//Send Request
		Response response = RestAssured.get("issuetype");
		
		response.prettyPrint();
		
	}
}
