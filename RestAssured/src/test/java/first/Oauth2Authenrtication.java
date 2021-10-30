package first;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class Oauth2Authenrtication {
	@Test
	public void oauth() {
		//generate the token
		Response res = given()
		.formParam("client_id", "SDET21-RMGY-RES")
		.formParam("client_secret", "6bb639862f00920c9c4e63acc85f694e")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code ", "authorization_code")
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		res.then().log().all();
		//capture the token
		String token=res.jsonPath().get("access_token");
		System.out.println(token);
		//create a new request to access the token
		given()
		.auth()
		.oauth2(token)
		.pathParam("USER_ID", "2397")
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		.then().log().all();
	}

}
