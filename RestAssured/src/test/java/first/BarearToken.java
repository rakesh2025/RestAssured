package first;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class BarearToken {
	@Test
	public void barearToken() {
		//create the data
		HashMap map=new HashMap();
		map.put("name", "rakeshsdet21barear_token");
		given()
		.auth()
		.oauth2("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")
		.body(map)
		.when()
		.post("https://api.github.com/user/repos")
		.then().log().all();
	}

}
