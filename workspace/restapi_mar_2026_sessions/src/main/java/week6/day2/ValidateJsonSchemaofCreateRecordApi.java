package week6.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import week6.day2.pojos.CreateIncident;

public class ValidateJsonSchemaofCreateRecordApi {
	
	@Test
	public void testSchemaValidation() {
		RestAssured.given()
		           .baseUri("https://dev373619.service-now.com")
		           .basePath("/api/now/table")
		           .auth()
		           .basic("admin", "7d3iJH=K$jYf")
		           .pathParam("tableName", "incident")
		           .contentType(ContentType.JSON)
		           .log().all()
		           .when()
		           .post("/{tableName}")
		           .then()
		           .log().ifValidationFails(LogDetail.ALL)
		           .assertThat()
		           .statusCode(201)
		           .contentType(ContentType.JSON)
		           .body(JsonSchemaValidator.matchesJsonSchema(GenerateJsonSchemaFromPojo.generate(CreateIncident.class)));
	}

}