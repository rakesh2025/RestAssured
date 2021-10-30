package first;

import org.testng.annotations.Test;

import com.utility.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectControlerClass.ProjectControlerPOJO;

import  static io.restassured.RestAssured.*;

public class RequestChaining1 {
	@Test
	public void requestChainingCreateDelete() {
		baseURI="http://localhost";
		port=8084;
		
		//create first request
		JavaUtility jlib =new JavaUtility();
		ProjectControlerPOJO pobj=new ProjectControlerPOJO("Rakesh", "Ty"+jlib.getRandoNo(), "Created", 10);
		Response res = given()
		.contentType(ContentType.JSON)
		.body(pobj)
		.when()
		.post("/addProject");
		//capture the pId of first request
		String myproj = res.jsonPath().get("projectId");
		System.out.println(myproj);
		//pass the pid in second request as a path parameter
		given()
		.pathParam("projId", myproj)
		.when()
		.delete("/projects/{projId}")
		//validate
		.then()
		.statusCode(204)
		.log().all();
		
		
	}

}
