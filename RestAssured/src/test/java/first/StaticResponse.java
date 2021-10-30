package first;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class StaticResponse {
@Test
	public void StaticResponse() {
	String expdata="TY_PROJ_001";
	baseURI="http://localhost";
	port=8084;
	//store all the response
	Response resp = when()
	.get("/projects");
	
	//capture the data using JSON path
	String actdata = resp.jsonPath().get("[0].projectId");
	System.out.println(actdata);
	
	//validate
	Assert.assertEquals(actdata, expdata);
	System.out.println(actdata+"verified");
	resp.then().log().all();
	
		
	}

}
