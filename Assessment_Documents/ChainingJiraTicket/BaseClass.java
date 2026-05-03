package ChainingJiraTicket;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class BaseClass {
  
	public static int Bug_ID;
	public static String incNum;
	@BeforeMethod
	public void setUp() {
		
		//Add Endpoint

		RestAssured.baseURI="https://testjirafeb2023.atlassian.net/rest/api/2/";
		
		//Jira Authentication
		
		RestAssured.authentication=RestAssured.preemptive().basic("Feb2023restAPI@gmail.com", "");
	}
}
