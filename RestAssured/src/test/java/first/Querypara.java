package first;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Querypara {
	@Test
	public void queryPara() {
		
		baseURI="https://reqres.in";
		given()
		.queryParam("page", 2)
		
		.when()
		.get("/api/users")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}

}
