package ChainingJiraTicket;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTicket extends BaseClass {

	@Test(dependsOnMethods = "ChainingJiraTicket.UpdateTicket.update")
	public void delete() {


		//Send Request
		Response response = RestAssured.delete("incident/"+Bug_ID);
		
		//Print Response code
		int statusCode = response.getStatusCode();
		System.out.println("The Status Code is --------"+statusCode);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
