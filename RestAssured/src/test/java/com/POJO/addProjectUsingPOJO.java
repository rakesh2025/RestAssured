package com.POJO;

import org.testng.annotations.Test;

import com.utility.JavaUtility;

import io.restassured.http.ContentType;
import projectControlerClass.ProjectControlerPOJO;

import  static io.restassured.RestAssured.*;

public class addProjectUsingPOJO {
	@Test
	public void addProjectUsingPOJO() {
		JavaUtility jlib=new JavaUtility();
		baseURI="http://localhost";
		port=8084;
		ProjectControlerPOJO pc=new ProjectControlerPOJO("Rakesh99", "dell"+jlib.getRandoNo(), "Created",41 );
		
		given()
		.contentType(ContentType.JSON)
		.body(pc)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
		
	}

}
