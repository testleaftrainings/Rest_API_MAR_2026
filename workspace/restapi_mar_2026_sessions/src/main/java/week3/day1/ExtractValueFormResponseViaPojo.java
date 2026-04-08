package week3.day1;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import pojos.IncidentResponse;

import static io.restassured.RestAssured.*;

import java.io.File;

public class ExtractValueFormResponseViaPojo {
	
	@Test
	public void extractSysId() {
		
		File requestBody = new File("src/main/resources/request_payload/create-incident.json");
		
		IncidentResponse response = given()
		 .baseUri("https://dev373619.service-now.com")
		 .basePath("/api/now/table")
		 .auth()
		 .basic("admin", "7d3iJH=K$jYf")
		 .contentType(ContentType.JSON)
		 .pathParam("tableName", "incident")
		 .when()
		 .body(requestBody)
		 .post("/{tableName}")
		 .then()
		 .log().all()
		 .assertThat()
		 .statusCode(201)
		 .extract()
		 .as(IncidentResponse.class, ObjectMapperType.GSON);
		
		System.out.println(response.getResult().getSysId());
		System.out.println(response.getResult().getOpenedBy().getLink());
		System.out.println(response.getResult().getOpenedBy().getValue());
	}

}