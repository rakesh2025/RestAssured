package first;

import org.testng.annotations.Test;

import com.utility.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectControlerClass.ProjectControlerPOJO;

import  static io.restassured.RestAssured.*;

public class RequestChaining2 {
	@Test
	public void requestChainingCreateGet() {
		baseURI="http://localhost";
		port=8084;
		
		//first Request to create a project
		JavaUtility jlib =new JavaUtility();
		ProjectControlerPOJO pobj=new ProjectControlerPOJO("Rakesh", "Ty"+jlib.getRandoNo(), "Created", 10);
		Response res = given()
		.contentType(ContentType.JSON)
		.body(pobj)
		.when()
		.post("/addProject");
		//captre the project id
		String myproj = res.jsonPath().get("projectId");
		System.out.println(myproj);
		//pass the proj id in path parameter of another request
		given()
		.pathParam("projId", myproj)
		.when()
		.get("/projects/{projId}")
		//validate
		.then()
		.statusCode(200)
		.log().all();
		
		
	}

}
