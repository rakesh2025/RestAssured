package com.crudoperationawithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateAResponse {
	@Test
	public void Create() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Rakesh");
		jobj.put("projectName", "RMGYantraproject");
		jobj.put("status", "Created");
		jobj.put("teamSize", 100);
		
		 RequestSpecification reqspe = RestAssured.given();
		 reqspe.contentType(ContentType.JSON);
		 reqspe.body(jobj);
		 
		Response response = reqspe.post("http://localhost:8084/addProject");
		ValidatableResponse validateres = response.then();
		validateres.assertThat().statusCode(201);
		validateres.assertThat().contentType("application/json");
		validateres.log().all();
	}

}
