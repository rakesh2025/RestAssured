package first;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
@Test
	public void PathParameter() {
		baseURI="http://localhost";
		port=8084;
		
		given()
		.pathParam("ProjId", "TY_PROJ_001")
		
		.when()
		.get("/projects/{ProjId}")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}

}
