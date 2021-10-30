package com.crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CreateprojectJSONfile {
	@Test
	public void createProjectUsingJSONFile() throws FileNotFoundException {
		FileInputStream fis=new FileInputStream("./file.json");
		
		given()
		.contentType(ContentType.JSON)
		.body(fis)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.statusCode(201)
		.log().all();
	}

}
