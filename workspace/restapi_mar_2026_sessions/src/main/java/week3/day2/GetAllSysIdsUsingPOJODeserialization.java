package week3.day2;

import org.testng.annotations.Test;

import io.restassured.mapper.ObjectMapperType;
import week3.day2.pojos.IncidentsResponse;
import week3.day2.pojos.Result;

import static io.restassured.RestAssured.*;

import java.util.List;

public class GetAllSysIdsUsingPOJODeserialization {
	
	@Test
	public void getAllSysIds() {
		IncidentsResponse response = given()
		 .baseUri("https://dev373619.service-now.com")
		 .basePath("/api/now/table")
		 .auth()
		 .basic("admin", "7d3iJH=K$jYf")
		 .pathParam("tableName", "incident")
		.when()
		 .get("/{tableName}")
		.then()
		 .assertThat()
		 .statusCode(200)
		 .extract()
		 .as(IncidentsResponse.class, ObjectMapperType.GSON);
		
		List<Result> results = response.getResult();
		
		for (Result result : results) {
			System.out.println(result.getSysId());
		}
		
	}

}