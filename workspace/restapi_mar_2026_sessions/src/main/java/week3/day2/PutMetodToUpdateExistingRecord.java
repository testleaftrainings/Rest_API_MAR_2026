package week3.day2;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojos.UpdateIncidet;

import static io.restassured.RestAssured.*;

public class PutMetodToUpdateExistingRecord {
	
	@Test
	public void updateExistIncidentRecord() {
		
		UpdateIncidet updateIncidet = new UpdateIncidet();
		updateIncidet.setDescription("Update the record value by using PUT method");
		updateIncidet.setCategory("Hardware");
		
		given()
		.baseUri("https://dev373619.service-now.com")
		.basePath("/api/now/table")
		.auth()
		.basic("admin", "7d3iJH=K$jYf")
		.contentType(ContentType.JSON)
		.pathParam("tableName", "incident")
		.pathParam("sys_id", "d03705f5934443109ff3fc20ed03d64c")
		.log().all()
		.when()
		.body(updateIncidet)
		.put("/{tableName}/{sys_id}")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}

}