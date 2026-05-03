package ChainingJiraTicket;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateTicket extends BaseClass {

	@Test(dependsOnMethods = "ChainingJiraTicket.GetAllTicket.getTicket") //packagename.className.methodName
	public void update() {

		//Form the Request
		RequestSpecification inputRequest = RestAssured.given().contentType("application/json")
		.when().body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "    \"project\":\r\n"
				+ "                {\r\n"
				+ "                    \"key\": \"TES\"\r\n"
				+ "                },\r\n"
				+ "    \"summary\": \"Issue1\",\r\n"
				+ "    \"description\": \"Login Failed-Home Screeen\",\r\n"
				+ "    \"issuetype\": {\r\n"
				+ "                    \"name\": \"Bug\"\r\n"
				+ "                }\r\n"
				+ "    }\r\n"
				+ "}\r\n"
				+ "");
		//Send the Request
		Response response = inputRequest.put("issue/"+Bug_ID);
		
		//Get status code
		int statusCode = response.getStatusCode();
		System.out.println("Status Code ------"+statusCode);
		
		//Print response
		response.prettyPrint();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
