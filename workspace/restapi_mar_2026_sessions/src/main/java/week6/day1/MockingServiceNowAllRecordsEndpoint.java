package week6.day1;

import org.hamcrest.Matchers;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;

public class MockingServiceNowAllRecordsEndpoint {

	public static void main(String[] args) {
		
		WireMockServer server = new WireMockServer();
		server.start();
		
		MappingBuilder requestMocking = WireMock.get("/api/now/table/incident");
		
		ResponseDefinitionBuilder responseMocking = WireMock.aResponse()
		        .withStatus(200)
		        .withStatusMessage("OK")
		        .withHeader("Content-Type", "application/json")
		        .withBodyFile("service-now-all-records-mock-response.json");
		
		server.stubFor(requestMocking.willReturn(responseMocking));	
		
		RestAssured.given()
		           .log().all()
		           .get("http://localhost:8080/api/now/table/incident")
		           .then()
		           .assertThat()
		           .statusCode(200)
		           .statusLine(Matchers.containsString("OK"))
		           .log().all();
		
		server.stop();

	}

}