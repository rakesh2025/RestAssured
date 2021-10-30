package com.POJO;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import projectControlerClass.ProjectControlerPOJO;

public class RMG_API_Authentication01 {
	@Test
	public void CreateProjectWithDuplicateId() {
		baseURI="http://localhost";
		port=8084;
		ProjectControlerPOJO pc=new ProjectControlerPOJO("Rakesh99", "dell02", "Created",41 );
		
		given()
		.contentType(ContentType.JSON)
		.body(pc)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(409)
		.log().all();
		
	}

}
