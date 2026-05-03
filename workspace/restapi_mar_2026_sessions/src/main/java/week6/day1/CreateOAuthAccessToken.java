package week6.day1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateOAuthAccessToken {
	
	public static void main(String[] args) {
		String accessToken = RestAssured.given()
		           .baseUri("https://dev373619.service-now.com")
		           .contentType(ContentType.URLENC)
		           .when()
		           .formParam("grant_type", "password")
		           .formParam("client_id", "3d85a62c04a8424f99c8427fb0672209")
		           .formParam("client_secret", "Z+(WhRz@x-1~?PrxGPNaa)1<.Dw,uo+[")
		           .formParam("username", "admin")
		           .formParam("password", "7d3iJH=K$jYf")
		           .post("/oauth_token.do")
		           .then()
		           .statusCode(200)
		           .contentType(ContentType.JSON)
		           .log().all()
		           .extract()
		           .jsonPath()
		           .getString("access_token");
		
		
		RestAssured.given()
		           .baseUri("https://dev373619.service-now.com")
		           .basePath("api/now/table")
		           .pathParam("tableName", "incident")
		           //.header("Authorization", "Bearer "+accessToken)
		           .auth()
		           .oauth2(accessToken)
		           .when()
		           .get("/{tableName}")
		           .then()
		           .assertThat()
		           .statusCode(200)
		           .contentType(ContentType.JSON)
		           .log().all();
		
	}

}
