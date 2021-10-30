package com.crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;


public class CreateProjecthashmap {
	@Test
	public void createProjectUsingHashMap() {
		HashMap map=new HashMap();
		map.put("createdBy", "Rakesh9847");
		map.put("projectName", "tyss177");
		map.put("status", "Created");
		map.put("teamSize", 25);
		
		given()
		.contentType(ContentType.JSON)
		.body(map)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
		
	}

}

	  
	