package week6.day1;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

public class MockingPostRequest {
	
	public static void main(String[] args) {
		
		MappingBuilder requestMocking = WireMock.post("/create/user")
		        .withHeader("Content-Type", WireMock.containing("application/json"))
		        .withRequestBody(WireMock.equalToJson("""
		        		{
		        		  "name": "Karthikeyan",
		        		  "email": "kr@example.com",
		        		  "phoneNumber": "+91-9876543210"
		        		}
		        		"""));
		
		ResponseDefinitionBuilder responseMocking = WireMock.aResponse()
		        .withStatus(201)
		        .withStatusMessage("Created")
		        .withHeader("Content-Type", "application/json")
		        .withBody("""
		        		{
		        		  "message": "User created successfully!",
		        		  "code": 201
		        		}
		        		""");
		
		WireMock.stubFor(requestMocking.willReturn(responseMocking));		
		
	}

}