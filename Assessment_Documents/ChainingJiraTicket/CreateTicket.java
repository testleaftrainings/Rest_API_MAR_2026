package ChainingJiraTicket;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateTicket extends BaseClass {

	@Test
	public void create() {
	
		//Form the Request
		
		RequestSpecification inputRequest = RestAssured.given().contentType("application/json")
		.when().body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "    \"project\":\r\n"
				+ "                {\r\n"
				+ "                    \"key\": \"TES\"\r\n"
				+ "                },\r\n"
				+ "    \"summary\": \"Issue1\",\r\n"
				+ "    \"description\": \"Login Failed\",\r\n"
				+ "    \"issuetype\": {\r\n"
				+ "                    \"name\": \"Bug\"\r\n"
				+ "                }\r\n"
				+ "    }\r\n"
				+ "}\r\n"
				+ "");
		
		//Send the Request
		
		Response response = inputRequest.post("issue");
		Bug_ID = response.jsonPath().getInt("id");
		System.out.println(Bug_ID);

        //Assert Status code
           response.then().assertThat().statusCode(Matchers.equalTo(201));
		
	}
}
