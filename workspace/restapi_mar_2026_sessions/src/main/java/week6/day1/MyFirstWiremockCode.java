package week6.day1;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

public class MyFirstWiremockCode {

	public static void main(String[] args) {
		
		// Base URL -> http://localhost:8080
	    // Path -> /welcome-message
		// Full URL -> http://localhost:8080/welcome-message
		MappingBuilder requestMocking = WireMock.get("/welcome-message");
		
		ResponseDefinitionBuilder responseMocking = WireMock.aResponse()
		        .withStatus(200)
		        .withStatusMessage("OK")
		        .withBody("Hello! World");
		
		WireMock.stubFor(requestMocking.willReturn(responseMocking));
		        

	}

}