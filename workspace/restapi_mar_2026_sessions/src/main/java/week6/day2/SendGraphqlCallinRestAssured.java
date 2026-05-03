package week6.day2;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SendGraphqlCallinRestAssured {
	
	static String graphqlQuery = """
			query {
    viewer {
    login
    name
    avatarUrl
    company
    location
    repositories {            
      totalCount
      totalDiskUsage
    }
    followers {
      totalCount      
    }
  }
}
			""";

	public static void main(String[] args) {
		RestAssured.given()
		           .baseUri("https://api.github.com")
		           .basePath("/graphql")
		           .header("Autorization", "Bearer <YOUR-GITHUB-API-KEY>")
		           .contentType(ContentType.JSON)
		           .log().all()
		           .when()
		           .body(convertGraphqlQueryToJsonString(graphqlQuery))
		           .post()
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(200)
		           .contentType(ContentType.JSON);
	}
	
	public static String convertGraphqlQueryToJsonString(String graphqlQuery) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("query", graphqlQuery);
		return jsonObject.toString();
	}

}