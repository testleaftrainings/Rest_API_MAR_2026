package week6.day1;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

public class MockingGetRequestWithJsonResponse {

	public static void main(String[] args) {
		
		MappingBuilder requestMocking = WireMock.get("/welcome-message/json");
		
		ResponseDefinitionBuilder responseMocking = WireMock.aResponse()
		        .withStatus(200)
		        .withStatusMessage("OK")
		        .withHeader("Content-Type", "application/json")
		        .withBody("""
		        		{
		        		  "message": "success!",
		        		  "code": 200
		        		}
		        		""");
		
		WireMock.stubFor(requestMocking.willReturn(responseMocking));

	}

}
